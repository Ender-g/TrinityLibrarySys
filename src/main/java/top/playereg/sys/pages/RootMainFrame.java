package top.playereg.sys.pages;



import top.playereg.sys.utils.SetFrameTool;

import javax.swing.*;
import java.awt.*;


public class RootMainFrame extends JFrame {





    public static void main(String[] args) {
        new RootMainFrame();
    }
    private JLabel RootPanel; // 登录面板
    private JButton[] btn;//菜单

    public RootMainFrame() {
        SetFrameTool.setFrame(
                "崔尼蒂图书馆-Root控制面板 v1.0.0",
                1280,
                720,
                "src/main/java/top/playereg/sys/img/book.png",
                this
        );

        RootPanel = new JLabel();
        RootPanel.setLayout(null);
        this.add(RootPanel);

        SetFrameTool.setPanleBackgroundImg(
                "src/main/java/top/playereg/sys/img/background_4.png",
                0, 0, 1280, 720,
                RootPanel
        );

        btn = new JButton[3];

        btn[0] = new JButton("用户管理", SetFrameTool.resizeImageIcon("src/main/java/top/playereg/sys/img/yonghu.png", 30, 30));
        SetFrameTool.setMenuBtnStyle(btn[0], new Color(0xFFB700), Color.white, 20, 310, 250, 180, 130, RootPanel);

        btn[1] = new JButton("图书管理", SetFrameTool.resizeImageIcon("src/main/java/top/playereg/sys/img/book.png", 30, 30));
        SetFrameTool.setMenuBtnStyle(btn[1], new Color(0xFFB700), Color.white, 20, 510, 250, 180, 130, RootPanel);

        btn[2] = new JButton("个人管理", SetFrameTool.resizeImageIcon("src/main/java/top/playereg/sys/img/xitong.png", 30, 30));
        SetFrameTool.setMenuBtnStyle(btn[2], new Color(0xFFB700), Color.white, 20, 710, 250, 180, 130, RootPanel);

        // 刷新面板，保证所有按钮立即绘制
        RootPanel.revalidate();
        RootPanel.repaint();

        setVisible(true); // 显示窗体

    }
}
