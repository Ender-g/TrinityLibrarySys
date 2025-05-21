/*
 *
 * @author: playereg
 * @description: 设置窗体工具类
 * @version: 1.0
 *
 * */

package top.playereg.sys.utils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.Vector;

public class SetFrameTool extends JFrame {
    /* 设置窗体工具类 */
    public static void setFrame(
            String title, // 窗体标题
            int width, // 窗体宽度
            int height, // 窗体高度
            String iconPath, // 图标路径
            JFrame Frame // 要设置窗体的对象
    ) {
        Frame.setTitle(title); // 设置窗体标题
        Frame.setSize(width, height); // 设置窗体大小
        Frame.setLocationRelativeTo(null); // 居中显示
        Frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // 设置关闭按钮
        Frame.setResizable(false); // 设置窗体不可拉伸
        Frame.setVisible(false); // 设置窗体可见
        Frame.setIconImage(new ImageIcon(iconPath).getImage()); //  设置窗体图标
    }

    /* 设置面板背景图片工具类 */
    public static void setPanleBackgroundImg(
            String imgPath, // 图片路径
            int x, // 组件x坐标
            int y, // 组件y坐标
            int width, // 组件宽度
            int height, // 组件高度
            JLabel Label // 组件所在面板
    ) {
        ImageIcon icon = new ImageIcon(imgPath);
        Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        icon = new ImageIcon(img);

        JLabel imgLabel = new JLabel(icon); // 使用调整后的图标创建标签
        imgLabel.setBounds(x, y, width, height);
        Label.add(imgLabel);
    }

    /* 设置字体样式工具类 */
    public static void setFontStyle(
            JComponent component, // 组件名称
            int fontSize, // 字体大小
            Color fontColor, // 字体颜色
            int x, // 组件x坐标
            int y, // 组件y坐标
            int width, // 组件宽度
            int height, // 组件高度
            JLabel Panel // 组件所在面板
    ) {
        component.setFont(new Font("黑体", Font.BOLD, fontSize));
        component.setForeground(fontColor);
        component.setBounds(x, y, width, height);
        Panel.add(component);
    }

    /* 设置按钮样式工具类 */
    public static void setBtnStyle(
            JButton jButton, // 按钮名称
            Color btnColor, // 按钮颜色
            Color btnTextColor, // 按钮文字颜色
            int fontSize, // 字体大小
            int x, // 组件x坐标
            int y, // 组件y坐标
            int width, // 组件宽度
            int height, // 组件高度
            JLabel Panel // 组件所在面板
    ) {
        jButton.setBackground(btnColor);
        jButton.setFont(new Font("黑体", Font.BOLD, fontSize));
        jButton.setForeground(btnTextColor);
        jButton.setBounds(x, y, width, height);
        Panel.add(jButton);
    }

    //

    public static class UserManageComponent extends Box {
        // 组件宽高
        final int width = 850;
        final int height = 600;
        // 声明表格
        private  JTable table;
        //创建数组存放字段
        private Vector<String> titles;
        //创建二维数组存放数据
        private Vector<Vector> tableData;
        //声明表格数据模型
        private TableModel tableModel;

        public UserManageComponent() {
            // 调用父类构造器并指定垂直布局
            super(BoxLayout.Y_AXIS);
            //组装视图
            //组装上方按钮面板
            JPanel btnPanel = new JPanel();
            btnPanel.setMaximumSize(new Dimension(width, 80));
            //从右边布局
            btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
            //添加按钮
            JButton addBtn = new JButton("添加");
            //修改按钮
            JButton update = new JButton("修改");
            //删除按钮
            JButton delete = new JButton("删除");
            btnPanel.add(addBtn);
            btnPanel.add(update);
            btnPanel.add(delete);

            this.add(btnPanel);
            //组装下方表格
            String[] ts={"编号","书名","简介","作者","价格","库存"};
            //初始化
            titles = new Vector<>();
            //遍历数组
            for (String title : ts) {
                //将数组元素添加到向量
                titles.add(title);
            }
            //实例化表格
            tableData = new Vector<>();
            //创建表格数据模型
            tableModel = new DefaultTableModel(tableData, titles);
            table = new JTable(tableModel) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            //设置只能选中一行
            table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            this.add(table);

        }
        //请求数据
//        public void requestData(){
//            GetUtils.get()
//
//        }

    }



}
