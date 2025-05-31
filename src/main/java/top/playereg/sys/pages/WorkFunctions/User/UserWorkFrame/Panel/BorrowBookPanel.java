/*
 *
 * @author: playereg
 * @description: 借阅图书面板
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

import static top.playereg.sys.utils.DiyColors.*;

public class BorrowBookPanel extends JPanel implements ActionListener {
    private JLabel BorrowBookLabel;
    private JButton BorrowBookButton;
    private JTextField BorrowBookTextField;
    private Image backgroundImage;

    public BorrowBookPanel() {
        setLayout(null); // 保持与主框架一致的布局方式
        setBackground(Color.yellow);
        JLabel label = new JLabel();
        label.setBounds(0, 0, 1000, 500);
        backgroundImage = new ImageIcon("src/main/java/top/playereg/sys/img/background_1.png").getImage();
        add(label);

        BorrowBookLabel = new JLabel("输入需借阅的图书编号");
        BorrowBookLabel.setForeground(Color.white);
        BorrowBookLabel.setFont(new Font("黑体", Font.BOLD, 25));
        BorrowBookLabel.setBounds(550, 150, 300, 50);
        add(BorrowBookLabel);

        BorrowBookTextField = new JTextField();
        BorrowBookTextField.setForeground(Color.black);
        BorrowBookTextField.setFont(new Font("黑体", Font.BOLD, 20));
        BorrowBookTextField.setBounds(550, 200, 250, 50);
        add(BorrowBookTextField);

        BorrowBookButton = new JButton(">>> 借阅 <<<");
        BorrowBookButton.setForeground(Color.black);
        BorrowBookButton.setFont(new Font("黑体", Font.BOLD, 20));
        BorrowBookButton.setBorderPainted(false);
        BorrowBookButton.setBackground(skyblue);
        BorrowBookButton.setBounds(550, 270, 250, 50);
        add(BorrowBookButton);

        BorrowBookButton.addActionListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, -10, -20, 1000, 562, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == BorrowBookButton) {
            String input = BorrowBookTextField.getText();
            if (input.isEmpty()) {
                JOptionPane.showMessageDialog(
                        null, // 父组件设为null，强制对话框在屏幕中央显示
                        "请输入图书编号",
                        "错误", // 标题
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            } else {
                try {
                    int bookId = Integer.parseInt(input);
                    if (bookId <= 0) {
                        JOptionPane.showMessageDialog(
                                null,
                                "图书编号必须为正整数",
                                "格式错误",
                                JOptionPane.ERROR_MESSAGE
                        );
                        return;
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(
                            null,
                            "请输入有效的数字编号",
                            "类型错误",
                            JOptionPane.ERROR_MESSAGE
                    );
                    return;
                }
            }
            int bookId = Integer.parseInt(input);
            System.out.println("BorrowBookButton: " + bookId);
            Books book = BookDao.getBook(bookId);
            if (book != null) {
                if (book.getBookNumber() <= 0) {
                    JOptionPane.showMessageDialog(
                            null, // 父组件设为null，强制对话框在屏幕中央显示
                            "借阅失败 书本数量不足",
                            "错误", // 标题
                            JOptionPane.ERROR_MESSAGE
                    );
                } else if (UserSaveTool.getCurerntLoginUserBookBorrowID() != 0) {
                    JOptionPane.showMessageDialog(
                            null, // 父组件设为null，强制对话框在屏幕中央显示
                            "借阅失败 借阅中",
                            "错误", // 标题
                            JOptionPane.ERROR_MESSAGE
                    );
                } else {
                    BookDao.updateBook(new Books(bookId, book.getBookName(), book.getBookNumber() - 1, book.getIs_del())); // 更新书籍数量
                    UserSaveTool.setCurerntLoginUserBookBorrowID(bookId); // 设置当前登录用户的借阅书籍ID
                    UserSaveTool.setCurerntLoginUserBookBorrowTime(System.currentTimeMillis());  // 设置当前登录用户的借阅书籍时间
                    UserDao.updateUserBookBorrowInfo(UserSaveTool.getCurerntLoginUserId(), bookId, System.currentTimeMillis()); // 更新用户借阅书籍信息
                    JOptionPane.showMessageDialog(
                            null, // 父组件设为null，强制对话框在屏幕中央显示
                            "借阅成功",
                            "提示", // 标题
                            JOptionPane.INFORMATION_MESSAGE
                    );
                }
            } else {
                JOptionPane.showMessageDialog(
                        null, // 父组件设为null，强制对话框在屏幕中央显示
                        "借阅失败 未找到该书本",
                        "错误", // 标题
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }
}
