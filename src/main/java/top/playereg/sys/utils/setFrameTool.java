package top.playereg.sys.utils;

import javax.swing.*;

public class setFrameTool extends JFrame {
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
        jFrame.setVisible(false); // 设置窗体可见
        jFrame.setIconImage(new ImageIcon(iconPath).getImage()); //  设置窗体图标
    }
    public static void setPanleBackgroundImg(
            String  imgPath,
            int x,
            int y,
            int width,
            int height,
            JPanel jPanel
    ) {
        JLabel imgLabel = new JLabel(new ImageIcon(imgPath)); // 创建一个标签组件，并将图片设置为标签的图标
        imgLabel.setBounds(x, y, width, height); // 设置图片位置和尺寸
        jPanel.add(imgLabel); // 将图片添加到面板上
    }
}
