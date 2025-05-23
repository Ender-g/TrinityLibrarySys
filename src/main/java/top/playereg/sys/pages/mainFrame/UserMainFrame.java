package top.playereg.sys.pages.mainFrame;

import top.playereg.sys.utils.SetFrameTool;

import javax.swing.*;

public class UserMainFrame extends JFrame {
    public static void main(String[] args) {new UserMainFrame();} // test

    private JLabel UserPanel; // 登录面板
    public UserMainFrame() {
        SetFrameTool.setFrame(
                "崔尼蒂图书馆-User业务面板 v1.0.0",
                1280,
                720,
                "src/main/java/top/playereg/sys/img/book.png",
                this
        );

        UserPanel = new JLabel();
        UserPanel.setLayout(null);
        this.add(UserPanel);

        SetFrameTool.setPanleBackgroundImg(
                "src/main/java/top/playereg/sys/img/background_4.png",
                0, 0, 1280, 720,
                UserPanel
        );
        setVisible(true); // 显示窗体

    }
}
