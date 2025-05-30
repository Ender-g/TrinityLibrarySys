package top.playereg.sys.pages.WorkFunctions.User.UserWorkFrame;

import javax.swing.*;
import java.awt.*;

import static top.playereg.sys.utils.DiyColors.*;

public class BorrowBookPanel extends JPanel {
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

        BorrowBookButton = new JButton("借阅");
        BorrowBookButton.setForeground(Color.black);
        BorrowBookButton.setFont(new Font("黑体", Font.BOLD, 20));
        BorrowBookButton.setBorderPainted(false);
        BorrowBookButton.setBackground(skyblue);
        BorrowBookButton.setBounds(550, 270, 250, 50);
        add(BorrowBookButton);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, -10, -20, 1000, 562, this);
    }
}
