package top.playereg.sys.utils;

import javax.swing.*;
import java.awt.*;

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
        jFrame.setResizable(false); // 设置窗体不可拉伸
        jFrame.setVisible(false); // 设置窗体可见
        jFrame.setIconImage(new ImageIcon(iconPath).getImage()); //  设置窗体图标
    }

    public static void setPanleBackgroundImg(
            String imgPath,
            int x,
            int y,
            int width,
            int height,
            JLabel jLabel
    ) {
        ImageIcon icon = new ImageIcon(imgPath);
        Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        icon = new ImageIcon(img);
        
        JLabel imgLabel = new JLabel(icon); // 使用调整后的图标创建标签
        imgLabel.setBounds(x, y, width, height);
        jLabel.add(imgLabel);
    }
}
