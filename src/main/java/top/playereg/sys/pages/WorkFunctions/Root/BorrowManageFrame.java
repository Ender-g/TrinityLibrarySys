package top.playereg.sys.pages.WorkFunctions.Root;

import top.playereg.sys.utils.SetFrameTool;

import javax.swing.*;

import java.awt.*;

import static top.playereg.sys.utils.DiyColors.*;

public class BorrowManageFrame extends JFrame {
    public JLabel topPanel, bottonPanel;
    public JButton[] topBtn = new JButton[]{
            new JButton("借阅记录"),
            new JButton("还书记录")
    };

    public static void main(String[] args) {
        new BorrowManageFrame();
    }

    public BorrowManageFrame() {
        SetFrameTool.setFrame(
                "借阅管理",
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
        SetFrameTool.setTopMenuStyle(topBtn, Color.white,
                Color.black, topPanel, 0);

        this.setLayout(null);
        setVisible(true);
    }
}
