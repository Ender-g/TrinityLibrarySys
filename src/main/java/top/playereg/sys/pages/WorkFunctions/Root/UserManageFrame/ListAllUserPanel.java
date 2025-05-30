package top.playereg.sys.pages.WorkFunctions.Root.UserManageFrame;

import top.playereg.sys.dao.UserDao;
import top.playereg.sys.entity.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

import static top.playereg.sys.utils.DiyColors.skyblue;

public class ListAllUserPanel extends JPanel {
    private String[] columnNames = {"ID", "用户名", "邮箱", "权限"};
    private DefaultTableModel tableModel;
    private JTable table;

    public ListAllUserPanel() {
        setLayout(null);
        setBackground(Color.white);

        // 初始化表格模型
        tableModel = new DefaultTableModel(null, columnNames);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // 设置表格样式
        scrollPane.setBounds(10, 10, 965, 510);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.black));

        table.getTableHeader().setBackground(skyblue);
        table.getTableHeader().setPreferredSize(new Dimension(table.getTableHeader().getWidth(), 30));
        table.getTableHeader().setFont(new Font("黑体", Font.BOLD, 20));
        table.setRowHeight(30);
        table.setFont(new Font("黑体", Font.PLAIN, 20));
        table.getTableHeader().setReorderingAllowed(false); // 禁止拖动列
        table.getTableHeader().setResizingAllowed(false); // 禁止列宽拖动

        // 设置列宽
        table.getColumnModel().getColumn(0).setMinWidth(80);
        table.getColumnModel().getColumn(0).setMaxWidth(80);
        table.getColumnModel().getColumn(1).setMinWidth(200);
        table.getColumnModel().getColumn(1).setMaxWidth(200);
        table.getColumnModel().getColumn(3).setMinWidth(100);
        table.getColumnModel().getColumn(3).setMaxWidth(100);

        // 添加滚动面板到面板
        add(scrollPane);

        table.setEnabled(false); // 禁用表格编辑功能

        // 加载数据
        loadUsersData();
    }

    // 从数据库加载用户数据并填充到表格
    private void loadUsersData() {
        List<User> userList = UserDao.getAllUsers(); // 调用 DAO 获取数据

        // 清空现有表格数据
        tableModel.setRowCount(0);

        for (User user : userList) {
            Object[] row = {
                    user.getId(),
                    user.getUsername(),
                    user.getEmail(),
                    "1".equals(user.getIs_root()) ? "管理员" : "普通用户"
            };
            tableModel.addRow(row);
        }
    }
}