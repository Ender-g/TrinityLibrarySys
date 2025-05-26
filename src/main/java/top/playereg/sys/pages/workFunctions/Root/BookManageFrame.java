/*
 *
 * @author: playereg
 * @description: 根管理员书籍管理页面
 * @version: 1.0
 *
 * */

package top.playereg.sys.pages.workFunctions.Root;

import static top.playereg.sys.utils.DiyColors.*;
import top.playereg.sys.utils.SetFrameTool;

import javax.swing.*;
import java.awt.*;

public class BookManageFrame extends JFrame {
    public static void main(String[] args) {
        new BookManageFrame();
    }
    private JLabel topPanel,bottonPanel;
    private JButton[]  btn;

    public BookManageFrame() {

        SetFrameTool.setFrame(
                "图书管理",
                1000,
                600,
                "src/main/java/top/playereg/sys/img/bookManage.png",
                this);

        //设置窗体关闭，不结束程序
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() { // 窗口关闭事件
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                dispose();
            }});

        //设置顶部面板
        topPanel = new JLabel();
        topPanel.setOpaque(true);
        topPanel.setBackground(skyblue);
        topPanel.setBounds(0,0,1000,100);
        topPanel.setLayout(null);
        this.add(topPanel);

        btn=new JButton[]{
                new JButton("增加图书"),
                new JButton("删除图书"),
        };
        Color[] color = new Color[]{darkgreen,lightgreen};
       for (int i = 0; i < btn.length; i++){
           SetFrameTool.setBtnStyle(
                   btn[i],
                   color[i],
                   Color.black,
                   20,
                   300 + i * 200,
                   30,
                   150,
                   50,
                   topPanel);
       };



        this.setLayout(null);
        setVisible(true);
    }
}
