package top.playereg.sys.pages.WorkFunctions.User.BorrowBookFrame;

import top.playereg.sys.utils.SetFrameTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BorrowBookFrame extends JFrame implements ActionListener {
    public static void main(String[] args) {
        new BorrowBookFrame();
    }

    private JLabel topPanel, bottomPanel;
    private JButton[] topBtn = new JButton[]{
            new JButton("查询图书"),
            new JButton("借阅图书"),
            new JButton("借书记录")
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

                    case "查询图书": {
                        SetFrameTool.updateTopMenuStyle(topBtn, button);
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

                    case "借书记录": {
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
                    default:
                        break;
                }
            }
        }
    }
}
