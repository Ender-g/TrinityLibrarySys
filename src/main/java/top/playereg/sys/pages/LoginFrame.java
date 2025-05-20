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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static top.playereg.sys.utils.DiyColors.*;
import static top.playereg.sys.utils.SendEmailTool.sendEmail;

public class LoginFrame extends javax.swing.JFrame implements ActionListener {
    /* 声明组件%start================================================================================== */
    private JLabel loginPanel; // 登录面板
    private JLabel titleLabel; // 标题
    private JLabel emailLabel, passwordLabel, emailCodeLabel; // 邮箱、密码、验证码（文本）
    private JTextField emailField, emailCodeField; // 邮箱、验证码（文本框）
    private JPasswordField passwordField; // 密码（输入框）
    private JButton sendEmailCodeBtn, loginBtn, registerBtn, forgetBtn; // 登录、注册、忘记密码（按钮）
    private JLabel backgroundImg; // 背景图片
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
        SetFrameTool.setFontStyle(emailField, 20, Color.black,
                580, 150, 250, 35, loginPanel);

        // 密码输入
        passwordLabel = new JLabel("密  码");
        SetFrameTool.setFontStyle(passwordLabel, 20, Color.white,
                500, 200, 100, 35, loginPanel);
        passwordField = new JPasswordField();
        SetFrameTool.setFontStyle(passwordField, 20, Color.black,
                580, 200, 250, 35, loginPanel);

        // 验证码输入
        emailCodeLabel = new JLabel("验证码");
        SetFrameTool.setFontStyle(emailCodeLabel, 20, Color.white,
                500, 250, 100, 35, loginPanel);
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
            // todo 登录
            System.out.println("登录");
        }
        if (e.getSource() == registerBtn) {
            System.out.println("注册");
            new RegisterFrame().setVisible(true);
            this.dispose(); // 关闭当前窗口
        }
        if (e.getSource() == forgetBtn) {
            System.out.println("忘记密码");
            new ForgetPasswordFrame().setVisible(true);
            this.dispose();
        }
        if (e.getSource() == sendEmailCodeBtn) {
            // todo 发送验证码
            System.out.println("发送验证码");
        }
    }
    /* 执行监听%end=========================================================================== */
    public static void main(String[] args) {
        new LoginFrame();
    }
}
