/*
 *
 * @author: playereg
 * @description: 个人中心页面
 * @version: 1.0
 *
 * */

package top.playereg.sys.pages.workFunctions;

import top.playereg.sys.dao.UserDao;
import top.playereg.sys.pages.safeFrame.LoginFrame;
import top.playereg.sys.utils.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static top.playereg.sys.utils.DiyColors.darkgreen;
import static top.playereg.sys.utils.InputTool.passwordInput;
import static top.playereg.sys.utils.SendEmailTool.*;
import static top.playereg.sys.utils.UserSaveTool.*;

public class AboutMeFrame extends JFrame implements ActionListener {
    private static long currentTime = 0;
    private String tempCode = null;

    private JLabel aboutMePanel, titleLabel; // 用户面板
    private JLabel changePasswordTitleLabel, deleteMePanel;
    private JLabel nameLabel, emailLabel, is_rootLabel;
    private JLabel nameText, emailText, is_rootText;
    private JLabel emailCodeLabel;
    private JTextField emailCodeField;
    private JLabel passwordLabel, confirmPasswordLabel;
    private JPasswordField PasswordField, confirmPasswordField;
    private JButton sendEmailCodeBtn, ChangePasswordBtn, deleteBtn;

    public AboutMeFrame() {
        /* 设置窗体%start============================================================================ */
        SetFrameTool.setFrame("个人中心", 600, 600,
                "src/main/java/top/playereg/sys/img/aboutme2.png", this);
        /* 设置窗体%end============================================================================ */

        /* 设置关于我面板%start======================================================================== */
        aboutMePanel = new JLabel();
        aboutMePanel.setLayout(null);
        this.add(aboutMePanel);
        //只能打开一个窗口
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() { // 窗口关闭事件
            public void windowClosing(WindowEvent windowEvent) {
                dispose();
            }
        });
        /* 设置关于我面板%end======================================================================== */

        /* 创建组件%start=========================================================================== */
        // 标题
        titleLabel = new JLabel("个 人 中 心");
        SetFrameTool.setFontStyle(titleLabel, 30, Color.white,
                200, 20, 200, 40, aboutMePanel);
        // 用户信息
        nameLabel = new JLabel("用户名：");
        SetFrameTool.setFontStyle(nameLabel, 20, Color.white,
                50, 100, 100, 30, aboutMePanel);
        nameText = new JLabel(getCurerntLoginUserName());
        SetFrameTool.setFontStyle(nameText, 20, Color.white,
                150, 100, 300, 30, aboutMePanel);
        emailLabel = new JLabel("邮  箱：");
        SetFrameTool.setFontStyle(emailLabel, 20, Color.white,
                50, 150, 100, 30, aboutMePanel);
        emailText = new JLabel(getCurerntLoginUserEmail());
        SetFrameTool.setFontStyle(emailText, 20, Color.white,
                150, 150, 300, 30, aboutMePanel);
        is_rootLabel = new JLabel("权  限：");
        SetFrameTool.setFontStyle(is_rootLabel, 20, Color.white,
                50, 200, 100, 30, aboutMePanel);
        String tempIsRoot = getCurerntLoginUserIsRoot();
        if (tempIsRoot.equals("1")) is_rootText = new JLabel("管理员");
        if (tempIsRoot.equals("0")) is_rootText = new JLabel("普通用户");

        SetFrameTool.setFontStyle(is_rootText, 20, Color.white,
                150, 200, 300, 30, aboutMePanel);
        //  修改密码&删除账户
        changePasswordTitleLabel = new JLabel("=============================================");
        SetFrameTool.setFontStyle(changePasswordTitleLabel, 20, Color.white,
                40, 250, 500, 30, aboutMePanel);

        passwordLabel = new JLabel("新 密 码：");
        SetFrameTool.setFontStyle(passwordLabel, 20, Color.white,
                50, 300, 150, 30, aboutMePanel);
        PasswordField = new JPasswordField();
        SetFrameTool.setFontStyle(PasswordField, 10, Color.black,
                150, 300, 200, 30, aboutMePanel);
        PasswordField.setEchoChar('●');

        confirmPasswordLabel = new JLabel("确认密码：");
        SetFrameTool.setFontStyle(confirmPasswordLabel, 20, Color.white,
                50, 350, 150, 30, aboutMePanel);
        confirmPasswordField = new JPasswordField();
        SetFrameTool.setFontStyle(confirmPasswordField, 10, Color.black,
                150, 350, 200, 30, aboutMePanel);
        confirmPasswordField.setEchoChar('●');

        emailCodeLabel = new JLabel("验 证 码：");
        SetFrameTool.setFontStyle(emailCodeLabel, 20, Color.white,
                50, 400, 150, 30, aboutMePanel);
        emailCodeField = new JTextField();
        SetFrameTool.setFontStyle(emailCodeField, 20, Color.black,
                150, 400, 200, 30, aboutMePanel);
        InputTool.jast6NumberInput(emailCodeField); // 输入限制
        emailCodeField.setEditable(false); // 禁止手动输入

        sendEmailCodeBtn = new JButton(">>> 发送验证码 <<<");
        SetFrameTool.setBtnStyle(sendEmailCodeBtn, darkgreen, Color.white,
                20, 50, 450, 300, 30, aboutMePanel);
        ChangePasswordBtn = new JButton("修改密码");
        SetFrameTool.setBtnStyle(ChangePasswordBtn, Color.yellow, Color.darkGray,
                20, 370, 300, 150, 80, aboutMePanel);
        deleteBtn = new JButton("注销账户");
        SetFrameTool.setBtnStyle(deleteBtn, Color.red, Color.white,
                20, 370, 400, 150, 80, aboutMePanel);
        if (tempIsRoot.equals("1")) {
            deleteBtn.setText("无法注销");
            deleteBtn.setEnabled(false);
        }
        /* 创建组件%end=========================================================================== */

        /* 背景图片%start=========================================================================== */
        SetFrameTool.setPanleBackgroundImg("src/main/java/top/playereg/sys/img/background_aboutme.jpeg",
                -10, 0, 600, 960, aboutMePanel);
        setVisible(true);

        /* 监听%start=========================================================================== */
        ChangePasswordBtn.addActionListener(this);
        deleteBtn.addActionListener(this);
        sendEmailCodeBtn.addActionListener(this);
        /* 监听%end=========================================================================== */
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String emailCode = emailCodeField.getText();
        String email = emailText.getText();
        String newPassword = new String(PasswordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());

        System.out.println("\nemail =" + email
                + "\nnewPassword =" + newPassword
                + "\nconfirmPassword =" + confirmPassword
                + "\n"
        );

        // 修改密码按钮
        if (e.getSource() == ChangePasswordBtn) {
            if (email.isEmpty() || emailCode.isEmpty() || newPassword.isEmpty() || confirmPassword.isEmpty()) {
                JOptionPane.showMessageDialog(this, "不准交白卷！！！ (・`ω´・)");
            } else if (!newPassword.matches(passwordInput) || !confirmPassword.matches(passwordInput)) {
                JOptionPane.showMessageDialog(this, "密码只能是长度6到16位的字母和数字哦！_(¦3」∠)_");
            } else if (!newPassword.equals(confirmPasswordField.getText())) {
                JOptionPane.showMessageDialog(this, "两次输入的密码不是双胞胎吧？ (´⊙ω⊙`)");
            } else if (!emailCode.equals(tempCode)) {
                JOptionPane.showMessageDialog(this, "验证码好像不是这个呀！ (⁰▿⁰)");
            } else if (currentTime == 0 && (currentTime - System.currentTimeMillis()) > durationTime) { // 验证码过期时间 5min
                JOptionPane.showMessageDialog(this, "验证码超过保质期，不能用了！ ಥ_ಥ");
            } else {
                UserDao.updatePassword(email, newPassword);
                currentTime = 0;
                this.dispose();
            }
        }

        // 注销账户按钮
        if (e.getSource() == deleteBtn) {
            if (emailCode.isEmpty()) {
                JOptionPane.showMessageDialog(this, "需要验证码！！！ (・`ω´・)");
            } else if (!emailCode.equals(tempCode)) {
                JOptionPane.showMessageDialog(this, "验证码好像不是这个呀！ (⁰▿⁰)");
            } else if (currentTime == 0 && (currentTime - System.currentTimeMillis()) > durationTime) { // 验证码过期时间 5min
                JOptionPane.showMessageDialog(this, "验证码超过保质期，不能用了！ ಥ_ಥ");
            } else {
                if (JOptionPane.showConfirmDialog(this, "确定注销账户吗？", "注销账户", JOptionPane.YES_NO_OPTION) == 0) {
                    UserDao.deleteUser(getCurerntLoginUserEmail());
                    UserSaveTool.clear();
                    for (Window window : Window.getWindows()) {
                        window.dispose();
                    }
                    new LoginFrame().setVisible(true);
                }
            }
        }

        // 发送验证码按钮
        if (e.getSource() == sendEmailCodeBtn) {
            currentTime = 0;
            String code = (int) ((Math.random() * 9 + 1) * 100000) + "";
            if (!(PingNetTool.ping("qq.com") || PingNetTool.ping("bilibili.com"))) {
                JOptionPane.showMessageDialog(this, "蜘蛛：网，网在哪？我网呢？ (´⊙ω⊙`)");
            } else if (!PingNetTool.ping("resend.com")) {
                JOptionPane.showMessageDialog(this, "服务器居然长腿跑了！！！ (*´д`)");
            } else {
                Boolean isSend = sendEmail(
                        "丛雨",
                        "ciallo@email.playereg.top",
                        email,
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
                    JOptionPane.showMessageDialog(this, "验证码已发送");
                } else {
                    JOptionPane.showMessageDialog(this, "验证码发送失败");
                }
            }
        }
    }
}
