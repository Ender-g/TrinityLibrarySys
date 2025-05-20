package top.playereg.sys.pages;

import top.playereg.sys.utils.setFrameTool;

import javax.swing.*;

public class LoginFrame extends javax.swing.JFrame {
    private JLabel loginPanel; // 登录面板
    private JLabel emailLabel, passwordLabel, emailCodeLabel; // 邮箱、密码、验证码（文本内容）
    private JTextField emailField, emailCodeField; // 邮箱、验证码（输入框）
    private JPasswordField passwordField; // 密码（输入框）
    private JButton loginBtn, registerBtn, forgetBtn; // 登录、注册、忘记密码（按钮）
    private JLabel backgroundImg; // 背景图片

    public LoginFrame() {
        setFrameTool.setFrame(
                "登录",
                1200,
                800,
                "src/main/java/top/playereg/sys/img/book.png",
                this
        );
        loginPanel = new JLabel();
        loginPanel.setLayout(null);
        this.add(loginPanel);

        setFrameTool.setPanleBackgroundImg(
                "src/main/java/top/playereg/sys/img/background.jpg",
                0,
                0,
                1200,
                800,
                loginPanel
        );
        setVisible(true);
    }
}
