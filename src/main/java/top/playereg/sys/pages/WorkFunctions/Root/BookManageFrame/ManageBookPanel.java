/*
 *
 * @author: playereg
 * @description: 图书增删改
 * @version: 1.0
 *
 * */

package top.playereg.sys.pages.WorkFunctions.Root.BookManageFrame;

import top.playereg.sys.dao.BookDao;
import top.playereg.sys.entity.Books;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static top.playereg.sys.utils.DiyColors.lightblue;
import static top.playereg.sys.utils.DiyColors.skyblue;

public class ManageBookPanel extends JPanel implements ActionListener {
    private JPanel topPanel, middlePanel, bottomPanel;
    private JButton addBtn, delBtn, changeBtn; // 添加，删除，恢复，修改按钮
    // 添加部分面板中添加组件
    private JLabel addBookNameLabel, addBookNumberLabel; // 书名，数量（文本）
    private JTextField addBookNameText, addBookNumberText; // 书名，数量（文本框）
    // 删除恢复部分面板中添加组件
    private JLabel delBookIDLabel; // 书籍ID（文本）
    private JTextField delBookIDText; // 书籍ID（文本框）
    // 修改部分面板中添加组件
    private JLabel changeBookIDLabel, changeBookNameLabel, changeBookNumberLabel; // 书籍ID，书名，数量（文本）
    private JTextField changeBookIDText, changeBookNameText, changeBookNumberText; // 书籍ID，书名，数量（文本框）

    public ManageBookPanel() {
        setLayout(null);
        /* 创建上下半部分面板%start===================================================================================== */
        // 上半部分面板高度-添加
        int PanelHeight = 180;
        JPanel topPanel = new JPanel();
        topPanel.setBackground(skyblue);
        topPanel.setBounds(0, 0, 1000, PanelHeight);
        topPanel.setLayout(null);
        add(topPanel);
        // 中段部分面板-删除
        JPanel middlePanel = new JPanel();
        middlePanel.setBackground(lightblue);
        middlePanel.setBounds(0, PanelHeight, 1000, PanelHeight);
        middlePanel.setLayout(null);
        add(middlePanel);
        // 下半部分面板-修改
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(skyblue);
        bottomPanel.setBounds(0, 2 * PanelHeight, 1000, PanelHeight);
        bottomPanel.setLayout(null);
        add(bottomPanel);
        /* 创建上下半部分面板%end===================================================================================== */

        /* 添加部分面板中添加组件%start================================================================================== */
        // 添加按钮
        addBtn = new JButton("添加");
        addBtn.setBounds(850, 70, 100, 40);
        addBtn.setBackground(Color.green);
        addBtn.setForeground(Color.black);
        addBtn.setFont(new Font("黑体", Font.BOLD, 20));
        addBtn.setBorderPainted(false);
        topPanel.add(addBtn);
        // 书名
        addBookNameLabel = new JLabel("书名：");
        addBookNameLabel.setBounds(50, 70, 100, 40);
        addBookNameLabel.setFont(new Font("黑体", Font.BOLD, 20));
        topPanel.add(addBookNameLabel);
        addBookNameText = new JTextField();
        addBookNameText.setBounds(120, 70, 200, 40);
        addBookNameText.setFont(new Font("黑体", Font.BOLD, 20));
        topPanel.add(addBookNameText);
        // 数量
        addBookNumberLabel = new JLabel("数量：");
        addBookNumberLabel.setBounds(350, 70, 100, 40);
        addBookNumberLabel.setFont(new Font("黑体", Font.BOLD, 20));
        topPanel.add(addBookNumberLabel);
        addBookNumberText = new JTextField();
        addBookNumberText.setBounds(420, 70, 100, 40);
        addBookNumberText.setFont(new Font("黑体", Font.BOLD, 20));
        topPanel.add(addBookNumberText);
        /* 添加部分面板中添加组件%end================================================================================== */

        /* 在删除部分面板中添加组件%start================================================================================== */
        // 删除按钮
        delBtn = new JButton("删除");
        delBtn.setBounds(850, 70, 100, 40);
        delBtn.setBackground(Color.red);
        delBtn.setForeground(Color.black);
        delBtn.setFont(new Font("黑体", Font.BOLD, 20));
        delBtn.setBorderPainted(false);
        middlePanel.add(delBtn);
        // 书籍ID
        delBookIDLabel = new JLabel("ID：");
        delBookIDLabel.setBounds(50, 70, 100, 40);
        delBookIDLabel.setFont(new Font("黑体", Font.BOLD, 20));
        middlePanel.add(delBookIDLabel);
        delBookIDText = new JTextField();
        delBookIDText.setBounds(120, 70, 200, 40);
        delBookIDText.setFont(new Font("黑体", Font.BOLD, 20));
        middlePanel.add(delBookIDText);
        /* 在删除部分面板中添加组件%end================================================================================== */

        /* 在修改部分面板中添加组件%start================================================================================== */
        // 修改按钮
        changeBtn = new JButton("修改");
        changeBtn.setBounds(850, 70, 100, 40);
        changeBtn.setBackground(Color.yellow);
        changeBtn.setForeground(Color.black);
        changeBtn.setFont(new Font("黑体", Font.BOLD, 20));
        changeBtn.setBorderPainted(false);
        bottomPanel.add(changeBtn);
        // 书籍ID
        changeBookIDLabel = new JLabel("ID：");
        changeBookIDLabel.setBounds(50, 70, 100, 40);
        changeBookIDLabel.setFont(new Font("黑体", Font.BOLD, 20));
        bottomPanel.add(changeBookIDLabel);
        changeBookIDText = new JTextField();
        changeBookIDText.setBounds(120, 70, 200, 40);
        changeBookIDText.setFont(new Font("黑体", Font.BOLD, 20));
        bottomPanel.add(changeBookIDText);
        // 书名
        changeBookNameLabel = new JLabel("书名：");
        changeBookNameLabel.setBounds(350, 70, 100, 40);
        changeBookNameLabel.setFont(new Font("黑体", Font.BOLD, 20));
        bottomPanel.add(changeBookNameLabel);
        changeBookNameText = new JTextField();
        changeBookNameText.setBounds(420, 70, 200, 40);
        changeBookNameText.setFont(new Font("黑体", Font.BOLD, 20));
        bottomPanel.add(changeBookNameText);
        // 数量
        changeBookNumberLabel = new JLabel("数量：");
        changeBookNumberLabel.setBounds(650, 70, 100, 40);
        changeBookNumberLabel.setFont(new Font("黑体", Font.BOLD, 20));
        bottomPanel.add(changeBookNumberLabel);
        changeBookNumberText = new JTextField();
        changeBookNumberText.setBounds(720, 70, 100, 40);
        changeBookNumberText.setFont(new Font("黑体", Font.BOLD, 20));
        bottomPanel.add(changeBookNumberText);
        /* 在修改部分面板中添加组件%end================================================================================== */

        addBtn.addActionListener(this);
        delBtn.addActionListener(this);
        changeBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 添加图书
        if (e.getSource() == addBtn) {
            System.out.println("添加");
            if (addBookNameText.getText().equals("") || addBookNumberText.getText().equals("")) {
                JOptionPane.showMessageDialog(
                        null, // 父组件设为null，强制对话框在屏幕中央显示
                        "书名和数量不能为空",
                        "提示", // 标题
                        JOptionPane.INFORMATION_MESSAGE
                );
            } else {
                Books book = new Books();
                book.setBookName(addBookNameText.getText());
                book.setBookNumber(Integer.parseInt(addBookNumberText.getText()));
                book.setIs_del("0");
                BookDao bookDao = new BookDao();
                if (bookDao.addBook(book)) {
                    JOptionPane.showMessageDialog(
                            null, // 父组件设为null，强制对话框在屏幕中央显示
                            "添加成功",
                            "提示", // 标题
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    addBookNameText.setText("");
                    addBookNumberText.setText("");
                } else {
                    JOptionPane.showMessageDialog(
                            null, // 父组件设为null，强制对话框在屏幕中央显示
                            "添加失败",
                            "提示", // 标题
                            JOptionPane.INFORMATION_MESSAGE
                    );
                }
            }
        }
        // 删除图书
        if (e.getSource() == delBtn) {
            System.out.println("删除");
            if (delBookIDText.getText().equals("")) {
                JOptionPane.showMessageDialog(
                        null, // 父组件设为null，强制对话框在屏幕中央显示
                        "ID不能为空",
                        "提示", // 标题
                        JOptionPane.INFORMATION_MESSAGE
                );
            } else {
                BookDao bookDao = new BookDao();
                if (bookDao.deleteBook(Integer.parseInt(delBookIDText.getText()))) {
                    JOptionPane.showMessageDialog(
                            null, // 父组件设为null，强制对话框在屏幕中央显示
                            "删除成功",
                            "提示", // 标题
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    delBookIDText.setText("");
                } else {
                    JOptionPane.showMessageDialog(
                            null, // 父组件设为null，强制对话框在屏幕中央显示
                            "删除失败 书本不存在",
                            "提示", // 标题
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    delBookIDText.setText("");
                }
            }
        }
        // 修改图书
        if (e.getSource() == changeBtn) {
            if (changeBookIDText.getText().isEmpty()) {
                if (changeBookNameText.getText().isEmpty() && changeBookNumberText.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(
                            null, // 父组件设为null，强制对话框在屏幕中央显示
                            "请完善需要修改的书本信息",
                            "提示", // 标题
                            JOptionPane.INFORMATION_MESSAGE
                    );
                }
            } else if (changeBookNameText.getText().isEmpty() && changeBookNumberText.getText().isEmpty()) {
                JOptionPane.showMessageDialog(
                        null, // 父组件设为null，强制对话框在屏幕中央显示
                        "请完善需要修改的书本信息",
                        "提示", // 标题
                        JOptionPane.INFORMATION_MESSAGE
                );
            } else if (BookDao.getBook(Integer.parseInt(changeBookIDText.getText())) == null ||
                    BookDao.getBook(Integer.parseInt(changeBookIDText.getText())).getIs_del().equals("1")
            ) {
                JOptionPane.showMessageDialog(
                        null, // 父组件设为null，强制对话框在屏幕中央显示
                        "书本不存在",
                        "提示", // 标题
                        JOptionPane.INFORMATION_MESSAGE
                );
            } else {
                Books book = new Books();
                book.setId(Integer.parseInt(changeBookIDText.getText()));
                // 如果书名数量为空，则保持数据库中原来的数据
                if (changeBookNameText.getText().isEmpty()) {
                    // 获取数据库中原有的书名
                    book.setBookName(
                            BookDao.getBook(Integer.parseInt(changeBookIDText.getText())).getBookName()
                    );
                } else {
                    book.setBookName(changeBookNameText.getText());
                }
                if (changeBookNumberText.getText().isEmpty()) {
                    book.setBookNumber(
                            BookDao.getBook(Integer.parseInt(changeBookIDText.getText())).getBookNumber()
                    );
                } else {
                    book.setBookNumber(Integer.parseInt(changeBookNumberText.getText()));
                }
                book.setIs_del("0");
                if (BookDao.updateBook(book)) {
                    JOptionPane.showMessageDialog(
                            null, // 父组件设为null，强制对话框在屏幕中央显示
                            "修改成功",
                            "提示", // 标题
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    changeBookIDText.setText("");
                    changeBookNameText.setText("");
                    changeBookNumberText.setText("");
                } else {
                    JOptionPane.showMessageDialog(
                            null, // 父组件设为null，强制对话框在屏幕中央显示
                            "修改失败 书本不存在",
                            "错误", // 标题
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        }
    }
}
