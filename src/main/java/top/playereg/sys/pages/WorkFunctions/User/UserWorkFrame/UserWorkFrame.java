/*
 *
 * @author: playereg
 * @description: 用户业务界面
 * @version: 1.0
 *
 * */

package top.playereg.sys.pages.WorkFunctions.User.UserWorkFrame;

import top.playereg.sys.pages.WorkFunctions.User.UserWorkFrame.Panel.BorrowBookPanel;
import top.playereg.sys.pages.WorkFunctions.User.UserWorkFrame.Panel.ListAllBookPanel;
import top.playereg.sys.pages.WorkFunctions.User.UserWorkFrame.Panel.ReturnBookPanel;
import top.playereg.sys.utils.SetFrameTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserWorkFrame extends JFrame implements ActionListener {

    private JLabel topPanel, bottomPanel;
    private JButton[] topBtn = new JButton[]{
            new JButton("所有图书"),
            new JButton("借阅图书"),
            new JButton("归还图书")
    };

    public UserWorkFrame() {
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
                switch (button.getText()) {

                    case "所有图书": {
                        SetFrameTool.updateTopMenuStyle(topBtn, button);
                        bottomPanel.removeAll();
                        ListAllBookPanel listAllBookPanel = new ListAllBookPanel();
                        listAllBookPanel.setBounds(
                                0, 0,
                                bottomPanel.getWidth(),
                                bottomPanel.getHeight()
                        );
                        bottomPanel.add(listAllBookPanel);
                        bottomPanel.revalidate();
                        bottomPanel.repaint();
                        break;
                    }

                    case "借阅图书": {
                        SetFrameTool.updateTopMenuStyle(topBtn, button);
                        bottomPanel.removeAll();
                        BorrowBookPanel borrowBookPanel = new BorrowBookPanel();
                        borrowBookPanel.setBounds(
                                0, 0,
                                bottomPanel.getWidth(),
                                bottomPanel.getHeight()
                        );
                        bottomPanel.add(borrowBookPanel);
                        bottomPanel.revalidate(); // 刷新布局
                        bottomPanel.repaint();    // 重绘面板
                        break;
                    }

                    case "归还图书": {
                        SetFrameTool.updateTopMenuStyle(topBtn, button);
                        bottomPanel.removeAll();
                        ReturnBookPanel returnBookPanel = new ReturnBookPanel();
                        returnBookPanel.setBounds(
                                0, 0,
                                bottomPanel.getWidth(),
                                bottomPanel.getHeight()
                        );
                        bottomPanel.add(returnBookPanel);
                        bottomPanel.revalidate();
                        bottomPanel.repaint();
                        break;
                    }
                    default:
                        break;
                }
            }
        }
    }
}
