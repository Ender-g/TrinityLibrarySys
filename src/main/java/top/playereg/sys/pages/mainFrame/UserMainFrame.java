package top.playereg.sys.pages.mainFrame;

import top.playereg.sys.utils.SetFrameTool;

import javax.swing.*;
import java.awt.*;

import static top.playereg.sys.utils.DiyColors.skyblue;

public class UserMainFrame extends JFrame {
    public static void main(String[] args) {new UserMainFrame();} // test

    private JLabel userPanel; // 用户面板
    private JLabel tittleLabel; // 标题
    private JButton aboutMeButton; // 关于我
    private JButton[] btn;

    public UserMainFrame() {
        /* 设置窗体%start============================================================================ */
        SetFrameTool.setFrame("崔尼蒂图书馆-User业务面板 v1.0.0", 1200, 720,
                "src/main/java/top/playereg/sys/img/user.png", this);
        /* 设置窗体%end============================================================================ */

        /* 设置Root面板%start======================================================================== */
        userPanel = new JLabel();
        userPanel.setLayout(null);
        this.add(userPanel);
        /* 设置Root面板%end======================================================================== */

        /* 创建组件%start=========================================================================== */
        // LOGO
        SetFrameTool.setPanleBackgroundImg("src/main/java/top/playereg/sys/img/book.png",
                50, 50, 50, 50, userPanel);

        // 标题
        tittleLabel = new JLabel("系统业务面板");
        SetFrameTool.setFontStyle(tittleLabel, 30, Color.white,
                120, 50, 300, 50, userPanel);

        // 关于我
        aboutMeButton = new JButton("关于我",  new ImageIcon(
                "src/main/java/top/playereg/sys/img/aboutme.png", "aboutme"));
        aboutMeButton.setBorderPainted(false);
        SetFrameTool.setBtnStyle(aboutMeButton, skyblue, Color.black,
                20, 1000, 50, 150, 50, userPanel);
        /* 创建组件%end=========================================================================== */

        /* 设置登录背景%start====================================================================== */
        SetFrameTool.setPanleBackgroundImg("src/main/java/top/playereg/sys/img/background_4.png",
                0, 0, 1280, 720, userPanel);
        /* 设置登录背景%end====================================================================== */

        setVisible(true); // 显示窗体
    }
}
