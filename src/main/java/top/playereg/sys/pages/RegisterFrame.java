/*
 *
 * @author: playereg
 * @description: 注册页面
 * @version: 1.0
 *
 * */

package top.playereg.sys.pages;

import top.playereg.sys.dao.UserDao;
import top.playereg.sys.entity.User;
import top.playereg.sys.utils.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static top.playereg.sys.utils.DiyColors.darkgreen;
import static top.playereg.sys.utils.DiyColors.skyblue;
import static top.playereg.sys.utils.EmailText.code;
import static top.playereg.sys.utils.EmailText.text1;
import static top.playereg.sys.utils.EmailTool.durationTime;
import static top.playereg.sys.utils.InputTool.*;

public class RegisterFrame extends javax.swing.JFrame implements ActionListener {
    private static long currentTime = 0;
    private String tempCode = null;
    private String tempEmail = null; // 新增字段用于保存发送验证码时的邮箱
    private int tempIsDel = 1;

    /* 声明组件%start================================================================================== */
    private JLabel registerPanel;
    private JLabel titleLabel;
    private JLabel nameLabel, emailLabel, passwordLabel, confirmPasswordLabel, emailCodeLabel; // 用户名、邮箱、密码、确认密码、验证码（文本）
    private JTextField nameField, emailField, emailCodeField; // 用户名、邮箱、验证码（文本框）
    private JPasswordField PasswordField, confirmPasswordField; //  密码、确认密码（密码框）
    private JButton sendEmailCodeBtn, registerBtn, backBtn; // 发送验证码、注册、返回（按钮）
    private JLabel backgroundImg; // 背景图片

    /* 声明组件%end================================================================================== */

    public RegisterFrame() {
        /* 设置窗体%start============================================================================ */
        SetFrameTool.setFrame(
                "崔尼蒂图书馆-注册 v1.0.0",
                960, 540,
                "src/main/java/top/playereg/sys/img/book.png",
                this
        );
        /* 设置窗体%end============================================================================ */

        /* 设置登录面板%start======================================================================== */
        registerPanel = new JLabel();
        registerPanel.setLayout(null);
        this.add(registerPanel);
        /* 设置登录面板%end======================================================================== */

        /* 创建组件%start=========================================================================== */
        // 标题
        titleLabel = new JLabel("注 册 账 号");
        SetFrameTool.setFontStyle(titleLabel, 30, Color.white,
                190, 40, 500, 50, registerPanel);

        // 用户名输入
        nameLabel = new JLabel("用 户 名");
        SetFrameTool.setFontStyle(nameLabel, 20, Color.white,
                100, 120, 150, 35, registerPanel);
        nameField = new JTextField();
        SetFrameTool.setFontStyle(nameField, 15, Color.black,
                200, 120, 250, 35, registerPanel);

        // 邮箱输入
        emailLabel = new JLabel("邮    箱");
        SetFrameTool.setFontStyle(emailLabel, 20, Color.white,
                100, 180, 150, 35, registerPanel);
        emailField = new JTextField();
        SetFrameTool.setFontStyle(emailField, 15, Color.black,
                200, 180, 250, 35, registerPanel);

        // 密码输入
        passwordLabel = new JLabel("创建密码");
        SetFrameTool.setFontStyle(passwordLabel, 20, Color.white,
                100, 300, 150, 35, registerPanel);
        PasswordField = new JPasswordField();
        SetFrameTool.setFontStyle(PasswordField, 10, Color.black,
                200, 300, 250, 35, registerPanel);
        PasswordField.setEchoChar('●');

        // 确认密码输入
        confirmPasswordLabel = new JLabel("确认密码");
        SetFrameTool.setFontStyle(confirmPasswordLabel, 20, Color.white,
                100, 360, 150, 35, registerPanel);
        confirmPasswordField = new JPasswordField();
        SetFrameTool.setFontStyle(confirmPasswordField, 10, Color.black,
                200, 360, 250, 35, registerPanel);
        confirmPasswordField.setEchoChar('●');


        // 验证码输入
        emailCodeLabel = new JLabel("验 证 码");
        SetFrameTool.setFontStyle(emailCodeLabel, 20, Color.white,
                100, 240, 150, 35, registerPanel);
        emailCodeField = new JTextField();
        SetFrameTool.setFontStyle(emailCodeField, 15, Color.black,
                200, 240, 100, 35, registerPanel);
        InputTool.jast6NumberInput(emailCodeField); // 输入限制
        emailCodeField.setEditable(false); // 禁止手动输入

        // 发送验证码按钮
        sendEmailCodeBtn = new JButton("发送验证码");
        SetFrameTool.setBtnStyle(sendEmailCodeBtn, darkgreen, Color.white,
                16, 320, 240, 130, 35, registerPanel);

        // 注册按钮
        registerBtn = new JButton(">>> 创 建 账 号 <<<");
        SetFrameTool.setBtnStyle(registerBtn, skyblue, Color.black,
                20, 200, 420, 250, 50, registerPanel);

        // 返回按钮
        backBtn = new JButton("返回 <<<");
        SetFrameTool.setBtnStyle(backBtn, Color.yellow, Color.black,
                16, 10, 10, 120, 30, registerPanel);
        /* 创建组件%end=========================================================================== */

        /* 设置登录背景%start====================================================================== */
        SetFrameTool.setPanleBackgroundImg(
                "src/main/java/top/playereg/sys/img/background_2.png",
                0, -20, 960, 540
                , registerPanel
        );
        /* 设置登录背景%end====================================================================== */

        setVisible(true); // 显示窗体

        /* 监听%start=========================================================================== */
        registerBtn.addActionListener(this);
        backBtn.addActionListener(this);
        sendEmailCodeBtn.addActionListener(this);
        /* 监听%end=========================================================================== */
    }

    public static void main(String[] args) {
        System.out.println("当前时间：" + currentTime);
        new RegisterFrame();
    }

    /* 执行监听%start=========================================================================== */

    /* 执行监听%end=========================================================================== */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerBtn) {
            System.out.println("创建账号");
            String name = nameField.getText();
            String email = emailField.getText();
            String password = PasswordField.getText();
            String confirmPassword = confirmPasswordField.getText();
            String emailCode = emailCodeField.getText();

            String sql = "select * from tb_user where email = ?";
            try (Connection conn = DbUtils.getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, email);
                try (ResultSet rs = ps.executeQuery()) {
                    tempIsDel = 1; // 重置初始值
                    while (rs.next()) {
                        int currentIsDel = rs.getInt("is_del");
                        if (currentIsDel == 0) {
                            tempIsDel = 0;
                            break; // 发现0立即终止检查
                        }
                    }
                }
            } catch (SQLException ex) {
                throw new RuntimeException("数据库查询失败", ex);
            }
            System.out.println("tempIsDel = " + tempIsDel);
            if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || emailCode.isEmpty()) {
                JOptionPane.showMessageDialog(this, "请填写完整信息");
            } else if (!name.matches(nameInput) || !email.matches(emailInput) ||
                    !password.matches(passwordInput) || !confirmPassword.matches(passwordInput)) {
                if (!name.matches(nameInput)) {
                    JOptionPane.showMessageDialog(this, "请输入正确的用户名");
                } else if (!email.matches(emailInput)) {
                    JOptionPane.showMessageDialog(this, "请输入正确的邮箱");
                } else if (!password.matches(passwordInput) || !confirmPassword.matches(passwordInput)) {
                    JOptionPane.showMessageDialog(this, "请输入正确的密码");
                }
            } else if (!password.equals(confirmPasswordField.getText())) {
                JOptionPane.showMessageDialog(this, "两次密码不一致");
            } else if (tempEmail != null && !email.equals(tempEmail)) { // 新增邮箱变更校验
                JOptionPane.showMessageDialog(this, "邮箱已更改，请重新发送验证码");
            } else if (!emailCode.equals(tempCode)) {
                JOptionPane.showMessageDialog(this, "验证码错误");
            } else if (currentTime == 0 && (currentTime - System.currentTimeMillis()) > durationTime) { // 验证码过期时间 5min
                JOptionPane.showMessageDialog(this, "验证码已过期");
            } else {
                if (tempIsDel == 1) {
                    UserDao.register(new User(
                            0,
                            nameField.getText(),
                            HashTool.toHashCode(password),
                            emailField.getText(),
                            "0",
                            "0"
                    ));
                    currentTime = 0;
                    new LoginFrame().setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "该邮箱已被注册");
                }
            }
        }
        if (e.getSource() == backBtn) {
            System.out.println("返回");
            new LoginFrame().setVisible(true);
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
                        text1
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
}
