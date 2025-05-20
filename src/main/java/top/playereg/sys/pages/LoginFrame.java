/*
 *
 * @author: playereg
 * @description: 登录页面
 * @version: 1.0
 *
 * */

package top.playereg.sys.pages;

import top.playereg.sys.utils.SetFrameTool;

import javax.swing.*;
import java.awt.*;

import static top.playereg.sys.utils.DiyColors.*;

public class LoginFrame extends javax.swing.JFrame {
    // 组件
    private JLabel loginPanel; // 登录面板
    private JLabel titleLabel;
    private JLabel emailLabel, passwordLabel, emailCodeLabel; // 邮箱、密码、验证码（文本内容）
    private JTextField emailField, emailCodeField; // 邮箱、验证码（输入框）
    private JPasswordField passwordField; // 密码（输入框）
    private JButton sendEmailCodeBtn, loginBtn, registerBtn, forgetBtn; // 登录、注册、忘记密码（按钮）
    private JLabel backgroundImg; // 背景图片

    public LoginFrame() {
        //  设置窗体
        SetFrameTool.setFrame(
                "崔尼蒂图书馆-登录",
                960, 540,
                "src/main/java/top/playereg/sys/img/book.png",
                this
        );
        loginPanel = new JLabel();
        loginPanel.setLayout(null);
        this.add(loginPanel);

        /* 创建组件%start=========================================================================== */
        titleLabel = new JLabel("欢 迎 登 录 本 系 统");
        SetFrameTool.setFontStyle(titleLabel, 30, Color.white,
                500, 80, 500, 50, loginPanel);
        // 邮箱、密码、验证码输入
        emailLabel = new JLabel("邮  箱");
        SetFrameTool.setFontStyle(emailLabel, 20, Color.white,
                500, 150, 100, 30, loginPanel);
        emailField = new JTextField();
        SetFrameTool.setFontStyle(emailField, 20, Color.black,
                580, 150, 250, 35, loginPanel);
        passwordLabel = new JLabel("密  码");
        SetFrameTool.setFontStyle(passwordLabel, 20, Color.white,
                500, 200, 100, 30, loginPanel);
        passwordField = new JPasswordField();
        SetFrameTool.setFontStyle(passwordField, 20, Color.black,
                580, 200, 250, 35, loginPanel);
        emailCodeLabel = new JLabel("验证码");
        SetFrameTool.setFontStyle(emailCodeLabel, 20, Color.white,
                500, 250, 100, 30, loginPanel);
        emailCodeField = new JTextField();
        SetFrameTool.setFontStyle(emailCodeField, 20, Color.black,
                580, 250, 100, 35, loginPanel);
        // 发送验证码按钮
        sendEmailCodeBtn = new JButton("发送验证码");
        SetFrameTool.setBtnStyle(sendEmailCodeBtn, darkgreen, Color.white,
                16, 700, 250, 130, 35, loginPanel);
        // 忘记密码按钮
        forgetBtn = new JButton(">>> 忘记密码？点这里 <<<");
        SetFrameTool.setBtnStyle(forgetBtn, lightgreen, darkgreen,
                14, 500, 300, 330, 20, loginPanel);
        //  登录&注册按钮
        loginBtn = new JButton("登  录");
        SetFrameTool.setBtnStyle(loginBtn, Color.yellow, Color.black,
                20, 500, 350, 140, 50, loginPanel);
        registerBtn = new JButton("注  册");
        SetFrameTool.setBtnStyle(registerBtn, skyblue, Color.black,
                20, 690, 350, 140, 50, loginPanel);

        // 设置登录背景
        SetFrameTool.setPanleBackgroundImg(
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
