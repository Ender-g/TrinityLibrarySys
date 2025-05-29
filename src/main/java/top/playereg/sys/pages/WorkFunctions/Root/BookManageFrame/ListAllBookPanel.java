/*
 *
 * @author: playereg
 * @description: 列举图书表
 * @version: 1.0
 *
 * */

package top.playereg.sys.pages.WorkFunctions.Root.BookManageFrame;

import top.playereg.sys.dao.BookDao;
import top.playereg.sys.entity.Books;
import top.playereg.sys.utils.SetFrameTool;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

import static top.playereg.sys.utils.DiyColors.*;

public class ListAllBookPanel extends JPanel {
    private String[] columnNames = {"图书编号", "图书名称", "图书数量"};
    private DefaultTableModel tableModel;
    private JTable table;

    public ListAllBookPanel() {
        setLayout(null);
        setBackground(Color.cyan);

        // 初始化表格模型
        tableModel = new DefaultTableModel(null, columnNames);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // 设置表格样式
        scrollPane.setBounds(40, 10, 900, 500);
        scrollPane.setFont(new Font("黑体", Font.PLAIN, 16));
        scrollPane.setOpaque(false);
        table.setRowHeight(30);
        table.setFont(new Font("黑体", Font.PLAIN, 16));
        table.getTableHeader().setReorderingAllowed(false); // 禁止拖动列

        // 设置列宽
        table.getColumnModel().getColumn(0).setMinWidth(70);
        table.getColumnModel().getColumn(0).setMaxWidth(100);
        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setMinWidth(70);
        table.getColumnModel().getColumn(2).setMaxWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);

        // 添加滚动面板到面板
        add(scrollPane);

        table.setEnabled(false);

        // 加载数据
        loadBooksData();
    }

    // 从数据库加载书籍数据并填充到表格
    private void loadBooksData() {
        List<Books> booksList = BookDao.getAllBooks(); // 调用 DAO 获取数据

        // 清空现有表格数据
        tableModel.setRowCount(0);

        for (Books book : booksList) {
            Object[] row = {
                    book.getId(),
                    book.getBookName(),
                    book.getBookNumber()
            };
            tableModel.addRow(row);
        }
    }
}
