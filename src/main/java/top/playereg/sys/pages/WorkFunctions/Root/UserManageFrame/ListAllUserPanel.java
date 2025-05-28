package top.playereg.sys.pages.WorkFunctions.Root.UserManageFrame;

import javax.swing.*;
import java.awt.*;

public class ListAllUserPanel extends JPanel {
    public ListAllUserPanel() {
        setLayout(null); // 保持与主框架一致的布局方式
        setBackground(Color.blue);
        JLabel label = new JLabel();
        label.setBounds(0, 0, 1000, 500);
        add(label);
    }
}
