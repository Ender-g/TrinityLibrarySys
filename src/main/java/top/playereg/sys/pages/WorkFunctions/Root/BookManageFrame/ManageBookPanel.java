package top.playereg.sys.pages.WorkFunctions.Root.BookManageFrame;

import javax.swing.*;
import java.awt.*;

import static top.playereg.sys.utils.DiyColors.*;

public class ManageBookPanel extends JPanel {
    private JPanel topPanel, middlePanel, bottomPanel;
    private JButton addBtn, delBtn, changeBtn; // 添加，删除，修改按钮
    // 添加部分面板中添加组件
    private JLabel addBookNameLabel, addBookNumberLabel; // 书名，数量（文本）
    private JTextField addBookNameText, addBookNumberText; // 书名，数量（文本框）
    // 删除部分面板中添加组件
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
    }
}
