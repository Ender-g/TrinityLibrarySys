package top.playereg.sys.pages.WorkFunctions.WorkPanel;

import javax.swing.*;
import java.awt.*;

public class InquireBookPanel extends JPanel {
    public InquireBookPanel() {
        setLayout(null); // 保持与主框架一致的布局方式
        setBackground(Color.BLUE);
        JLabel label = new JLabel();
        label.setBounds(0, 0, 1000, 500);
        add(label);
    }
}
