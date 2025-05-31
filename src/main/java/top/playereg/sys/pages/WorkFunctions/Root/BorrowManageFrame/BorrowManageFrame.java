package top.playereg.sys.pages.WorkFunctions.Root.BorrowManageFrame;

import top.playereg.sys.pages.WorkFunctions.Root.BorrowManageFrame.Panel.BorrowRecordPanel;
import top.playereg.sys.pages.WorkFunctions.Root.BorrowManageFrame.Panel.ReturnRecordPanel;
import top.playereg.sys.utils.SetFrameTool;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BorrowManageFrame extends JFrame implements ActionListener {
    public JLabel topPanel, bottomPanel;
    public JButton[] topBtn = new JButton[]{
            new JButton("借阅记录"),
            new JButton("归还记录")
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
        bottomPanel = new JLabel();
        bottomPanel.setOpaque(true);
        bottomPanel.setLayout(null);
        this.add(bottomPanel);
        SetFrameTool.setTopMenuStyle(topBtn, Color.white,
                Color.black, topPanel, bottomPanel, 0);

        this.setLayout(null);
        setVisible(true);

        for (JButton button : topBtn) button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (JButton button : topBtn) {
            if (e.getSource() == button) {
                System.out.println(button.getText());
                switch (button.getText()) {

                    case "借阅记录": {
                        SetFrameTool.updateTopMenuStyle(topBtn, button);
                        bottomPanel.removeAll();
                        BorrowRecordPanel borrowRecordPanel = new BorrowRecordPanel();
                        borrowRecordPanel.setBounds(
                                0, 0,
                                bottomPanel.getWidth(),
                                bottomPanel.getHeight()
                        );
                        bottomPanel.add(borrowRecordPanel);
                        bottomPanel.revalidate();
                        bottomPanel.repaint();
                        break;
                    }

                    case "归还记录": {
                        SetFrameTool.updateTopMenuStyle(topBtn, button);
                        bottomPanel.removeAll();
                        ReturnRecordPanel returnRecordPanel = new ReturnRecordPanel();
                        returnRecordPanel.setBounds(
                                0, 0,
                                bottomPanel.getWidth(),
                                bottomPanel.getHeight()
                        );
                        bottomPanel.add(returnRecordPanel);
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
