/*
 *
 * @author: playereg
 * @description: 注册页面
 * @version: 1.0
 *
 * */

package top.playereg.sys.pages.safeFrame;

import top.playereg.sys.dao.UserDao;
import top.playereg.sys.entity.User;
import top.playereg.sys.utils.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static top.playereg.sys.utils.DiyColors.darkgreen;
import static top.playereg.sys.utils.DiyColors.skyblue;
import static top.playereg.sys.utils.InputTool.*;
import static top.playereg.sys.utils.SendEmailTool.durationTime;

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
        backBtn = new JButton("返回", new ImageIcon("src/main/java/top/playereg/sys/img/back1.png"));
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
        new RegisterFrame();
    }

    /* 执行监听%start=========================================================================== */

    /* 执行监听%end=========================================================================== */
    @Override
    public void actionPerformed(ActionEvent e) {
        String name = nameField.getText();
        String email = emailField.getText();
        String emailCode = emailCodeField.getText();
        String password = PasswordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        System.out.println("name: " + name +
                "\nemail: " + email +
                "\npassword: " + password +
                "\nconfirmPassword: " + confirmPassword
                + "\n"
        );

        // 注册按钮
        if (e.getSource() == registerBtn) {
            if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || emailCode.isEmpty()) {
                JOptionPane.showMessageDialog(this, "不准交白卷！！！ (・`ω´・)");
            } else if (!name.matches(nameInput)) {
                JOptionPane.showMessageDialog(this, "用户名只能是长度小于16位的字母和数字哦！_(¦3」∠)_");
            } else if (!password.matches(passwordInput) || !confirmPassword.matches(passwordInput)) {
                JOptionPane.showMessageDialog(this, "密码只能是长度6到16位的字母和数字哦！_(¦3」∠)_");
            } else if (!password.equals(confirmPasswordField.getText())) {
                JOptionPane.showMessageDialog(this, "两次输入的密码不是双胞胎吧？ (´⊙ω⊙`)");
            } else if (tempEmail != null && !email.equals(tempEmail)) {
                JOptionPane.showMessageDialog(this, "居然当着我的面换邮箱！ (╯•̀ὤ•́)╯");
            } else if (!emailCode.equals(tempCode)) {
                JOptionPane.showMessageDialog(this, "验证码好像不是这个呀！ (⁰▿⁰)");
            } else if (currentTime == 0 && (currentTime - System.currentTimeMillis()) > durationTime) { // 验证码过期时间 5min
                JOptionPane.showMessageDialog(this, "验证码超过保质期，不能用了！ ಥ_ಥ");
            } else if (UserDao.register(new User(
                    0, name, password, email,
                    "0", "0", "0", "0"
            ))) {
                currentTime = 0;
                new LoginFrame().setVisible(true);
                this.dispose();
            }
        }

        // 返回按钮
        if (e.getSource() == backBtn) {
            new LoginFrame().setVisible(true);
            this.dispose();
        }

        // 发送验证码按钮
        if (e.getSource() == sendEmailCodeBtn) {
            currentTime = 0;
            String code = (int) ((Math.random() * 9 + 1) * 100000) + "";
            if (!(PingNetTool.ping("qq.com") || PingNetTool.ping("bilibili.com"))) {
                JOptionPane.showMessageDialog(this, "蜘蛛：网，网在哪？我网呢？ (´⊙ω⊙`)");
            } else if (!PingNetTool.ping("resend.com")) {
                JOptionPane.showMessageDialog(this, "服务器居然长腿跑了！！！ (*´д`)");
            } else if (email.isEmpty()) {
                JOptionPane.showMessageDialog(this, "居然是！皇帝的新邮箱！！！ ( ×ω× )");
            } else if (!email.matches(emailInput)) {
                JOptionPane.showMessageDialog(this, "这个长得像邮箱吗？ (*´･д･)?");
            } else {
                Boolean isSend = SendEmailTool.sendEmail(
                        "丛雨",
                        "ciallo@email.playereg.top",
                        email,
                        "丛雨来消息了！！！",
                        "<h1 style=\"font-size: 18px\">Ciallo～(∠・ω< )⌒☆</h1>" +
                                "<h1 style=\"font-size: 18px\">主人，欢迎加入我们！！！</h1>" +
                                "<h1 style=\"font-size: 18px\">您的验证码是：</h1>" +
                                "<div style=\"font-size: 50px;text-align: center;margin-top: 70px;\">" + code + "</div>" +
                                "<div style=\"font-size: 13px;text-align: center;margin-top: 100px;\">" +
                                "主人的验证码5分钟内有效，请不要外传哦！</div>" +
                                "<div style=\"font-size: 13px;text-align: center;margin-top: 20px;\">" +
                                "请勿回复此邮件，此邮件为系统自动发送，请勿回复。</div>"
                );
                if (isSend) {
                    emailCodeField.setEditable(true);
                    currentTime = System.currentTimeMillis();
                    tempCode = code;
                    tempEmail = email; // 记录发送验证码时的邮箱
                    JOptionPane.showMessageDialog(this, "验证码已发送");
                } else {
                    JOptionPane.showMessageDialog(this, "验证码发送失败");
                }
            }
        }
    }
}
