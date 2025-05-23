package top.playereg.sys.pages;



import top.playereg.sys.utils.SetFrameTool;

import javax.swing.*;

public class RootMainFrame extends JFrame {
    public static void main(String[] args) {
        new RootMainFrame();
    }
    private JLabel RootPanel; // 登录面板
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
        setVisible(true); // 显示窗体

    }
}
