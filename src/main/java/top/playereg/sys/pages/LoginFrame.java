/*
 *
 * @author: playereg
 * @description: 登录页面
 * @version: 1.0
 *
 * */

package top.playereg.sys.pages;

import top.playereg.sys.utils.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static top.playereg.sys.utils.DiyColors.*;
import static top.playereg.sys.utils.EmailText.*;
import static top.playereg.sys.utils.EmailTool.durationTime;
import static top.playereg.sys.utils.InputTool.*;

public class LoginFrame extends javax.swing.JFrame implements ActionListener {
    private static long currentTime = 0;
    private String tempCode = null;
    private String tempEmail = null; // 新增字段用于保存发送验证码时的邮箱
    private int tempIsDel = -1;
    private int tempIsRoot = -1;
    /* 声明组件%start================================================================================== */
    private JLabel loginPanel; // 登录面板
    private JLabel titleLabel; // 标题
    private JLabel emailLabel, passwordLabel, emailCodeLabel; // 邮箱、密码、验证码（文本）
    private JTextField emailField, emailCodeField; // 邮箱、验证码（文本框）
    private JPasswordField passwordField; // 密码（输入框）
    private JButton sendEmailCodeBtn, loginBtn, registerBtn, forgetBtn; // 登录、注册、忘记密码（按钮）

    /* 声明组件%end================================================================================== */

    public LoginFrame() {
        /* 设置窗体%start============================================================================ */
        SetFrameTool.setFrame(
                "崔尼蒂图书馆-登录 v1.0.0",
                960, 540,
                "src/main/java/top/playereg/sys/img/book.png",
                this
        );
        /* 设置窗体%end============================================================================ */

        /* 设置登录面板%start======================================================================== */
        loginPanel = new JLabel();
        loginPanel.setLayout(null);
        this.add(loginPanel);
        /* 设置登录面板%end======================================================================== */

        /* 创建组件%start=========================================================================== */
        // 标题
        titleLabel = new JLabel("欢 迎 登 录 本 系 统");
        SetFrameTool.setFontStyle(titleLabel, 30, Color.white,
                500, 80, 500, 50, loginPanel);

        // 邮箱输入
        emailLabel = new JLabel("邮  箱");
        SetFrameTool.setFontStyle(emailLabel, 20, Color.white,
                500, 150, 100, 35, loginPanel);
        emailField = new JTextField();
        SetFrameTool.setFontStyle(emailField, 15, Color.black,
                580, 150, 250, 35, loginPanel);

        // 密码输入
        passwordLabel = new JLabel("密  码");
        SetFrameTool.setFontStyle(passwordLabel, 20, Color.white,
                500, 200, 100, 35, loginPanel);
        passwordField = new JPasswordField();
        SetFrameTool.setFontStyle(passwordField, 10, Color.black,
                580, 200, 250, 35, loginPanel);
        passwordField.setEchoChar('●');

        // 验证码输入
        emailCodeLabel = new JLabel("验证码");
        SetFrameTool.setFontStyle(emailCodeLabel, 20, Color.white,
                500, 250, 100, 35, loginPanel);
        emailCodeField = new JTextField();
        SetFrameTool.setFontStyle(emailCodeField, 15, Color.black,
                580, 250, 100, 35, loginPanel);
        InputTool.jast6NumberInput(emailCodeField); // 限制输入
        emailCodeField.setEditable(false); // 禁止手动输入


        // 发送验证码按钮
        sendEmailCodeBtn = new JButton("发送验证码");
        SetFrameTool.setBtnStyle(sendEmailCodeBtn, darkgreen, Color.white,
                16, 700, 250, 130, 35, loginPanel);

        // 忘记密码按钮
        forgetBtn = new JButton(">>> 忘记密码？点这里 <<<");
        SetFrameTool.setBtnStyle(forgetBtn, lightgreen, darkgreen,
                14, 500, 300, 330, 20, loginPanel);

        //  登录按钮
        loginBtn = new JButton("登  录");
        SetFrameTool.setBtnStyle(loginBtn, Color.yellow, Color.black,
                20, 500, 350, 140, 50, loginPanel);

        // 注册按钮
        registerBtn = new JButton("注  册");
        SetFrameTool.setBtnStyle(registerBtn, skyblue, Color.black,
                20, 690, 350, 140, 50, loginPanel);
        /* 创建组件%end=========================================================================== */

        /* 设置登录背景%start====================================================================== */
        SetFrameTool.setPanleBackgroundImg(
                "src/main/java/top/playereg/sys/img/background_1.png",
                0, -20, 960, 540,
                loginPanel
        );
        /* 设置登录背景%end====================================================================== */

        setVisible(true); // 显示窗体

        /* 监听%start=========================================================================== */
        loginBtn.addActionListener(this); // 登录按钮
        registerBtn.addActionListener(this); // 注册按钮
        forgetBtn.addActionListener(this); // 忘记密码按钮
        sendEmailCodeBtn.addActionListener(this); // 发送验证码按钮
        /* 监听%end=========================================================================== */
    }

    /* 执行监听%start=========================================================================== */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginBtn) {
            // 登录逻辑实现
            System.out.println("登录");
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());
            String emailCode = emailCodeField.getText();
            String currentPassword = null;
            System.out.println("1 " + tempIsDel + " " + tempIsRoot); //test

            String sql = "select * from tb_user where email = ?";

            try (Connection conn = DbUtils.getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, email);
                try (ResultSet rs = ps.executeQuery()) {
                    tempIsDel = -1;
                    tempIsRoot = -1; // 新增重置初始值
                    while (rs.next()) {
                        int currentIsDel = rs.getInt("is_del");
                        if (currentIsDel == 0) {
                            tempIsDel = 0;
                            tempIsRoot = rs.getInt("is_root"); // 新增获取is_root值
                            currentPassword = rs.getString("password");
                            System.out.println("currentPassword: " + currentPassword);
                            System.out.println("2 " + tempIsDel + " " + tempIsRoot); //test
                            break;
                        }
                    }
                }
            } catch (SQLException ex) {
                throw new RuntimeException("数据库查询失败", ex);
            }

            if (email.isEmpty() || password.isEmpty() || emailCode.isEmpty()) {
                JOptionPane.showMessageDialog(this, "请填写完整信息");
            } else if (!email.matches(emailInput)) {
                JOptionPane.showMessageDialog(this, "请输入正确的邮箱");
            } else if (!emailCode.equals(tempCode)) {
                JOptionPane.showMessageDialog(this, "验证码错误");
            } else if (tempEmail != null && !email.equals(tempEmail)) {
                JOptionPane.showMessageDialog(this, "邮箱已更改，请重新发送验证码");
            } else if (currentTime == 0 || (System.currentTimeMillis() - currentTime) > durationTime) {
                JOptionPane.showMessageDialog(this, "验证码已过期");
            } else if (tempIsDel == -1) {
                JOptionPane.showMessageDialog(this, "该邮箱未注册");
            } else {
                System.out.println("成功3 " + tempIsDel + " " + tempIsRoot); //test
                if (HashTool.toHashCode(password).equals(currentPassword)) {
                    if (tempIsRoot == 1) {
                        new RootMainFrame().setVisible(true);
                        this.dispose();
                    } else {
                        new UserMainFrame().setVisible(true);
                        this.dispose();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "密码错误");
                }
            }
        }
        if (e.getSource() == registerBtn) {
            System.out.println("注册");
            currentTime = 0;
            new RegisterFrame().setVisible(true);
            this.dispose(); // 关闭当前窗口
        }
        if (e.getSource() == forgetBtn) {
            System.out.println("忘记密码");
            currentTime = 0;
            new ForgetPasswordFrame().setVisible(true);
            this.dispose();
        }
        if (e.getSource() == sendEmailCodeBtn) {
            System.out.println("发送验证码");
            currentTime = 0;
            if (!(PingNetTool.ping("qq.com") || PingNetTool.ping("bilibili.com"))) {
                JOptionPane.showMessageDialog(this, "我网呢？？？");
            } else if (!PingNetTool.ping("resend.com")) {
                JOptionPane.showMessageDialog(this, "服务器跑路了（bush");
            } else if (emailField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "不要用虚无邮箱！！！");
            } else if (!emailField.getText().matches(emailInput)) {
                JOptionPane.showMessageDialog(this, "这是正确的邮箱地址吗？");
            } else {
                Boolean isSend = EmailTool.sendEmail(
                        "丛雨",
                        "ciallo@email.playereg.top",
                        emailField.getText(),
                        "丛雨来消息了！！！",
                        text2
                );
                if (isSend) {
                    emailCodeField.setEditable(true);
                    currentTime = System.currentTimeMillis();
                    tempCode = code;
                    tempEmail = emailField.getText(); // 记录发送验证码时的邮箱
                    JOptionPane.showMessageDialog(this, "验证码已发送");
                } else {
                    JOptionPane.showMessageDialog(this, "验证码发送失败");

                }
            }
        }
    }

    /* 执行监听%end=========================================================================== */
    public static void main(String[] args) {
        new LoginFrame();
    }
}
