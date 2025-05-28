package top.playereg.sys.pages.WorkFunctions.Root;

import top.playereg.sys.utils.SetFrameTool;
import top.playereg.sys.utils.DiyColors;

import javax.swing.*;
import java.awt.*;

public class UserManageFrame extends JFrame {
    private JLabel topPanel;
    private JButton[] topBtn = new JButton[]{
            new JButton("查询用户"),
            new JButton("删除用户")
    };

    public static void main(String[] args) {
        new UserManageFrame();
    }

    public UserManageFrame() {
        // 初始化窗口
        SetFrameTool.setFrame(
                "用户管理",
                1000,
                600,
                "src/main/java/top/playereg/sys/img/book.png",
                this);

        // 设置关闭操作
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                dispose();
            }
        });

        // 创建顶部菜单
        topPanel = new JLabel();
        topPanel.setOpaque(true);
        topPanel.setLayout(null);
        this.add(topPanel);
        SetFrameTool.setTopMenuStyle(topBtn, Color.white,
                Color.black, topPanel, 0);

        this.setLayout(null);
        setVisible(true);
    }
}
