/*
 *
 * @author: playereg
 * @description: 列举图书表
 * @version: 1.0
 *
 * */

package top.playereg.sys.pages.WorkFunctions.Root.BookManageFrame;

import javax.swing.*;
import java.awt.*;

public class ListAllBookPanel extends JPanel {
    public ListAllBookPanel() {
        setLayout(null); // 保持与主框架一致的布局方式
        setBackground(Color.cyan);
        JLabel label = new JLabel();
        label.setBounds(0, 0, 1000, 500);
        add(label);
    }
}
