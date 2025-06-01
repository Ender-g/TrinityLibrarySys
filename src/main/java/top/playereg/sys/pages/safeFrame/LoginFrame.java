/*
 *
 * @author: playereg
 * @description: 登录页面
 * @version: 1.0
 *
 * */

package top.playereg.sys.pages.safeFrame;

import top.playereg.sys.dao.UserDao;
import top.playereg.sys.pages.mainFrame.RootMainFrame;
import top.playereg.sys.pages.mainFrame.UserMainFrame;
import top.playereg.sys.utils.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static top.playereg.sys.utils.DiyColors.*;
import static top.playereg.sys.utils.InputTool.emailInput;
import static top.playereg.sys.utils.InputTool.passwordInput;
import static top.playereg.sys.utils.SendEmailTool.durationTime;

public class LoginFrame extends JFrame implements ActionListener {
    private static long currentTime = 0;
    private String tempCode = null;
    private String tempEmail = null; // 新增字段用于保存发送验证码时的邮箱
    /* 声明组件%start================================================================================== */
    private JLabel loginPanel; // 登录面板
    private JLabel titleLabel; // 标题
    private JLabel emailLabel, passwordLabel, emailCodeLabel; // 邮箱、密码、验证码（文本）
    private JTextField emailField, emailCodeField; // 邮箱、验证码（文本框）
    private JPasswordField passwordField; // 密码（输入框）
    private JButton sendEmailCodeBtn, loginBtn, registerBtn, forgetBtn; // 登录、注册、忘记密码（按钮）
    private JButton GithubBtn, BilibiliBtn;

    /* 声明组件%end================================================================================== */

    public LoginFrame() {
        /* 设置窗体%start============================================================================ */
        SetFrameTool.setFrame("崔尼蒂图书馆-登录 v1.0.0", 960, 540,
                "src/main/java/top/playereg/sys/img/book.png", this);
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

        // Github按钮
        GithubBtn = new JButton();
        GoToMyWeb.goToMyWebBtn("https://github.com/Ender-g/LibrarySys",
                "src/main/java/top/playereg/sys/img/github.png",
                Color.white, 840, 450, 40, 40, loginPanel);
        // Bilibili按钮
        BilibiliBtn = new JButton();
        GoToMyWeb.goToMyWebBtn("https://space.bilibili.com/520500365",
                "src/main/java/top/playereg/sys/img/bilibili.png",
                Color.white, 790, 450, 40, 40, loginPanel);
        /* 创建组件%end=========================================================================== */

        /* 设置登录背景%start====================================================================== */
        SetFrameTool.setPanleBackgroundImg("src/main/java/top/playereg/sys/img/background_1.png",
                0, -20, 960, 540, loginPanel);
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
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        String emailCode = emailCodeField.getText();

        // 登录按钮
        if (e.getSource() == loginBtn) {
            if (email.isEmpty() || password.isEmpty() || emailCode.isEmpty()) {
                JOptionPane.showMessageDialog(this, "不准交白卷！！！ (・`ω´・)");
            } else if (!emailCode.equals(tempCode)) {
                JOptionPane.showMessageDialog(this, "验证码好像不是这个呀！ (⁰▿⁰)");
            } else if ((System.currentTimeMillis() - currentTime) > durationTime) {
                JOptionPane.showMessageDialog(this, "验证码超过保质期，不能用了！ \\(QwQ)/");
            } else if (!passwordField.getText().matches(passwordInput)) {
                JOptionPane.showMessageDialog(this, "密码是6到16位的字母数字组成的哦！");
            } else if (tempEmail != null && !email.equals(tempEmail)) {
                JOptionPane.showMessageDialog(this, "居然当着我的面换邮箱！ (╯•̀ὤ•́)╯");
            } else {
                if (UserDao.login(email, password) && emailCode.equals(tempCode)) {
                    if (UserSaveTool.getCurerntLoginUserIsRoot().equals("0")) {
                        currentTime = 0;
                        new UserMainFrame().setVisible(true);
                        this.dispose();
                    }
                    if (UserSaveTool.getCurerntLoginUserIsRoot().equals("1")) {
                        currentTime = 0;
                        new RootMainFrame().setVisible(true);
                        this.dispose();
                    }
                }
            }
        }
        // 注册按钮
        if (e.getSource() == registerBtn) {
            currentTime = 0;
            new RegisterFrame().setVisible(true);
            this.dispose(); // 关闭当前窗口
        }

        // 忘记密码按钮
        if (e.getSource() == forgetBtn) {
            currentTime = 0;
            new ForgetPasswordFrame().setVisible(true);
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
                                "<h1 style=\"font-size: 18px\">主人，欢迎回来！！！</h1>" +
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

    /* 执行监听%end=========================================================================== */
}
