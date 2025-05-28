package top.playereg.sys.pages.WorkFunctions.Root.UserManageFrame;

import javax.swing.*;
import java.awt.*;

public class DelUserPanel extends JPanel {
    public DelUserPanel() {
        setLayout(null); // 保持与主框架一致的布局方式
        setBackground(Color.cyan);
        JLabel label = new JLabel();
        label.setBounds(0, 0, 1000, 500);
        add(label);
    }
}
