package top.playereg.sys.pages.WorkFunctions.User.MyBorrowFrame;

import top.playereg.sys.utils.SetFrameTool;

import javax.swing.*;
import java.awt.*;

import static top.playereg.sys.utils.UserSaveTool.*;

public class MyBorrowFrame extends JFrame {
    public static void main(String[] args) {
        new MyBorrowFrame();
    }

    private JLabel myBorrowPanel;
    private JLabel borrowPanel, returnPanel;
    private JLabel borrowingBookNamePanel, returnTimePanel;

    public MyBorrowFrame() {
        SetFrameTool.setFrame(
                "我的借阅",
                600,
                400,
                "src/main/java/top/playereg/sys/img/book.png",
                this);

        myBorrowPanel = new JLabel();
        myBorrowPanel.setLayout(null);
        this.add(myBorrowPanel);


        //设置窗体关闭，不结束程序
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() { // 窗口关闭事件
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                dispose();
            }
        });

        borrowPanel = new JLabel("正在借阅：");
        SetFrameTool.setFontStyle(borrowPanel, 20, Color.BLACK,
                30, 50, 150, 30, myBorrowPanel);
        borrowingBookNamePanel = new JLabel("《程序员》");
        SetFrameTool.setFontStyle(borrowingBookNamePanel, 20, Color.BLACK,
                170, 50, 250, 30, myBorrowPanel);
        returnPanel = new JLabel("归还时间：");
        SetFrameTool.setFontStyle(returnPanel, 20, Color.BLACK,
                30, 100, 150, 30, myBorrowPanel);
        returnTimePanel = new JLabel("2021-05-05");
        SetFrameTool.setFontStyle(returnTimePanel, 20, Color.BLACK,
                170, 100, 250, 30, myBorrowPanel);
        SetFrameTool.setPanleBackgroundImg(
                "src/main/java/top/playereg/sys/img/mylogo.png",
                350, 250, 200, 93, myBorrowPanel);

        this.setVisible(true);
    }
}
