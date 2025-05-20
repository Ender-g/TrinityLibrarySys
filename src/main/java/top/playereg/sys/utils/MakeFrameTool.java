package top.playereg.sys.utils;

import javax.swing.*;

public class MakeFrameTool extends JFrame {
    public static void MakeFrame(
            String img,
            String title,
            int width,
            int height,
            JFrame jFrame
    ) {
        // 创建窗口工具
        jFrame.setTitle(title);
        jFrame.setSize(width, height);
        jFrame.setLocationRelativeTo(null); // 设置窗体居中显示
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // 设置窗体关闭时退出程序
        jFrame.setResizable(false); // 禁止调整窗体大小
        jFrame.setIconImage(new ImageIcon(img).getImage());
        jFrame.setVisible(true);
    }

}
