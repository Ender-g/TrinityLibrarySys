/*
 *
 * @author: playereg
 * @description: 返还图书面板
 * @version: 1.0
 *
 * */

package top.playereg.sys.pages.WorkFunctions.User.UserWorkFrame.Panel;

import top.playereg.sys.dao.BookDao;
import top.playereg.sys.dao.UserDao;
import top.playereg.sys.entity.Books;
import top.playereg.sys.utils.UserSaveTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static top.playereg.sys.utils.DiyColors.skyblue;

public class ReturnBookPanel extends JPanel implements ActionListener {
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

        ReturnBookButton.addActionListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, -10, -20, 1000, 562, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ReturnBookButton) {
            if (UserSaveTool.getCurerntLoginUserBookBorrowID() == 0) {
                JOptionPane.showMessageDialog(
                        null, // 父组件设为null，强制对话框在屏幕中央显示
                        "当前未借阅图书",
                        "错误", // 标题
                        JOptionPane.ERROR_MESSAGE
                );
            } else {
                Books id = BookDao.getBook(UserSaveTool.getCurerntLoginUserBookBorrowID()); // 获取当前用户借阅的图书信息
                BookDao.updateBook(new Books(id.getId(), id.getBookName(), id.getBookNumber() + 1, id.getIs_del()));
                UserDao.updateUserBookBorrowInfo(UserSaveTool.getCurerntLoginUserId(), 0, 0);
                UserSaveTool.setCurerntLoginUserBookBorrowID(0);
                UserSaveTool.setCurerntLoginUserBookBorrowTime(0);
                JOptionPane.showMessageDialog(
                        null, // 父组件设为null，强制对话框在屏幕中央显示
                        "成功归还，欢迎下次光临！！！",
                        "提示", // 标题
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        }
    }
}
