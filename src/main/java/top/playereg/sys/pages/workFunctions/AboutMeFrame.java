package top.playereg.sys.pages.workFunctions;

import top.playereg.sys.pages.mainFrame.UserMainFrame;
import top.playereg.sys.utils.SetFrameTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AboutMeFrame extends JFrame implements ActionListener {
    public static void main(String[] args){
        new AboutMeFrame();
    }

    private JLabel aboutMePanel; // 用户面板
    private JLabel nameLabel,emailLabel;
    private JLabel nameText,emailText;
    private JButton ChangePasswordBtn;

    public AboutMeFrame(){
        /* 设置窗体%start============================================================================ */
        SetFrameTool.setFrame("关于我", 500, 700,
                "src/main/java/top/playereg/sys/img/aboutme2.png", this);
        /* 设置窗体%end============================================================================ */

        /* 设置关于我面板%start======================================================================== */
        aboutMePanel = new JLabel();
        aboutMePanel.setLayout(null);
        this.add(aboutMePanel);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() { // 窗口关闭事件
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                dispose();
            }});
        /* 设置关于我面板%end======================================================================== */

        /* 创建组件%start=========================================================================== */
        nameLabel = new JLabel("用户名：");
        SetFrameTool.setFontStyle(nameLabel, 20, Color.BLACK, 50, 50, 100, 30, aboutMePanel);
        nameText = new JLabel("playereg");
        SetFrameTool.setFontStyle(nameText, 20, Color.BLACK, 150, 50, 300, 30, aboutMePanel);
        emailLabel = new JLabel("邮  箱：");
        SetFrameTool.setFontStyle(emailLabel, 20, Color.BLACK, 50, 100, 100, 30, aboutMePanel);
        emailText = new JLabel("test@test.test");
        SetFrameTool.setFontStyle(emailText, 20, Color.BLACK, 150, 100, 300, 30, aboutMePanel);
        /* 创建组件%end=========================================================================== */
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
