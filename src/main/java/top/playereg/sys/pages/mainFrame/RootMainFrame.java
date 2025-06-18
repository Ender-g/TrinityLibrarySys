/*
 *
 * @author: playereg
 * @description: 管理员主面板
 * @version: 1.0
 *
 * */

package top.playereg.sys.pages.mainFrame;

import top.playereg.sys.pages.WorkFunctions.AboutMeFrame;
import top.playereg.sys.pages.WorkFunctions.Root.BookManageFrame.BookManageFrame;
import top.playereg.sys.pages.WorkFunctions.Root.UserManageFrame.UserManageFrame;
import top.playereg.sys.pages.safeFrame.LoginFrame;
import top.playereg.sys.utils.SetFrameTool;
import top.playereg.sys.utils.UserSaveTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static top.playereg.sys.utils.MoreColors.*;

public class RootMainFrame extends JFrame implements ActionListener {
    private JLabel rootPanel; // 管理员面板
    private JLabel tittleLabel; // 标题
    private JButton aboutMeButton; // 关于我
    private JButton[] btn;
    private JButton logoutButton;

    // 在 RootMainFrame 类中添加对应的成员变量来保存窗口实例
    public AboutMeFrame aboutMeFrame;
    public BookManageFrame bookManageFrame;
    public UserManageFrame userManageFrame;

    public RootMainFrame() {
        /* 设置窗体%start============================================================================ */
        SetFrameTool.setFrame("崔尼蒂图书馆-管理面板 v1.0.0", 1200, 720,
                "src/main/java/top/playereg/sys/img/book.png", this);
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
        aboutMeButton = new JButton("关于我", new ImageIcon(
                "src/main/java/top/playereg/sys/img/aboutme1.png", "aboutme"));
        aboutMeButton.setBorderPainted(false);
        SetFrameTool.setBtnStyle(aboutMeButton, skyblue, Color.black,
                20, 1000, 50, 150, 50, rootPanel);

        // 登出
        logoutButton = new JButton("登出", new ImageIcon("src/main/java/top/playereg/sys/img/back2.png"));
        logoutButton.setBorderPainted(false);
        SetFrameTool.setBtnStyle(logoutButton, skyblue, Color.black,
                20, 50, 600, 150, 50, rootPanel);

        // 菜单按钮
        btn = new JButton[]{
                new JButton("用户管理", new ImageIcon("src/main/java/top/playereg/sys/img/userManage.png")),
                new JButton("图书管理", new ImageIcon("src/main/java/top/playereg/sys/img/bookManage.png"))
        };
        Color[] color = new Color[]{lightgreen, lightblue, Color.lightGray};
        for (int i = 0; i < btn.length; i++) {
            SetFrameTool.setImgBtnStyle(btn[i], color[i], Color.black,
                    20, 420 + i * 200, 300, 150, 150, rootPanel);
        }

        /* 创建组件%end=========================================================================== */

        /* 设置登录背景%start====================================================================== */
        SetFrameTool.setPanleBackgroundImg("src/main/java/top/playereg/sys/img/background_4.png",
                -80, 0, 1280, 720, rootPanel);
        /* 设置登录背景%end====================================================================== */

        setVisible(true); // 显示窗体
        aboutMeButton.addActionListener(this);
        logoutButton.addActionListener(this);
        for (JButton button : btn) button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == aboutMeButton) {
            if (aboutMeFrame == null || !aboutMeFrame.isDisplayable()) {
                aboutMeFrame = new AboutMeFrame();
            } else {
                aboutMeFrame.setVisible(true);
            }
        }
        if (e.getSource() == logoutButton) {
            UserSaveTool.clear();
            for (Window window : Window.getWindows()) window.dispose();
            new LoginFrame();
        }
        for (JButton button : btn) {
            if (e.getSource() == button) {
                switch (button.getText()) {
                    case "用户管理":
                        if (userManageFrame == null || !userManageFrame.isVisible()) {
                            userManageFrame = new UserManageFrame();
                            //默认打开
                        } else {
                            userManageFrame.setVisible(true);
                        }
                        break;
                    case "图书管理":
                        if (bookManageFrame == null || !bookManageFrame.isVisible()) {
                            bookManageFrame = new BookManageFrame();
                        } else {
                            bookManageFrame.setVisible(true);
                        }
                        break;
                }
            }
        }
    }
}
