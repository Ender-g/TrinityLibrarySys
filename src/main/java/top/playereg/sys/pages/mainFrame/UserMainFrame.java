/*
 *
 * @author: playereg
 * @description: 用户业务主面板
 * @version: 1.0
 *
 * */

package top.playereg.sys.pages.mainFrame;

import top.playereg.sys.pages.WorkFunctions.AboutMeFrame;
import top.playereg.sys.pages.WorkFunctions.User.MyBorrowFrame.MyBorrowFrame;
import top.playereg.sys.pages.WorkFunctions.User.UserWorkFrame.UserWorkFrame;
import top.playereg.sys.pages.safeFrame.LoginFrame;
import top.playereg.sys.utils.SetFrameTool;
import top.playereg.sys.utils.UserSaveTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static top.playereg.sys.utils.MoreColors.*;

public class UserMainFrame extends JFrame implements ActionListener {

    private JLabel userPanel; // 用户面板
    private JLabel tittleLabel; // 标题
    private JButton aboutMeButton; // 关于我
    private JButton[] btn;
    private JButton logoutButton;
    // 在 UserMainFrame 类中添加对应的成员变量来保存窗口实例
    private AboutMeFrame aboutMeFrame;
    private UserWorkFrame userWorkFrame;
    private MyBorrowFrame myBorrowFrame;

    public UserMainFrame() {
        /* 设置窗体%start============================================================================ */
        SetFrameTool.setFrame("崔尼蒂图书馆-业务面板 v1.0.0", 1200, 720,
                "src/main/java/top/playereg/sys/img/book.png", this);
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
                "src/main/java/top/playereg/sys/img/aboutme1.png", "aboutme"));
        aboutMeButton.setBorderPainted(false);
        SetFrameTool.setBtnStyle(aboutMeButton, skyblue, Color.black,
                20, 1000, 50, 150, 50, userPanel);

        // 登出
        logoutButton = new JButton("登出",  new ImageIcon("src/main/java/top/playereg/sys/img/back2.png"));
        logoutButton.setBorderPainted(false);
        SetFrameTool.setBtnStyle(logoutButton, skyblue, Color.black,
                20, 50, 600, 150, 50, userPanel);
        // 菜单按钮
        btn = new JButton[]{
                new JButton("业务功能", new ImageIcon("src/main/java/top/playereg/sys/img/borrow.png", "works")),
                new JButton("我的借阅", new ImageIcon("src/main/java/top/playereg/sys/img/myborrow.png", "myborrow"))
        };
        Color[] color = new Color[]{lightgreen, lightblue, Color.lightGray};
        for (int i = 0; i < btn.length; i++) {
            SetFrameTool.setImgBtnStyle(btn[i], color[i], Color.black,
                    20, 420 + i * 200, 300, 150, 150, userPanel);
        }
        /* 创建组件%end=========================================================================== */

        /* 设置登录背景%start====================================================================== */
        SetFrameTool.setPanleBackgroundImg("src/main/java/top/playereg/sys/img/background_4.png",
                0, 0, 1280, 720, userPanel);
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
        for (JButton button : btn){
            if (e.getSource() == button) {
                switch (button.getText()) {
                    case "业务功能":
                        if (userWorkFrame == null || !userWorkFrame.isDisplayable()) {
                            userWorkFrame = new UserWorkFrame();
                        } else {
                            userWorkFrame.setVisible(true);
                        }
                        break;
                    case "我的借阅":
                        if (myBorrowFrame == null || !myBorrowFrame.isDisplayable()) {
                            myBorrowFrame = new MyBorrowFrame();
                        } else {
                            myBorrowFrame.setVisible(true);
                        }
                        break;
                }
            }
        }
    }
}
