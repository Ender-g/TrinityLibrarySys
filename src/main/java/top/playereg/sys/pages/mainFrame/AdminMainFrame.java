package top.playereg.sys.pages.mainFrame;

import top.playereg.sys.pages.safeFrame.LoginFrame;
import top.playereg.sys.pages.workFunctions.AboutMeFrame;
import top.playereg.sys.utils.SetFrameTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static top.playereg.sys.utils.DiyColors.*;

public class AdminMainFrame extends JFrame implements ActionListener {
    public static void main(String[] args) {
        new AdminMainFrame();
    }

    private JLabel adminPanel; // 管理员面板
    private JLabel tittleLabel; // 标题
    private JButton aboutMeButton; // 关于我
    private JButton[] btn;
    private JButton logoutButton;

    public AdminMainFrame() {
        /* 设置窗体%start============================================================================ */
        SetFrameTool.setFrame("崔尼蒂图书馆-管理面板 v1.0.0", 1200, 720,
                "src/main/java/top/playereg/sys/img/system.png", this);
        /* 设置窗体%end============================================================================ */

        /* 设置Root面板%start======================================================================== */
        adminPanel = new JLabel();
        adminPanel.setLayout(null);
        this.add(adminPanel);
        /* 设置Root面板%end======================================================================== */

        /* 创建组件%start=========================================================================== */
        // LOGO
        SetFrameTool.setPanleBackgroundImg("src/main/java/top/playereg/sys/img/book.png",
                50, 50, 50, 50, adminPanel);

        // 标题
        tittleLabel = new JLabel("系统控制面板");
        SetFrameTool.setFontStyle(tittleLabel, 30, Color.white,
                120, 50, 300, 50, adminPanel);

        // 关于我
        aboutMeButton = new JButton("关于我",  new ImageIcon(
                "src/main/java/top/playereg/sys/img/aboutme1.png", "aboutme"));
        aboutMeButton.setBorderPainted(false);
        SetFrameTool.setBtnStyle(aboutMeButton, skyblue, Color.black,
                20, 1000, 50, 150, 50, adminPanel);

        // 登出
        logoutButton = new JButton("登出",  new ImageIcon("src/main/java/top/playereg/sys/img/back2.png"));
        logoutButton.setBorderPainted(false);
        SetFrameTool.setBtnStyle(logoutButton, skyblue, Color.black,
                20, 50, 600, 150, 50, adminPanel);

        // 菜单按钮
        btn = new JButton[]{
                new JButton("用户管理", new ImageIcon("src/main/java/top/playereg/sys/img/userManage.png"))
                , new JButton("图书管理", new ImageIcon("src/main/java/top/playereg/sys/img/bookManage.png"))
                , new JButton("借阅管理", new ImageIcon("src/main/java/top/playereg/sys/img/borrowManage.png"))
        };
        Color[] color = new Color[]{lightgreen, lightblue, Color.lightGray};
        for (int i = 0; i < btn.length; i++) {
            SetFrameTool.setTopImgBtnStyle(btn[i], color[i], Color.black,
                    20, 320+i*200, 300, 150, 150, adminPanel);
        }

        /* 创建组件%end=========================================================================== */

        /* 设置登录背景%start====================================================================== */
        SetFrameTool.setPanleBackgroundImg("src/main/java/top/playereg/sys/img/background_4.png",
                -80, 0, 1280, 720, adminPanel);
        /* 设置登录背景%end====================================================================== */

        setVisible(true); // 显示窗体
        aboutMeButton.addActionListener(this);
        logoutButton.addActionListener(this);
        for (JButton button : btn) button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == aboutMeButton) {
            System.out.println("关于我");
            new AboutMeFrame();
        }
        if (e.getSource() == logoutButton) {
            System.out.println("登出");
            this.dispose();
            new LoginFrame();
        }
        for (JButton button : btn){
            if (e.getSource() == button) {
                System.out.println(button.getText());
                switch (button.getText()) {
//                    case "用户管理" -> new UserManageFrame();
//                    case "图书管理" -> new BookManageFrame();
//                    case "借阅管理" -> new BorrowManageFrame();
                }
            }
        }
    }
}
