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

    final int WIDTH = 1500;
    final int HEIGHT = 1000;



    public  void init(){
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
        //切换账号等登录完善
        jmi1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    jf.dispose();
                    new LoginFrame();
                }catch (Exception ex){
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
        jmb.add(jmi1);
        jmb.add(Box.createHorizontalStrut(20));
        jmb.add(jmi2);


        jf.setJMenuBar(jmb);

        //设置分割面板
        JSplitPane jsp = new JSplitPane();

        //支持连续布局
        jsp.setContinuousLayout(true);
        jsp.setDividerLocation(200);
        jsp.setDividerSize(10);


        //设置左侧内容
        DefaultMutableTreeNode  root = new DefaultMutableTreeNode("系统管理");
        DefaultMutableTreeNode  userManage = new DefaultMutableTreeNode("用户管理");
        DefaultMutableTreeNode  bookManage = new DefaultMutableTreeNode("图书管理");
        DefaultMutableTreeNode  borrowManage = new DefaultMutableTreeNode("借阅管理");
        DefaultMutableTreeNode  statisticsMange = new DefaultMutableTreeNode("统计分析");

        root.add(userManage);
        root.add(bookManage);
        root.add(borrowManage);
        root.add(statisticsMange);

        JTree tree = new JTree(root);
        jsp.setLeftComponent(tree);
        jf.add(jsp);






        jf.setVisible(true);



    }

    public static void main(String[] args) {
        try  {
            new MangerInterface().init();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private class MyRenderer extends DefaultTreeCellRenderer {
        private Image rootIcon = null;
        private Image userIcon = null;
        private Image bookIcon = null;
        private Image borrowIcon = null;
        private Image statisticsIcon = null;
            //ImageIO.read(new File(PathUtils.getResource("top/playereg/sys/img/book.png")));
        public MyRenderer() {
            try {
                rootIcon = ImageIO.read(new File("src/main/java/top/playereg/sys/img/xitong.png"));
                userIcon = ImageIO.read(new File("src/main/java/top/playereg/sys/img/yonghu.png"));
                bookIcon = ImageIO.read(new File("src/main/java/top/playereg/sys/img/shu.png"));
                borrowIcon = ImageIO.read(new File("src/main/java/top/playereg/sys/img/jieyue.png"));
                statisticsIcon = ImageIO.read(new File("src/main/java/top/playereg/sys/img/tongji.png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        //

        @Override
        public  Component getTreeCellRendererComponent(JTree tree, Object value,
                                                      boolean sel, boolean expanded,
                                                      boolean leaf, int row,
                                                      boolean hasFocus) {
            //使用默认绘制
            super.getTreeCellRendererComponent(tree, value, sel, expanded,
                    leaf, row, hasFocus);

            return this;

        }
    }

}
