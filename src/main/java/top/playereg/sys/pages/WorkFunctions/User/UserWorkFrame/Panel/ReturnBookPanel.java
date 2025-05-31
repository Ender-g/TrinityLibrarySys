/*
 *
 * @author: playereg
 * @description: 返还图书面板
 * @version: 1.0
 *
 * */

package top.playereg.sys.pages.WorkFunctions.User.UserWorkFrame.Panel;

import javax.swing.*;
import java.awt.*;

import static top.playereg.sys.utils.DiyColors.skyblue;

public class ReturnBookPanel extends JPanel {
    private JLabel ReturnBookLabel;
    private JButton ReturnBookButton;
    private Image backgroundImage;

    public ReturnBookPanel() {
        setLayout(null); // 保持与主框架一致的布局方式
        setBackground(Color.yellow);
        JLabel label = new JLabel();
        label.setBounds(0, 0, 1000, 500);
        backgroundImage = new ImageIcon("src/main/java/top/playereg/sys/img/background_1.png").getImage();
        add(label);

        ReturnBookLabel = new JLabel("点击后自动归还图书");
        ReturnBookLabel.setForeground(Color.white);
        ReturnBookLabel.setFont(new Font("黑体", Font.BOLD, 25));
        ReturnBookLabel.setBounds(550, 200, 300, 50);
        add(ReturnBookLabel);

        ReturnBookButton = new JButton(">>> 归还 <<<");
        ReturnBookButton.setForeground(Color.black);
        ReturnBookButton.setFont(new Font("黑体", Font.BOLD, 20));
        ReturnBookButton.setBorderPainted(false);
        ReturnBookButton.setBackground(skyblue);
        ReturnBookButton.setBounds(550, 250, 250, 50);
        add(ReturnBookButton);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, -10, -20, 1000, 562, this);
    }
}
