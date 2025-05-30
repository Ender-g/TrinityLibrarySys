package top.playereg.sys.pages.WorkFunctions.Root.UserManageFrame;

import javax.swing.*;
import java.awt.*;

import static top.playereg.sys.utils.DiyColors.skyblue;

public class ManageUserPanel extends JPanel {
    private JLabel ManageUserLabel;
    private JButton DelUserButton, GiveRootButton;
    private JTextField ManageUserField;
    private Image backgroundImage;

    public ManageUserPanel() {
        setLayout(null); // 保持与主框架一致的布局方式
        setBackground(Color.yellow);
        JLabel label = new JLabel();
        label.setBounds(0, 0, 1000, 500);
        backgroundImage = new ImageIcon("src/main/java/top/playereg/sys/img/background_1.png").getImage();
        add(label);

        ManageUserLabel = new JLabel("需借进行操作的用户ID");
        ManageUserLabel.setForeground(Color.white);
        ManageUserLabel.setFont(new Font("黑体", Font.BOLD, 25));
        ManageUserLabel.setBounds(550, 150, 300, 50);
        add(ManageUserLabel);

        ManageUserField = new JTextField();
        ManageUserField.setForeground(Color.black);
        ManageUserField.setFont(new Font("黑体", Font.BOLD, 20));
        ManageUserField.setBounds(550, 200, 250, 50);
        add(ManageUserField);

        DelUserButton = new JButton("删 除 用 户");
        DelUserButton.setForeground(Color.black);
        DelUserButton.setFont(new Font("黑体", Font.BOLD, 20));
        DelUserButton.setBorderPainted(false);
        DelUserButton.setBackground(Color.red);
        DelUserButton.setBounds(550, 270, 250, 50);
        add(DelUserButton);

        GiveRootButton = new JButton("提升为管理员");
        GiveRootButton.setForeground(Color.black);
        GiveRootButton.setFont(new Font("黑体", Font.BOLD, 20));
        GiveRootButton.setBorderPainted(false);
        GiveRootButton.setBackground(Color.yellow);
        GiveRootButton.setBounds(550, 330, 250, 50);
        add(GiveRootButton);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, -10, -20, 1000, 562, this);
    }
}
