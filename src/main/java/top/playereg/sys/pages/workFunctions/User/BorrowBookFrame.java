package top.playereg.sys.pages.workFunctions.User;

import top.playereg.sys.utils.SetFrameTool;

import javax.swing.*;
import java.awt.*;

import static top.playereg.sys.utils.DiyColors.lightblue;
import static top.playereg.sys.utils.DiyColors.lightgreen;

public class BorrowBookFrame extends JFrame {
    public static void main(String[] args) {
        new BorrowBookFrame();
    }
    //声明顶部面板和底部面板;
    private JLabel topJpanel;
    private JLabel bottomJpanel;
    //声明查询按钮 借阅按钮
    private JButton[] btn;

    public BorrowBookFrame(){
        //设置窗体
        SetFrameTool.setFrame("借阅图书",
                1000,
                600,
                "src/main/resources/icon/book.png",
                this);
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        //创建顶部面板
        topJpanel = new JLabel();
        topJpanel.setOpaque(true);
        topJpanel.setBackground(Color.RED);
        topJpanel.setBounds(0, 0, 1000, 100);
        topJpanel.setLayout(null);
        this.add(topJpanel);

       //顶部面板添加按钮
        btn = new JButton[]{
                new JButton("查询图书"),
                new JButton("借阅图书")
        };
        Color[] color = new Color[]{lightgreen, lightblue, Color.lightGray};
        for (int i = 0; i < btn.length; i++) {
           SetFrameTool.setBtnStyle(
                   btn[i],
                   color[i],
                   Color.black,
                   20,
                   300 + i * 200,
                   30,
                   150,
                   50,
                   topJpanel);
        }



        this.setLayout(null);

        this.setVisible(true);
    }
}
