package top.playereg.sys.pages;

import top.playereg.sys.utils.MakeFrameTool;

import javax.swing.*;

public class LoginFrame extends javax.swing.JFrame {

    private JLabel loginpanel; // 登录面板
    private JLabel email ,password, emailCode; // 邮箱，密码，验证码（文本）
    private JTextField emailField, emailCodeField; // 邮箱，密码，验证码（文本输入框）
    private JPasswordField passwordField; // 密码（密码输入框）
    private JButton loginBtn, registerBtn, forgetBtn; // 登录，注册，忘记密码

    public LoginFrame() {

        new MakeFrameTool(
                "src/main/java/top/playereg/sys/img/book.png",
                "千禧年图书",
                1000,
                600
        ).setVisible(true);

    }

    public static void main(String[] args) {
        new LoginFrame();
    }
}
