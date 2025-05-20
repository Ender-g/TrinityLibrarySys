package top.playereg.sys.pages;

import com.sun.javafx.scene.shape.PathUtils;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

public class MangerInterface {
    JFrame jf = new JFrame("图书馆：xxx，欢迎您");
    //  定义宽高
    final int WIDTH = 1500;
    final int HEIGHT = 1000;


    public void init() {
        //给窗口设置属性
        jf.setSize(WIDTH, HEIGHT);
        jf.setLocationRelativeTo(null);
        jf.setResizable(false);
        jf.setIconImage(new ImageIcon("src/main/java/top/playereg/sys/img/book.png").getImage());

        //设置菜单栏
        JMenuBar jmb = new JMenuBar();

        JMenuItem jmi1 = new JMenuItem("      切换账号");
        JMenuItem jmi2 = new JMenuItem("      退出");
        // 设置最大宽度和高度
        jmi1.setMaximumSize(new Dimension(100, 30));
        jmi2.setMaximumSize(new Dimension(100, 30));

        // 设置首选尺寸（部分 LookAndFeel 支持）
        jmi1.setPreferredSize(new Dimension(100, 30));
        jmi2.setPreferredSize(new Dimension(100, 30));

        // 设置字体居中
        jmi1.setHorizontalAlignment(SwingConstants.CENTER);
        jmi2.setHorizontalAlignment(SwingConstants.CENTER);


        //添加菜单项
        jmi1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    jf.dispose();
                    new LoginFrame();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        //退出程序
        jmi2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        //添加菜单
        jmb.add(jmi1);
        jmb.add(Box.createHorizontalStrut(20));
        jmb.add(jmi2);
        //组装菜单
        jf.setJMenuBar(jmb);

        //设置分割面板
        JSplitPane jsp = new JSplitPane();
        //支持连续布局
        jsp.setContinuousLayout(true);
        jsp.setDividerLocation(200);
        jsp.setDividerSize(10);

        //设置左侧内容
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("系统管理");
        DefaultMutableTreeNode userManage = new DefaultMutableTreeNode("用户管理");
        DefaultMutableTreeNode bookManage = new DefaultMutableTreeNode("图书管理");
        DefaultMutableTreeNode borrowManage = new DefaultMutableTreeNode("借阅管理");
        DefaultMutableTreeNode statisticsMange = new DefaultMutableTreeNode("统计分析");
         //添加节点
        root.add(userManage);
        root.add(bookManage);
        root.add(borrowManage);
        root.add(statisticsMange);
        //设置树形结构
        JTree tree = new JTree(root);
        //添加节点图片
        MyRenderer myRenderer = new MyRenderer();
        tree.setCellRenderer(myRenderer);
        jsp.setLeftComponent(tree);

        jf.add(jsp);

        //窗口可见性
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        try {
            new MangerInterface().init();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private class MyRenderer extends DefaultTreeCellRenderer {
        private ImageIcon rootIcon = null;
        private ImageIcon userIcon = null;
        private ImageIcon bookIcon = null;
        private ImageIcon borrowIcon = null;
        private ImageIcon statisticsIcon = null;

         //
        public MyRenderer() {
            // 定义基础图片路径（相对于项目源码目录）
            String basePath = "src/main/java/top/playereg/sys/img/";
            //设置图标大小
             int iconWidth = 24;
            int iconHeight = 24;
            try {
                // 加载并缩放系统管理图标
                rootIcon = new ImageIcon(new ImageIcon(basePath + "xitong.png")
                        .getImage()
                        .getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH));
                // 加载并缩放系统管理图标
                userIcon = new ImageIcon(new ImageIcon(basePath + "yonghu.png")
                        .getImage()
                        .getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH));
                // 加载并缩放系统管理图标
                bookIcon = new ImageIcon(new ImageIcon(basePath + "book.png")
                        .getImage()
                        .getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH));
                // 加载并缩放系统管理图标
                borrowIcon = new ImageIcon(new ImageIcon(basePath + "jieyue.png")
                        .getImage()
                        .getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH));
                // 加载并缩放系统管理图标
                statisticsIcon = new ImageIcon(new ImageIcon(basePath + "bg-circular.png")
                        .getImage()
                        .getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH));

            } catch (Exception e) {
                System.err.println("加载图标资源失败，请检查路径！");
                e.printStackTrace();
            }
        }

        /**
         * 自定义树单元格渲染组件
         * 根据节点类型和行号为树节点设置不同的图标
         * 此方法重写了DefaultTreeCellRenderer的getTreeCellRendererComponent方法
         *
         * @param tree      树组件，用于显示树结构
         * @param value     节点的值，表示树节点的信息
         * @param sel       是否选中，表示当前节点是否被选中
         * @param expanded  是否展开，表示当前节点是否被展开
         * @param leaf      是否叶子节点，表示当前节点是否为叶子节点
         * @param row       节点行号，表示当前节点在树中的行号
         * @param hasFocus  是否焦点，表示当前节点是否拥有焦点
         * @return Component 返回树单元格渲染器组件，用于显示自定义的节点样式
         */
        @Override
        public Component getTreeCellRendererComponent(
                JTree tree, Object value,
                boolean sel, boolean expanded,
                boolean leaf, int row,
                boolean hasFocus
        ) {
            //使用默认绘制
            super.getTreeCellRendererComponent(tree, value, sel, expanded,
                    leaf, row, hasFocus);
            ImageIcon image = null;
            switch (row) {
                case 0: image = rootIcon; break;
                case 1: image = userIcon; break;
                case 2: image = bookIcon; break;
                case 3: image = borrowIcon; break;
                case 4: image = statisticsIcon; break;
            }

            this.setIcon(image);
            return this;
        }
    }

}
