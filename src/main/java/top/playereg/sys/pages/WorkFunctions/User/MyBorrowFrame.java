package top.playereg.sys.pages.WorkFunctions.User;

import top.playereg.sys.utils.SetFrameTool;

import javax.swing.*;

public class MyBorrowFrame extends JFrame {

        public static void main(String[] args) {
            new MyBorrowFrame();
        }
        public MyBorrowFrame() {
            SetFrameTool.setFrame(
                    "我的借阅",
                    600,
                    400,
                    "src/main/java/top/playereg/sys/img/BorrowManage.png",
                    this);
            //设置窗体关闭，不结束程序
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            addWindowListener(new java.awt.event.WindowAdapter() { // 窗口关闭事件
                public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                    dispose();
                }});


            this.setLayout(null);
            this.setVisible(true);

        }

      //设置窗口可见性


}
