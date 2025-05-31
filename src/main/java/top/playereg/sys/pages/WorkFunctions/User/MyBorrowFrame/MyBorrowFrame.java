/*
 *
 * @author: playereg
 * @description: 我的借阅
 * @version: 1.0
 *
 * */

package top.playereg.sys.pages.WorkFunctions.User.MyBorrowFrame;

import top.playereg.sys.utils.SetFrameTool;
import top.playereg.sys.utils.UserSaveTool;
import top.playereg.sys.dao.BookDao;
import top.playereg.sys.entity.Books;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
        addWindowListener(new WindowAdapter() { // 窗口关闭事件
            public void windowClosing(WindowEvent windowEvent) {
                dispose();
            }
        });

        borrowPanel = new JLabel("正在借阅：");
        SetFrameTool.setFontStyle(borrowPanel, 20, Color.BLACK,
                30, 50, 150, 30, myBorrowPanel);
        borrowingBookNamePanel = new JLabel(getBorrowingBookName());
        SetFrameTool.setFontStyle(borrowingBookNamePanel, 20, Color.BLACK,
                170, 50, 250, 30, myBorrowPanel);
        returnPanel = new JLabel("归还时间：");
        SetFrameTool.setFontStyle(returnPanel, 20, Color.BLACK,
                30, 100, 150, 30, myBorrowPanel);
        returnTimePanel = new JLabel(returnTime());
        SetFrameTool.setFontStyle(returnTimePanel, 20, Color.BLACK,
                170, 100, 250, 30, myBorrowPanel);
        SetFrameTool.setPanleBackgroundImg(
                "src/main/java/top/playereg/sys/img/mylogo.png",
                350, 250, 200, 93, myBorrowPanel);

        this.setVisible(true);
    }


    int tempID = UserSaveTool.getCurerntLoginUserBookBorrowID();

    private String getBorrowingBookName() {
        Books book = BookDao.getBook(tempID);
        if (book != null) {
            return book.getBookName();
        } else {
            return "暂无";
        }
    }

    public String returnTime() {
        long tempBorrowTime = UserSaveTool.getCurerntLoginUserBookBorrowTime(); // 获取借阅时间
        long tempReturnTime = tempBorrowTime + 1000 * 60 * 60 * 24 * 7; // 借阅时间加一周
        long tempNowTime = System.currentTimeMillis(); // 获取当前时间
        System.out.println("借阅时间：" + tempBorrowTime);
        System.out.println("还书时间：" + tempReturnTime);
        System.out.println("当前时间：" + tempNowTime);
        if (tempBorrowTime == 0) {
            return "未借阅";
        } else if (tempNowTime > tempReturnTime) {
            return "超时";
        } else {
            long tempDays = (tempReturnTime - tempNowTime) / (1000 * 60 * 60 * 24);
            return tempDays + "天";
        }
    }
}