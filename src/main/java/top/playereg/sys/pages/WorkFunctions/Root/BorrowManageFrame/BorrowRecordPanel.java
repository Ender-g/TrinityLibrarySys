package top.playereg.sys.pages.WorkFunctions.Root.BorrowManageFrame;

import javax.swing.*;
import java.awt.*;

public class BorrowRecordPanel extends JPanel {
    public BorrowRecordPanel() {
        setLayout(null); // 保持与主框架一致的布局方式
        setBackground(Color.yellow);
        JLabel label = new JLabel();
        label.setBounds(0, 0, 1000, 500);
        add(label);
    }
}
