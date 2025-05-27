package top.playereg.sys.pages.WorkFunctions.WorkPanel;

import javax.swing.*;
import java.awt.*;

public class BorrowBookPanel extends JPanel {

        public BorrowBookPanel() {
            setLayout(null); // 保持与主框架一致的布局方式
            setBackground(Color.BLUE);
            JLabel label = new JLabel("借阅图书界面");
            label.setBounds(0, 0 ,1000, 500);
            add(label);
        }
}
