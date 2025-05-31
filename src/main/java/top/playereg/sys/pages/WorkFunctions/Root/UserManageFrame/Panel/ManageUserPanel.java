package top.playereg.sys.pages.WorkFunctions.Root.UserManageFrame.Panel;

import top.playereg.sys.dao.UserDao;
import top.playereg.sys.utils.UserSaveTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManageUserPanel extends JPanel implements ActionListener {
    private JLabel ManageUserLabel;
    private JButton DelUserButton, GiveRootButton;
    private JTextField idField;
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

        idField = new JTextField();
        idField.setForeground(Color.black);
        idField.setFont(new Font("黑体", Font.BOLD, 20));
        idField.setBounds(550, 200, 250, 50);
        add(idField);

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

        GiveRootButton.addActionListener(this);
        DelUserButton.addActionListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, -10, -20, 1000, 562, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 获取输入字段
        String id = idField.getText();
        String currentUserId = String.valueOf(UserSaveTool.getCurerntLoginUserId());
        if (e.getSource() == GiveRootButton) {
            if (id.isEmpty()) {
                JOptionPane.showMessageDialog(null, "请输入用户ID");
                return;
            } else if (!id.matches("[0-9]+")) {
                JOptionPane.showMessageDialog(null, "请输入正确的用户ID");
                return;
            } else {
                if (id.equals(currentUserId)) {
                    JOptionPane.showMessageDialog(null, "您已是管理员");
                } else {
                    UserDao.updateUserRole(id, 1);
                }
            }

        }
        if (e.getSource() == DelUserButton) {
            if (id.isEmpty()) {
                JOptionPane.showMessageDialog(null, "请输入用户ID");
                return;
            } else if (!id.matches("[0-9]+")) {
                JOptionPane.showMessageDialog(null, "请输入正确的用户ID");
                return;
            } else {
                // 不能 删除自己
                if (id.equals(currentUserId)) {
                    JOptionPane.showMessageDialog(null, "您不能删除自己");
                } else {
                    UserDao.deleteUserById(id);
                }
            }
        }
    }
}

