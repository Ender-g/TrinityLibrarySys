/*
 *
 * @author: playereg
 * @description: 根管理员书籍管理页面
 * @version: 1.0
 *
 * */

package top.playereg.sys.pages.WorkFunctions.Root;

import static top.playereg.sys.utils.DiyColors.*;

import top.playereg.sys.utils.SetFrameTool;

import javax.swing.*;
import java.awt.*;

public class BookManageFrame extends JFrame {
    public static void main(String[] args) {
        new BookManageFrame();
    }

    private JLabel topPanel, bottonPanel;
    private JButton[] topBtn = new JButton[]{
            new JButton("增加图书"),
            new JButton("删除图书"),
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
