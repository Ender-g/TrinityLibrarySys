package top.playereg.sys.pages;

import top.playereg.sys.utils.SetFrameTool;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static top.playereg.sys.utils.DiyColors.*;

public class ForgetPasswordFrame extends JFrame implements ActionListener {
    /* 声明组件 */
    private JLabel panel;
    private JLabel titleLabel;
    private JLabel emailLabel, oldPasswordLabel, newPasswordLabel, confirmPasswordLabel, codeLabel;
    private JTextField emailField, codeField;
    private JPasswordField oldPasswordField, newPasswordField;
    private JButton getCodeBtn, submitBtn, backBtn;
    
    public ForgetPasswordFrame() {
        /* 设置窗体 */
        SetFrameTool.setFrame(
                "崔尼蒂图书馆-忘记密码 v1.0.0",
                960, 540,
                "src/main/java/top/playereg/sys/img/book.png",
                this
        );
        
        /* 设置面板 */
        panel = new JLabel();
        panel.setLayout(null);
        this.add(panel);
        
        /* 创建组件 */
        // 标题
        titleLabel = new JLabel("重 置 密 码");
        SetFrameTool.setFontStyle(titleLabel, 30, Color.white,
                190, 40, 500, 50, panel);
                
        // 邮箱输入
        emailLabel = new JLabel("邮    箱");
        SetFrameTool.setFontStyle(emailLabel, 20, Color.white,
                100, 120, 150, 35, panel);
        emailField = new JTextField();
        SetFrameTool.setFontStyle(emailField, 20, Color.white,
                200, 120, 250, 35, panel);
        
        // 验证码输入
        codeLabel = new JLabel("验 证 码");
        SetFrameTool.setFontStyle(codeLabel, 20, Color.white,
                100, 180, 150, 35, panel);
        codeField = new JTextField();
        SetFrameTool.setFontStyle(codeField, 20, Color.white,
                200, 180, 100, 35, panel);
        
        // 获取验证码按钮
        getCodeBtn = new JButton("获取验证码");
        SetFrameTool.setBtnStyle(getCodeBtn, darkgreen, Color.white,
                16, 320, 180, 130, 35, panel);
        
        // 旧密码输入
        oldPasswordLabel = new JLabel("旧 密 码");
        SetFrameTool.setFontStyle(oldPasswordLabel, 20, Color.white,
                100, 240, 150, 35, panel);
        oldPasswordField = new JPasswordField();
        SetFrameTool.setFontStyle(oldPasswordField, 20, Color.white,
                200, 240, 250, 35, panel);
        
        // 新密码输入
        newPasswordLabel = new JLabel("新 密 码");
        SetFrameTool.setFontStyle(newPasswordLabel, 20, Color.white,
                100, 300, 150, 35, panel);
        newPasswordField = new JPasswordField();
        SetFrameTool.setFontStyle(newPasswordField, 20, Color.white,
                200, 300, 250, 35, panel);
        
        // 提交按钮
        submitBtn = new JButton(">>> 提 交 <<<");
        SetFrameTool.setBtnStyle(submitBtn, skyblue, Color.black,
                20, 200, 360, 250, 50, panel);
        
        // 返回按钮
        backBtn = new JButton("返回 <<<");
        SetFrameTool.setBtnStyle(backBtn, Color.yellow, Color.black,
                16, 10,10 , 120, 30, panel);
        
        /* 设置背景 */
        SetFrameTool.setPanleBackgroundImg(
                "src/main/java/top/playereg/sys/img/background_3.png",
                0, -20, 960, 540,
                panel
        );
        
        setVisible(true); // 显示窗体
        
        /* 监听 */
        submitBtn.addActionListener(this);
        backBtn.addActionListener(this);
        getCodeBtn.addActionListener(this);
    }

    @Override
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
    public static void main(String[] args) {
        new ForgetPasswordFrame();
    }
}