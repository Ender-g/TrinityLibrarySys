package top.playereg.sys.utils;

import javax.swing.*;

public class MakeFrameTool extends JFrame {
    public MakeFrameTool(
            String title,
            int width,
            int height
    ) {
        // 创建窗口工具
        setTitle(title);
        setSize(width, height);
        setLocationRelativeTo(null); // 设置窗体居中显示
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // 设置窗体关闭时退出程序
        setResizable(false); // 禁止调整窗体大小
    }

    public static void main(String[] args) {
        new MakeFrameTool("测试", 500, 500).setVisible(true);
    }
}
