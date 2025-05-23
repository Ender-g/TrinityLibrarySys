package top.playereg.sys.pages;



import top.playereg.sys.utils.SetFrameTool;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RootMainFrame extends JFrame implements ActionListener {
    //主面板
    private JPanel mainpanel;
    //

    RootMainFrame() {
        SetFrameTool.setFrame(
                "崔尼图书馆-管理员端 v1.0.0",
                960, 540,
                "src/main/java/top/playereg/sys/img/book.png",
                this
        );
        setVisible(true);
        /* 设置登录背景%start====================================================================== */
//        SetFrameTool.setPanleBackgroundImg(
//                "src/main/java/top/playereg/sys/img/background_1.png",
//                0, -20, 960, 540,
//        );

    }

    public static void main(String[] args) {
        new RootMainFrame();
    }

    // 实现 ActionListener 接口的方法
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO: 添加事件处理逻辑
    }

    // todo 超级管理员界面
}
