package top.playereg.sys.pages.WorkFunctions.User;

import top.playereg.sys.utils.SetFrameTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import top.playereg.sys.pages.WorkFunctions.WorkPanel.BorrowBookPanel;


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

        // 创建顶部菜单
        topPanel = new JLabel();
        topPanel.setOpaque(true);
        topPanel.setLayout(null);
        this.add(topPanel);
        SetFrameTool.setTopMenuStyle(topBtn, Color.white,
                Color.black, topPanel, 0);


        bottomPanel = new JLabel();
        bottomPanel.setOpaque(true);
        bottomPanel.setLayout(null);
        bottomPanel.setBounds(0, 100, 1000, 500);
        this.add(bottomPanel);


        this.setLayout(null);

        this.setVisible(true);
        for (JButton button : topBtn) button.addActionListener(this);
    }

    /**
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        for (JButton button : topBtn) {
            if (e.getSource() == button) {
                System.out.println(button.getText());
                switch (button.getText()) {
//                    case "查询图书":
//
//                        break;
                    case "借阅图书":
                        bottomPanel.removeAll();

                        BorrowBookPanel borrowBookPanel = new BorrowBookPanel();
                        borrowBookPanel.setBounds(
                                0, 0,
                                bottomPanel.getWidth(),
                                bottomPanel.getHeight()); // 设置正确位置和大小

                        bottomPanel.add(borrowBookPanel);
                        bottomPanel.revalidate(); // 刷新布局
                        bottomPanel.repaint();    // 重绘面板
                        break;

                }
            }
        }

    }
}
