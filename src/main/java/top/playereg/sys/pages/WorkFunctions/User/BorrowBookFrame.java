package top.playereg.sys.pages.WorkFunctions.User;

import top.playereg.sys.pages.WorkFunctions.WorkPanel.User.BorrowBookPanel;
import top.playereg.sys.pages.WorkFunctions.WorkPanel.User.InquireBookPanel;
import top.playereg.sys.utils.SetFrameTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import top.playereg.sys.utils.SetFrameTool.*;

public class BorrowBookFrame extends JFrame implements ActionListener {
    public static void main(String[] args) {
        new BorrowBookFrame();
    }

    private JLabel topPanel, bottomPanel;
    private JButton[] topBtn = new JButton[]{
            new JButton("查询图书"),
            new JButton("借阅图书")
    };

    public BorrowBookFrame() {
        //设置窗体
        SetFrameTool.setFrame("借阅图书",
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

        // 创建面板
        topPanel = new JLabel();
        topPanel.setOpaque(true);
        topPanel.setLayout(null);
        this.add(topPanel);
        bottomPanel = new JLabel();
        bottomPanel.setOpaque(true);
        bottomPanel.setLayout(null);
        this.add(bottomPanel);
        SetFrameTool.setTopMenuStyle(topBtn, Color.white,
                Color.black, topPanel, bottomPanel, 0);


        this.setLayout(null);

        this.setVisible(true);
        for (JButton button : topBtn) button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (JButton button : topBtn) {
            if (e.getSource() == button) {
                System.out.println(button.getText());
                switch (button.getText()) {
                    case "查询图书":
                        SetFrameTool.updateTopMenuStyle(topBtn, button);
                        System.out.println("查询图书");
                        bottomPanel.removeAll();
                        InquireBookPanel inquireBookPanel = new InquireBookPanel();
                        inquireBookPanel.setBounds(
                                0, 0,
                                bottomPanel.getWidth(),
                                bottomPanel.getHeight()
                        );

                        bottomPanel.add(inquireBookPanel);
                        bottomPanel.revalidate();
                        bottomPanel.repaint();
                        break;
                    case "借阅图书":
                        SetFrameTool.updateTopMenuStyle(topBtn, button);
                        System.out.println("借阅图书");
                        bottomPanel.removeAll();
                        BorrowBookPanel borrowBookPanel = new BorrowBookPanel();
                        borrowBookPanel.setBounds(
                                0, 0,
                                bottomPanel.getWidth(),
                                bottomPanel.getHeight()
                        ); // 设置正确位置和大小

                        bottomPanel.add(borrowBookPanel);
                        bottomPanel.revalidate(); // 刷新布局
                        bottomPanel.repaint();    // 重绘面板
                        break;
                }
            }
        }
    }
}
