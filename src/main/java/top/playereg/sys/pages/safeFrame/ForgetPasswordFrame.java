/*
 *
 * @author: playereg
 * @description: 忘记密码界面
 * @version: 1.0
 *
 * */

package top.playereg.sys.pages.safeFrame;

import top.playereg.sys.dao.UserDao;
import top.playereg.sys.utils.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static top.playereg.sys.utils.DiyColors.*;
import static top.playereg.sys.utils.SendEmailTool.durationTime;
import static top.playereg.sys.utils.InputTool.emailInput;
import static top.playereg.sys.utils.InputTool.passwordInput;


public class ForgetPasswordFrame extends JFrame implements ActionListener {
    private static long currentTime = 0;
    private String tempCode = null;
    private String tempEmail = null; // 新增字段用于保存发送验证码时的邮箱
    private int tempIsDel = 1;
    /* 声明组件%start================================================================================== */
    private JLabel forgetPasswordLabel; // 忘记密码面板
    private JLabel titleLabel; // 标题
    private JLabel emailLabel, newPasswordLabel, confirmPasswordLabel, emailCodeLabel; // 邮箱、密码、验证码（文本）
    private JTextField emailField, emailCodeField; //  邮箱、验证码（输入框）
    private JPasswordField newPasswordField, confirmPasswordField; // 新密码、确认密码（输入框）
    private JButton sendEmailCodeBtn, submitBtn, backBtn; // 获取验证码、提交、返回按钮
    /* 声明组件%end================================================================================== */

    public ForgetPasswordFrame() {
        /* 设置窗体%start============================================================================ */
        SetFrameTool.setFrame(
                "崔尼蒂图书馆-重置密码 v1.0.0",
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
        titleLabel = new JLabel("重 置 密 码");
        SetFrameTool.setFontStyle(titleLabel, 30, Color.white,
                190, 40, 500, 50, forgetPasswordLabel);

        // 邮箱输入
        emailLabel = new JLabel("邮    箱");
        SetFrameTool.setFontStyle(emailLabel, 20, Color.white,
                100, 120, 150, 35, forgetPasswordLabel);
        emailField = new JTextField();
        SetFrameTool.setFontStyle(emailField, 15, Color.black,
                200, 120, 250, 35, forgetPasswordLabel);

        // 验证码输入
        emailCodeLabel = new JLabel("验 证 码");
        SetFrameTool.setFontStyle(emailCodeLabel, 20, Color.white,
                100, 180, 150, 35, forgetPasswordLabel);
        emailCodeField = new JTextField();
        SetFrameTool.setFontStyle(emailCodeField, 15, Color.black,
                200, 180, 100, 35, forgetPasswordLabel);
        InputTool.jast6NumberInput(emailCodeField); // 输入限制
        emailCodeField.setEditable(false); // 禁止手动输入

        // 获取验证码按钮
        sendEmailCodeBtn = new JButton("获取验证码");
        SetFrameTool.setBtnStyle(sendEmailCodeBtn, darkgreen, Color.white,
                16, 320, 180, 130, 35, forgetPasswordLabel);

        // 旧密码输入
        newPasswordLabel = new JLabel("新 密 码");
        SetFrameTool.setFontStyle(newPasswordLabel, 20, Color.white,
                100, 240, 150, 35, forgetPasswordLabel);
        newPasswordField = new JPasswordField();
        SetFrameTool.setFontStyle(newPasswordField, 10, Color.black,
                200, 240, 250, 35, forgetPasswordLabel);
        newPasswordField.setEchoChar('●');

        // 新密码输入
        confirmPasswordLabel = new JLabel("确认密码");
        SetFrameTool.setFontStyle(confirmPasswordLabel, 20, Color.white,
                100, 300, 150, 35, forgetPasswordLabel);
        confirmPasswordField = new JPasswordField();
        SetFrameTool.setFontStyle(confirmPasswordField, 10, Color.black,
                200, 300, 250, 35, forgetPasswordLabel);
        confirmPasswordField.setEchoChar('●');

        // 提交按钮
        submitBtn = new JButton(">>> 确 认 重 置 <<<");
        SetFrameTool.setBtnStyle(submitBtn, skyblue, Color.black,
                20, 200, 360, 250, 50, forgetPasswordLabel);

        // 返回按钮
        backBtn = new JButton("返回",new ImageIcon("src/main/java/top/playereg/sys/img/back1.png"));
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
        sendEmailCodeBtn.addActionListener(this);
        /* 监听%end=========================================================================== */
    }

    @Override
    /* 执行监听%start=========================================================================== */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitBtn) {
            String email = emailField.getText();
            String emailCode = emailCodeField.getText();
            String newPassword = new String(newPasswordField.getPassword());
            String confirmPassword = new String(confirmPasswordField.getPassword());

            if (email.isEmpty() || emailCode.isEmpty() || newPassword.isEmpty() || confirmPassword.isEmpty()) {
                JOptionPane.showMessageDialog(this, "不准交白卷！！！ (・`ω´・)");
            } else if (!newPassword.matches(passwordInput) || !confirmPassword.matches(passwordInput)){
                JOptionPane.showMessageDialog(this, "密码只能是长度6到16位的字母和数字哦！_(¦3」∠)_");
            } else if (!newPassword.equals(confirmPasswordField.getText())) {
                JOptionPane.showMessageDialog(this, "两次输入的密码不是双胞胎吧？ (´⊙ω⊙`)");
            } else if (tempEmail != null && !email.equals(tempEmail)) { // 新增邮箱变更校验
                JOptionPane.showMessageDialog(this, "居然当着我的面换邮箱！ (╯•̀ὤ•́)╯");
            } else if (!emailCode.equals(tempCode)) {
                JOptionPane.showMessageDialog(this, "验证码好像不是这个呀！ (⁰▿⁰)");
            } else if (currentTime == 0 && (currentTime - System.currentTimeMillis()) > durationTime) { // 验证码过期时间 5min
                JOptionPane.showMessageDialog(this, "验证码超过保质期，不能用了！ ಥ_ಥ");
            } else {
                UserDao.updatePassword(email, newPassword);
                currentTime = 0;
                new LoginFrame().setVisible(true);
                this.dispose();
            }
        }
        if (e.getSource() == backBtn) {
            new LoginFrame().setVisible(true);
            this.dispose();
        }
        if (e.getSource() == sendEmailCodeBtn) {
            currentTime = 0;
            String code = (int) ((Math.random() * 9 + 1) * 100000) + "";
            if (!(PingNetTool.ping("qq.com") || PingNetTool.ping("bilibili.com"))) {
                JOptionPane.showMessageDialog(this, "蜘蛛：网，网在哪？我网呢？ (´⊙ω⊙`)");
            } else if (!PingNetTool.ping("resend.com")) {
                JOptionPane.showMessageDialog(this, "服务器居然长腿跑了！！！ (*´д`)");
            } else if (emailField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "居然是！皇帝的新邮箱！！！ ( ×ω× )");
            } else if (!emailField.getText().matches(emailInput)) {
                JOptionPane.showMessageDialog(this, "这个长得像邮箱吗？ (*´･д･)?");
            } else {
                Boolean isSend = SendEmailTool.sendEmail(
                        "丛雨",
                        "ciallo@email.playereg.top",
                        emailField.getText(),
                        "丛雨来消息了！！！",
                        "<h1 style=\"font-size: 18px\">Ciallo～(∠・ω< )⌒☆</h1>" +
                                "<h1 style=\"font-size: 18px\">主人，您需要更改密码吗？</h1>" +
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
                    tempEmail = emailField.getText(); // 记录发送验证码时的邮箱
                    JOptionPane.showMessageDialog(this, "验证码已发送");
                } else {
                    JOptionPane.showMessageDialog(this, "验证码发送失败");

                }
            }
        }
    }
    /* 执行监听%end=========================================================================== */

    public static void main(String[] args) {
        new ForgetPasswordFrame();
    }
}