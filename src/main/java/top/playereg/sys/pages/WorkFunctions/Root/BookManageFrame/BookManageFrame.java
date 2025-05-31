/*
 *
 * @author: playereg
 * @description: 图书管理面板
 * @version: 1.0
 *
 * */

package top.playereg.sys.pages.WorkFunctions.Root.BookManageFrame;

import top.playereg.sys.pages.WorkFunctions.Root.BookManageFrame.Panel.ListAllBookPanel;
import top.playereg.sys.pages.WorkFunctions.Root.BookManageFrame.Panel.ListAllDeletedBookPanel;
import top.playereg.sys.pages.WorkFunctions.Root.BookManageFrame.Panel.ManageBookPanel;
import top.playereg.sys.utils.SetFrameTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookManageFrame extends JFrame implements ActionListener {
    public static void main(String[] args) {
        new BookManageFrame();
    }

    private JLabel topPanel, bottomPanel;
    private JButton[] topBtn = new JButton[]{
            new JButton("图书列表"),
            new JButton("图书管理"),
            new JButton("已删除"),
    };

    public BookManageFrame() {

        SetFrameTool.setFrame(
                "图书管理",
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

                    case "图书管理": {
                        SetFrameTool.updateTopMenuStyle(topBtn, button);
                        bottomPanel.removeAll();
                        ManageBookPanel manageBookPanel = new ManageBookPanel();
                        manageBookPanel.setBounds(
                                0, 0,
                                bottomPanel.getWidth(),
                                bottomPanel.getHeight()
                        );
                        bottomPanel.add(manageBookPanel);
                        bottomPanel.revalidate();
                        bottomPanel.repaint();
                        break;
                    }

                    case "图书列表": {
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

                    case "已删除": {
                        SetFrameTool.updateTopMenuStyle(topBtn, button);
                        bottomPanel.removeAll();
                        ListAllDeletedBookPanel listAllDeletedBookPanel = new ListAllDeletedBookPanel();
                        listAllDeletedBookPanel.setBounds(
                                0, 0,
                                bottomPanel.getWidth(),
                                bottomPanel.getHeight()
                        );
                        bottomPanel.add(listAllDeletedBookPanel);
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
