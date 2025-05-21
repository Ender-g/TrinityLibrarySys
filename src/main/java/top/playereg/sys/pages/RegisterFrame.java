/*
 *
 * @author: playereg
 * @description: 注册页面
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


public class RegisterFrame extends javax.swing.JFrame implements ActionListener {
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

        // 邮箱验证码输入
        emailCodeLabel = new JLabel("验 证 码");
        SetFrameTool.setFontStyle(emailCodeLabel, 20, Color.white,
                100, 240, 150, 35, registerPanel);
        emailCodeField = new JTextField();
        SetFrameTool.setFontStyle(emailCodeField, 15, Color.black,
                200, 240, 100, 35, registerPanel);

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
                16, 10,10 , 120, 30, registerPanel);
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

    /* 执行监听%start=========================================================================== */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerBtn) {
            // todo 创建账号
            System.out.println("创建账号");
        }
        if (e.getSource() == backBtn) {
            System.out.println("返回");
            new LoginFrame().setVisible(true);
            this.dispose();
        }
        if (e.getSource() == sendEmailCodeBtn) {
            // todo 发送验证码
            System.out.println("发送验证码");
        }
    }
    /* 执行监听%end=========================================================================== */
    public static void main(String[] args) {
        new RegisterFrame();

    }
}
