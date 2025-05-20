package top.playereg.sys.pages;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MangerInterface {
    JFrame jf = new JFrame("图书馆：xxx，欢迎您");

    final int WIDTH = 1500;
    final int HEIGHT = 1000;



    public  void init(){
    //给窗口设置属性
        jf.setSize(WIDTH, HEIGHT);
        jf.setLocationRelativeTo(null);
        jf.setResizable(false);
        jf.setIconImage(new ImageIcon("src/main/java/top/playereg/sys/img/logo.jpg").getImage());


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





        jf.setVisible(true);


    }

    public static void main(String[] args) {
        try  {
            new MangerInterface().init();
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
