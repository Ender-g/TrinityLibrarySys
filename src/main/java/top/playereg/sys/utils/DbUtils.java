/*
 *
 * @author: playereg
 * @description: 数据库连接工具类
 * @version: 1.0
 *
 * */

package top.playereg.sys.utils;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtils {
    public static void main(String[] args) {
        System.out.println("test:"+DbUtils.getConn());
    }

    // 加载驱动
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "数据库驱动加载失败！未找到驱动包");
        }
    }
    public static Connection getConn() {
        try {
            Connection conn = null;
            String url = "jdbc:mysql://127.0.0.1:3306/db_library_app?useSSL=false&serverTimezone=Asia/Shanghai";
            String username = "root";
            String password = "123456";
            return DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "数据库驱动加载失败！用户名或密码错误");
            return null;
        }
    }
}
