package top.playereg.sys.pages.workFunctions;

import top.playereg.sys.dao.UserDao;
import top.playereg.sys.pages.safeFrame.LoginFrame;
import top.playereg.sys.utils.PingNetTool;
import top.playereg.sys.utils.SendEmailTool;
import top.playereg.sys.utils.SetFrameTool;
import top.playereg.sys.utils.UserSaveTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static top.playereg.sys.utils.DiyColors.darkgreen;
import static top.playereg.sys.utils.EmailText.*;
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
        addWindowListener(new java.awt.event.WindowAdapter() { // 窗口关闭事件
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
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
                50, 250, 500, 30, aboutMePanel);

        passwordLabel = new JLabel("新 密 码：");
        SetFrameTool.setFontStyle(passwordLabel, 20, Color.white,
                50, 300, 150, 30, aboutMePanel);
        PasswordField = new JPasswordField();
        SetFrameTool.setFontStyle(PasswordField, 20, Color.white,
                150, 300, 200, 30, aboutMePanel);

        confirmPasswordLabel = new JLabel("确认密码：");
        SetFrameTool.setFontStyle(confirmPasswordLabel, 20, Color.white,
                50, 350, 150, 30, aboutMePanel);
        confirmPasswordField = new JPasswordField();
        SetFrameTool.setFontStyle(confirmPasswordField, 20, Color.white,
                150, 350, 200, 30, aboutMePanel);

        emailCodeLabel = new JLabel("验 证 码：");
        SetFrameTool.setFontStyle(emailCodeLabel, 20, Color.white,
                50, 400, 150, 30, aboutMePanel);
        emailCodeField = new JTextField();
        SetFrameTool.setFontStyle(emailCodeField, 20, Color.white,
                150, 400, 200, 30, aboutMePanel);
        sendEmailCodeBtn = new JButton(">>> 发送验证码 <<<");
        SetFrameTool.setBtnStyle(sendEmailCodeBtn, darkgreen, Color.white,
                20, 50, 450, 300, 30, aboutMePanel);
        ChangePasswordBtn = new JButton("修改密码");
        SetFrameTool.setBtnStyle(ChangePasswordBtn, Color.yellow, Color.darkGray,
                20, 370, 300, 150, 80, aboutMePanel);
        deleteBtn = new JButton("注销账户");
        SetFrameTool.setBtnStyle(deleteBtn, Color.red, Color.white,
                20, 370, 400, 150, 80, aboutMePanel);
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
        if (e.getSource() == ChangePasswordBtn) {
            // todo 修改密码
            String email = emailText.getText();
            String emailCode = emailCodeField.getText();
            String newPassword = new String(PasswordField.getPassword());
            String confirmPassword = new String(confirmPasswordField.getPassword());

            if (email.isEmpty() || emailCode.isEmpty() || newPassword.isEmpty() || confirmPassword.isEmpty()) {
                JOptionPane.showMessageDialog(this, "不准交白卷！！！ (・`ω´・)");
            } else if (!newPassword.matches(passwordInput) || !confirmPassword.matches(passwordInput)){
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
            }
        }
        if (e.getSource() == deleteBtn) {
            // todo 注销账户
        }
        if (e.getSource() == sendEmailCodeBtn) {
            currentTime = 0;
            if (!(PingNetTool.ping("qq.com") || PingNetTool.ping("bilibili.com"))) {
                JOptionPane.showMessageDialog(this, "蜘蛛：网，网在哪？我网呢？ (´⊙ω⊙`)");
            } else if (!PingNetTool.ping("resend.com")) {
                JOptionPane.showMessageDialog(this, "服务器居然长腿跑了！！！ (*´д`)");
            } else {
                Boolean isSend = SendEmailTool.sendEmail(
                        "丛雨",
                        "ciallo@email.playereg.top",
                        emailText.getText(),
                        "丛雨来消息了！！！",
                        text2
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
