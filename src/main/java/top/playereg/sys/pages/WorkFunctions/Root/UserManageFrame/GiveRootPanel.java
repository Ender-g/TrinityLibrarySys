package top.playereg.sys.pages.WorkFunctions.Root.UserManageFrame;

import javax.swing.*;
import java.awt.*;

public class GiveRootPanel extends JPanel {
    public GiveRootPanel() {
        setLayout(null); // 保持与主框架一致的布局方式
        setBackground(Color.red);
        JLabel label = new JLabel();
        label.setBounds(0, 0, 1000, 500);
        add(label);
    }
}
