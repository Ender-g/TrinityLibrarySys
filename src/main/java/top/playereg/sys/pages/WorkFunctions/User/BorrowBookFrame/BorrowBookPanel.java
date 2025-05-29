package top.playereg.sys.pages.WorkFunctions.User.BorrowBookFrame;

import javax.swing.*;
import java.awt.*;

public class BorrowBookPanel extends JPanel {
    private JLabel BorrowBookLabel;
    private JButton BorrowBookButton;
    private JTextField BorrowBookTextField;
        public BorrowBookPanel() {
            setLayout(null); // 保持与主框架一致的布局方式
            setBackground(Color.yellow);
            JLabel label = new JLabel();
            label.setBounds(0, 0 ,1000, 500);
            add(label);

            BorrowBookLabel = new JLabel("请输入图书编号：");
            BorrowBookLabel.setFont(new Font("黑体", Font.BOLD, 20));
            BorrowBookLabel.setBounds(100, 100, 200, 50);
            add(BorrowBookLabel);

            BorrowBookTextField = new JTextField();
            BorrowBookTextField.setFont(new Font("黑体", Font.BOLD, 20));
            BorrowBookTextField.setBounds(300, 100, 200, 50);
            add(BorrowBookTextField);

            BorrowBookButton = new JButton("借阅");
            BorrowBookButton.setFont(new Font("黑体", Font.BOLD, 20));
            BorrowBookButton.setBorderPainted(false);
            BorrowBookButton.setBounds(520, 100, 100, 50);
            add(BorrowBookButton);




        }



}
