package top.playereg.sys.pages.workFunctions.User;

import top.playereg.sys.utils.SetFrameTool;

import javax.swing.*;
import java.awt.*;

import static top.playereg.sys.utils.DiyColors.lightblue;
import static top.playereg.sys.utils.DiyColors.lightgreen;

public class ReturnBookFrame extends JFrame {
    public static void main(String[] args) {
        new ReturnBookFrame();
    }
    public JLabel topPanel,bottonPanel;
    public JButton[]  btn;

    public ReturnBookFrame() {
        SetFrameTool.setFrame(
                "归还图书",
                1000,
                600,
                "src/main/resources/icon/logo.png",
                this);
        //设置窗体关闭，不结束程序
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() { // 窗口关闭事件
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                dispose();
            }});

        //创建顶部面板
        topPanel = new JLabel();
        topPanel.setOpaque(true);
        topPanel.setBackground(Color.pink);
        topPanel.setBounds(0, 0, 1000, 100);
        topPanel.setLayout(null);
        this.add(topPanel);

        //创建按钮
        btn  = new JButton[]{
                new JButton("归还图书"),
        };
        //绘制按钮
        Color[] color = new Color[]{lightgreen, lightblue, Color.lightGray};
        for (int i = 0; i < btn.length; i++) {
            SetFrameTool.setBtnStyle(
                    btn[i],
                    color[i],
                    Color.black,
                    20,
                    400 + i * 200,
                    30,
                    150,
                    50,
                    topPanel);
        };





        this.setLayout(null);
        setVisible(true);

    }



}
