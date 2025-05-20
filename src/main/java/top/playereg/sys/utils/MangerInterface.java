package top.playereg.sys.utils;

import com.sun.corba.se.spi.activation.BadServerDefinition;
import javafx.stage.Screen;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class MangerInterface {
    JFrame jf = new JFrame("图书馆：xxx，欢迎您");

    final int WIDTH = 1000;
    final int HEIGHT = 600;



    public  void init(){
    //给窗口设置属性
        jf.setSize(WIDTH, HEIGHT);
       jf.setLocationRelativeTo(null);
        jf.setResizable(false);
        jf.setIconImage(new ImageIcon("src/main/resources/img/logo.png").getImage());

        //设置菜单栏
        JMenuBar jmb = new JMenuBar();
        JMenu jMenu = new JMenu("系统设置");
        JMenuItem jmi1 = new JMenuItem("切换账号");
        JMenuItem jmi2 = new JMenuItem("退出程序");

        //添加菜单项
        //切换账号等登录完善

        //退出程序
        jmi2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        //JMenu.add(jmi1);
        jMenu.add(jmi2);
        jmb.add(jMenu);

        jf.setJMenuBar(jmb);





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
