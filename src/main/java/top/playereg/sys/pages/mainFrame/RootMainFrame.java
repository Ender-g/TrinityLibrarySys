package top.playereg.sys.pages.mainFrame;

import top.playereg.sys.utils.SetFrameTool;

import javax.swing.*;
import java.awt.*;

import static top.playereg.sys.utils.DiyColors.*;

public class RootMainFrame extends JFrame {
    public static void main(String[] args) {
        new RootMainFrame();
    }

    private JLabel rootPanel; // 管理员面板
    private JLabel tittleLabel; // 标题
    private JButton aboutMeButton; // 关于我
    private JButton[] btn;

    public RootMainFrame() {
        /* 设置窗体%start============================================================================ */
        SetFrameTool.setFrame("崔尼蒂图书馆-Root控制面板 v1.0.0", 1200, 720,
                "src/main/java/top/playereg/sys/img/system.png", this);
        /* 设置窗体%end============================================================================ */

        /* 设置Root面板%start======================================================================== */
        rootPanel = new JLabel();
        rootPanel.setLayout(null);
        this.add(rootPanel);
        /* 设置Root面板%end======================================================================== */

        /* 创建组件%start=========================================================================== */
        // LOGO
        SetFrameTool.setPanleBackgroundImg("src/main/java/top/playereg/sys/img/book.png",
                50, 50, 50, 50, rootPanel);

        // 标题
        tittleLabel = new JLabel("系统控制面板");
        SetFrameTool.setFontStyle(tittleLabel, 30, Color.white,
                120, 50, 300, 50, rootPanel);

        // 关于我
        aboutMeButton = new JButton("关于我",  new ImageIcon(
                "src/main/java/top/playereg/sys/img/aboutme.png", "aboutme"));
        aboutMeButton.setBorderPainted(false);
        SetFrameTool.setBtnStyle(aboutMeButton, skyblue, Color.black,
                20, 1000, 50, 150, 50, rootPanel);

        // 菜单按钮
        btn = new JButton[]{
                new JButton("用户管理", new ImageIcon("src/main/java/top/playereg/sys/img/userManage.png"))
                , new JButton("图书管理", new ImageIcon("src/main/java/top/playereg/sys/img/bookManage.png"))
                , new JButton("借阅管理", new ImageIcon("src/main/java/top/playereg/sys/img/borrowManage.png"))
        };
        Color[] color = new Color[]{lightgreen, lightblue, Color.lightGray};
        for (int i = 0; i < btn.length; i++) {
            SetFrameTool.setMenuBtnStyle(btn[i], color[i], Color.black,
                    20, 320+i*200, 300, 150, 150, rootPanel);
        }

        /* 创建组件%end=========================================================================== */

        /* 设置登录背景%start====================================================================== */
        SetFrameTool.setPanleBackgroundImg("src/main/java/top/playereg/sys/img/background_4.png",
                -80, 0, 1280, 720, rootPanel);
        /* 设置登录背景%end====================================================================== */

        setVisible(true); // 显示窗体
    }
}
