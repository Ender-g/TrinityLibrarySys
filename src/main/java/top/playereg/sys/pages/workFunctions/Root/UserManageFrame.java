package top.playereg.sys.pages.workFunctions.Root;

import top.playereg.sys.pages.mainFrame.UserMainFrame;
import top.playereg.sys.utils.SetFrameTool;
import top.playereg.sys.utils.DiyColors;

import javax.swing.*;
import java.awt.*;

public class UserManageFrame extends JFrame {
    private JLabel topPanel;
    private JButton[] buttons;

    public static void main(String[] args) {
        new UserManageFrame();
    }

    public UserManageFrame() {
        // 初始化窗口
        SetFrameTool.setFrame(
                "用户管理",
                1000,
                600,
                "src/main/java/top/playereg/sys/img/userManage.png",
                this);

        // 设置关闭操作
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                dispose();
            }
        });

        // 创建顶部面板
        topPanel = new JLabel();
        topPanel.setOpaque(true);
        topPanel.setBackground(DiyColors.skyblue);
        topPanel.setBounds(0, 0, 1000, 100);
        topPanel.setLayout(null);
        this.add(topPanel);

        // 创建按钮组
        buttons = new JButton[] {
                new JButton("查询用户"),
                new JButton("删除用户")
        };

        Color[] buttonColors = new Color[] {DiyColors.darkgreen, DiyColors.lightgreen};

        // 设置按钮样式和位置
        for (int i = 0; i < buttons.length; i++) {
            SetFrameTool.setBtnStyle(
                    buttons[i],
                    buttonColors[i],
                    Color.black,
                    20,
                    200 + i * 200,
                    30,
                    150,
                    50,
                    topPanel);
        }

        this.setLayout(null);
        setVisible(true);
    }
}
