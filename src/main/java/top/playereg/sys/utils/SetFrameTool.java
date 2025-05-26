/*
 *
 * @author: playereg
 * @description: 设置窗体工具类
 * @version: 1.0
 *
 * */

package top.playereg.sys.utils;

import javax.swing.*;
import java.awt.*;

public class SetFrameTool extends JFrame {
    /* 设置窗体工具类 */
    public static void setFrame(
            String title, // 窗体标题
            int width, // 窗体宽度
            int height, // 窗体高度
            String iconPath, // 图标路径
            JFrame Frame // 要设置窗体的对象
    ) {
        Frame.setTitle(title); // 设置窗体标题
        Frame.setSize(width, height); // 设置窗体大小
        Frame.setLocationRelativeTo(null); // 居中显示
        Frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // 设置关闭按钮
        Frame.setResizable(false); // 设置窗体不可拉伸
        Frame.setVisible(false); // 设置窗体可见
        Frame.setIconImage(new ImageIcon(iconPath).getImage()); //  设置窗体图标
    }

    /* 设置面板背景图片工具类 */
    public static void setPanleBackgroundImg(
            String imgPath, // 图片路径
            int x, // 组件x坐标
            int y, // 组件y坐标
            int width, // 组件宽度
            int height, // 组件高度
            JLabel Label // 组件所在面板
    ) {
        ImageIcon icon = new ImageIcon(imgPath);
        Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        icon = new ImageIcon(img);

        JLabel imgLabel = new JLabel(icon); // 使用调整后的图标创建标签
        imgLabel.setBounds(x, y, width, height);
        Label.add(imgLabel);
    }

    /* 设置字体样式工具类 */
    public static void setFontStyle(
            JComponent component, // 组件名称
            int fontSize, // 字体大小
            Color fontColor, // 字体颜色
            int x, // 组件x坐标
            int y, // 组件y坐标
            int width, // 组件宽度
            int height, // 组件高度
            JLabel Panel // 组件所在面板
    ) {
        component.setFont(new Font("黑体", Font.BOLD, fontSize));
        component.setForeground(fontColor);
        component.setBounds(x, y, width, height);
        Panel.add(component);
    }

    /* 设置按钮样式工具类 */
    public static void setBtnStyle(
            JButton jButton, // 按钮名称
            Color btnColor, // 按钮颜色
            Color btnTextColor, // 按钮文字颜色
            int fontSize, // 字体大小
            int x, // 组件x坐标
            int y, // 组件y坐标
            int width, // 组件宽度
            int height, // 组件高度
            JLabel Panel // 组件所在面板
    ) {
        jButton.setBackground(btnColor);
        jButton.setFont(new Font("黑体", Font.BOLD, fontSize));
        jButton.setForeground(btnTextColor);
        jButton.setBounds(x, y, width, height);
        jButton.setBorderPainted(false);
        Panel.add(jButton);
    }

    //菜单按钮
    public static void setTopImgBtnStyle(
            JButton jButton, // 按钮名称
            Color btnColor, // 按钮颜色
            Color btnTextColor, // 按钮文字颜色
            int fontSize, // 字体大小
            int x, // 组件x坐标
            int y, // 组件y坐标
            int width, // 组件宽度
            int height, // 组件高度
            JLabel Panel // 菜单面板
    ) {
        setBtnStyle(jButton, btnColor, btnTextColor, fontSize, x, y, width, height, Panel);
        //文字水平居中，在图片下方
        jButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        jButton.setHorizontalTextPosition(SwingConstants.CENTER);
        //不要边框
        jButton.setBorderPainted(false);
        Panel.add(jButton);
    }
}
