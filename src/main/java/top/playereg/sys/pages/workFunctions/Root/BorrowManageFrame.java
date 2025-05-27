package top.playereg.sys.pages.WorkFunctions.Root;

import top.playereg.sys.utils.SetFrameTool;

import javax.swing.*;

import java.awt.*;

import static top.playereg.sys.utils.DiyColors.*;

public class BorrowManageFrame extends JFrame {
    public JLabel topPanel,bottonPanel;
    public JButton[]  btn;
    public static void main(String[] args) {
        new BorrowManageFrame();
    }
    public BorrowManageFrame() {
        SetFrameTool.setFrame(
                "借阅管理",
                1000,
                600,
                "src/main/java/top/playereg/sys/img/BorrowManage.png",
                this);
        //设置窗体关闭，不结束程序
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() { // 窗口关闭事件
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                dispose();
            }});
        topPanel = new JLabel();
        topPanel.setOpaque(true);
        topPanel.setBackground(skyblue);
        topPanel.setBounds(0,0,1000,100);
        topPanel.setLayout(null);
        this.add(topPanel);

        btn = new JButton[]{
                new JButton("借阅记录"),
                new JButton("还书记录")
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
