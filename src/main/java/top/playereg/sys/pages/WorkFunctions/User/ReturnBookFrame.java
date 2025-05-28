package top.playereg.sys.pages.WorkFunctions.User;

import top.playereg.sys.utils.SetFrameTool;

import javax.swing.*;
import java.awt.*;

import static top.playereg.sys.utils.DiyColors.lightblue;
import static top.playereg.sys.utils.DiyColors.lightgreen;

public class ReturnBookFrame extends JFrame {
    public static void main(String[] args) {
        new ReturnBookFrame(); // test
    }

    public JLabel topPanel, bottonPanel;
    public JButton[] topBtn = new JButton[]{ // 顶部菜单
            new JButton("归还图书"),
            new JButton("还书记录")
    };

    public ReturnBookFrame() {
        SetFrameTool.setFrame(
                "归还图书",
                1000,
                600,
                "src/main/java/top/playereg/sys/img/book.png",
                this);
        //设置窗体关闭，不结束程序
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() { // 窗口关闭事件
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                dispose();
            }
        });

        // 创建顶部菜单
        topPanel = new JLabel();
        topPanel.setOpaque(true);
        topPanel.setLayout(null);
        this.add(topPanel);
        bottonPanel = new JLabel();
        bottonPanel.setOpaque(true);
        bottonPanel.setLayout(null);
        this.add(bottonPanel);
        SetFrameTool.setTopMenuStyle(topBtn, Color.white,
                Color.black, topPanel, bottonPanel, 0);

        this.setLayout(null);
        setVisible(true);
    }
}
