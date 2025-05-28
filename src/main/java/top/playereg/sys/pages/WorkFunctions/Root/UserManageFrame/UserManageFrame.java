package top.playereg.sys.pages.WorkFunctions.Root.UserManageFrame;

import top.playereg.sys.utils.SetFrameTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserManageFrame extends JFrame implements ActionListener {
    private JLabel topPanel, bottomPanel;
    private JButton[] topBtn = new JButton[]{
            new JButton("所有用户"),
            new JButton("查询用户"),
            new JButton("删除用户"),
            new JButton("赋予权限")
    };

    public static void main(String[] args) {
        new UserManageFrame();
    }

    public UserManageFrame() {
        // 初始化窗口
        SetFrameTool.setFrame(
                "用户管理",
                1000,
                600,
                "src/main/java/top/playereg/sys/img/book.png",
                this);

        // 设置关闭操作
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                dispose();
            }
        });

        // 创建顶部菜单
        topPanel = new JLabel();
        topPanel.setOpaque(true);
        topPanel.setLayout(null);
        this.add(topPanel);
        bottomPanel = new JLabel();
        bottomPanel.setOpaque(true);
        bottomPanel.setLayout(null);
        this.add(bottomPanel);
        SetFrameTool.setTopMenuStyle(topBtn, Color.white,
                Color.black, topPanel, bottomPanel, 0);

        this.setLayout(null);
        setVisible(true);

        for (JButton button : topBtn) button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (JButton button : topBtn) {
            if (e.getSource() == button) {
                System.out.println(button.getText());
                switch (button.getText()) {
                    case "所有用户": {
                        SetFrameTool.updateTopMenuStyle(topBtn, button);
                        bottomPanel.removeAll();
                        ListAllUserPanel listAllUserPanel = new ListAllUserPanel();
                        listAllUserPanel.setBounds(
                                0, 0,
                                bottomPanel.getWidth(),
                                bottomPanel.getHeight()
                        );
                        bottomPanel.add(listAllUserPanel);
                        bottomPanel.revalidate();
                        bottomPanel.repaint();
                        break;
                    }

                    case "查询用户": {
                        SetFrameTool.updateTopMenuStyle(topBtn, button);
                        bottomPanel.removeAll();
                        InquirieUserPanel inquireUserPanel = new InquirieUserPanel();
                        inquireUserPanel.setBounds(
                                0, 0,
                                bottomPanel.getWidth(),
                                bottomPanel.getHeight()
                        );
                        bottomPanel.add(inquireUserPanel);
                        bottomPanel.revalidate();
                        bottomPanel.repaint();
                        break;
                    }

                    case "删除用户": {
                        SetFrameTool.updateTopMenuStyle(topBtn, button);
                        bottomPanel.removeAll();
                        DelUserPanel delUserPanel = new DelUserPanel();
                        delUserPanel.setBounds(
                                0, 0,
                                bottomPanel.getWidth(),
                                bottomPanel.getHeight()
                        );
                        bottomPanel.add(delUserPanel);
                        bottomPanel.revalidate();
                        bottomPanel.repaint();
                        break;
                    }

                    case "赋予权限": {
                        SetFrameTool.updateTopMenuStyle(topBtn, button);
                        bottomPanel.removeAll();
                        GiveRootPanel giveRootPanel = new GiveRootPanel();
                        giveRootPanel.setBounds(
                                0, 0,
                                bottomPanel.getWidth(),
                                bottomPanel.getHeight()
                        );
                        bottomPanel.add(giveRootPanel);
                        bottomPanel.revalidate();
                        bottomPanel.repaint();
                        break;
                    }

                    default:
                        break;
                }
            }
        }
    }
}
