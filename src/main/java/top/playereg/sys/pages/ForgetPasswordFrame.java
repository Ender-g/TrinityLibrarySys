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

public class ForgetPasswordFrame extends JFrame implements ActionListener {
    /* 声明组件%start================================================================================== */
    private JLabel forgetPasswordLabel; // 忘记密码面板
    private JLabel titleLabel; // 标题
    private JLabel emailLabel, newPasswordLabel, confirmPasswordLabel, codeLabel; // 邮箱、密码、验证码（文本）
    private JTextField emailField, codeField; //  邮箱、验证码（输入框）
    private JPasswordField newPasswordField, confirmPasswordField; // 新密码、确认密码（输入框）
    private JButton getCodeBtn, submitBtn, backBtn; // 获取验证码、提交、返回按钮
    /* 声明组件%end================================================================================== */

    public ForgetPasswordFrame() {
        /* 设置窗体%start============================================================================ */
        SetFrameTool.setFrame(
                "崔尼蒂图书馆-更改密码 v1.0.0",
                960, 540,
                "src/main/java/top/playereg/sys/img/book.png",
                this
        );
        /* 设置窗体%end============================================================================ */

        /* 设置忘记密码面板%start======================================================================== */
        forgetPasswordLabel = new JLabel();
        forgetPasswordLabel.setLayout(null);
        this.add(forgetPasswordLabel);
        /* 设置登录面板%end======================================================================== */

        /* 创建组件%start=========================================================================== */
        // 标题
        titleLabel = new JLabel("更 改 密 码");
        SetFrameTool.setFontStyle(titleLabel, 30, Color.white,
                190, 40, 500, 50, forgetPasswordLabel);

        // 邮箱输入
        emailLabel = new JLabel("邮    箱");
        SetFrameTool.setFontStyle(emailLabel, 20, Color.white,
                100, 120, 150, 35, forgetPasswordLabel);
        emailField = new JTextField();
        SetFrameTool.setFontStyle(emailField, 20, Color.white,
                200, 120, 250, 35, forgetPasswordLabel);

        // 验证码输入
        codeLabel = new JLabel("验 证 码");
        SetFrameTool.setFontStyle(codeLabel, 20, Color.white,
                100, 180, 150, 35, forgetPasswordLabel);
        codeField = new JTextField();
        SetFrameTool.setFontStyle(codeField, 20, Color.white,
                200, 180, 100, 35, forgetPasswordLabel);

        // 获取验证码按钮
        getCodeBtn = new JButton("获取验证码");
        SetFrameTool.setBtnStyle(getCodeBtn, darkgreen, Color.white,
                16, 320, 180, 130, 35, forgetPasswordLabel);

        // 旧密码输入
        newPasswordLabel = new JLabel("新 密 码");
        SetFrameTool.setFontStyle(newPasswordLabel, 20, Color.white,
                100, 240, 150, 35, forgetPasswordLabel);
        newPasswordField = new JPasswordField();
        SetFrameTool.setFontStyle(newPasswordField, 20, Color.white,
                200, 240, 250, 35, forgetPasswordLabel);

        // 新密码输入
        confirmPasswordLabel = new JLabel("确认密码");
        SetFrameTool.setFontStyle(confirmPasswordLabel, 20, Color.white,
                100, 300, 150, 35, forgetPasswordLabel);
        confirmPasswordField = new JPasswordField();
        SetFrameTool.setFontStyle(confirmPasswordField, 20, Color.white,
                200, 300, 250, 35, forgetPasswordLabel);

        // 提交按钮
        submitBtn = new JButton(">>> 确 认 更 改 <<<");
        SetFrameTool.setBtnStyle(submitBtn, skyblue, Color.black,
                20, 200, 360, 250, 50, forgetPasswordLabel);

        // 返回按钮
        backBtn = new JButton("返回 <<<");
        SetFrameTool.setBtnStyle(backBtn, Color.yellow, Color.black,
                16, 10, 10, 120, 30, forgetPasswordLabel);
        /* 创建组件%end=========================================================================== */

        /* 设置登录背景%start====================================================================== */
        SetFrameTool.setPanleBackgroundImg(
                "src/main/java/top/playereg/sys/img/background_3.png",
                0, -20, 960, 540,
                forgetPasswordLabel
        );
        /* 设置登录背景%end====================================================================== */

        setVisible(true); // 显示窗体

        /* 监听%start=========================================================================== */
        submitBtn.addActionListener(this);
        backBtn.addActionListener(this);
        getCodeBtn.addActionListener(this);
        /* 监听%end=========================================================================== */
    }

    @Override
    /* 执行监听%start=========================================================================== */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitBtn) {
            // todo 提交新密码逻辑
            System.out.println("提交密码");
        }
        if (e.getSource() == backBtn) {
            System.out.println("返回");
            new LoginFrame().setVisible(true);
            this.dispose();
        }
        if (e.getSource() == getCodeBtn) {
            // todo 发送验证码逻辑
            System.out.println("获取验证码");
        }
    }
    /* 执行监听%end=========================================================================== */

    public static void main(String[] args) {
        new ForgetPasswordFrame();
    }
}