package top.playereg.sys.pages;

import top.playereg.sys.utils.setFrameTool;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends javax.swing.JFrame {
    //调色块
    private Color color1 = new Color(0xFFE4E1);
    private Color color2 = new Color(0xDCDCDC);
    private Color color3 = new Color(0xD2B48C);
    private Color color4 = new Color(0xCD853F);
    private Color color5 = new Color(0xB22222);
    private JLabel loginPanel; // 登录面板
    private JLabel emailLabel, passwordLabel, emailCodeLabel; // 邮箱、密码、验证码（文本内容）
    private JTextField emailField, emailCodeField; // 邮箱、验证码（输入框）
    private JPasswordField passwordField; // 密码（输入框）
    private JButton sendEmailCodeBtn,loginBtn, registerBtn, forgetBtn; // 登录、注册、忘记密码（按钮）
    private JLabel backgroundImg; // 背景图片

    public LoginFrame() {
        //  设置窗体
        setFrameTool.setFrame(
                "崔尼蒂图书馆-登录",
                960, 540,
                "src/main/java/top/playereg/sys/img/book.png",
                this
        );
        loginPanel = new JLabel();
        loginPanel.setLayout(null);
        this.add(loginPanel);

        /* 创建组件%start=========================================================================== */
        // 邮箱输入
        emailLabel  = new JLabel("邮  箱");
        setFrameTool.setFontStyle(emailLabel, 20, Color.white,
                500, 150, 100, 30, loginPanel);
        emailField  = new JTextField();
        setFrameTool.setFontStyle(emailField, 20, Color.black,
                580, 150, 250, 35, loginPanel);
        // 密码输入
        passwordLabel  = new JLabel("密  码");
        setFrameTool.setFontStyle(passwordLabel, 20, Color.white,
                500, 200, 100, 30, loginPanel);
        passwordField  = new JPasswordField();
        setFrameTool.setFontStyle(passwordField, 20, Color.black,
                580, 200, 250, 35, loginPanel);
        // 验证码输入
        emailCodeLabel  = new JLabel("验证码");
        setFrameTool.setFontStyle(emailCodeLabel, 20, Color.white,
                500, 250, 100, 30, loginPanel);
        emailCodeField  = new JTextField();
        setFrameTool.setFontStyle(emailCodeField, 20, Color.black,
                580, 250, 100, 35, loginPanel);
        // 发送验证码按钮
        sendEmailCodeBtn  = new JButton("发送验证码");
        setFrameTool.setBtnStyle(sendEmailCodeBtn, Color.darkGray,Color.white,
                16,700, 250, 130, 35, loginPanel);
        //  登录按钮
        loginBtn  = new JButton("登录");
        setFrameTool.setBtnStyle(loginBtn, Color.yellow,Color.black,
                20,500, 350, 140, 50, loginPanel);
        registerBtn  = new JButton("注册");
        setFrameTool.setBtnStyle(registerBtn, Color.green,Color.black,
                20,690, 350, 140, 50, loginPanel);

        // 设置登录背景
        setFrameTool.setPanleBackgroundImg(
                "src/main/java/top/playereg/sys/img/background.png",
                0,
                -20,
                960,
                540,
                loginPanel
        );
        setVisible(true);
    }
}
