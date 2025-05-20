package top.playereg.sys.utils;

import javax.swing.*;

public class MakeFrameTool extends JFrame {
    public static void setFrame(
        String title,
        int width,
        int height,
        String iconPath,
        JFrame jFrame
    ) {
        jFrame.setTitle(title); // 设置窗体标题
        jFrame.setSize(width, height); // 设置窗体大小
        jFrame.setLocationRelativeTo(null); // 居中显示
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // 设置关闭按钮
        jFrame.setVisible(false);
        jFrame.setIconImage(new ImageIcon(iconPath).getImage());
    }
}
