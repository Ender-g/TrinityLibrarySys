package top.playereg.sys.pages;

import top.playereg.sys.utils.MakeFrameTool;

public class LoginFrame extends javax.swing.JFrame {
    public LoginFrame() {
        new MakeFrameTool(
                "src/main/java/top/playereg/sys/img/book.png",
                "千禧年图书",
                1000,
                600
        ).setVisible(true);
    }

    public static void main(String[] args) {
        new LoginFrame();
    }
}
