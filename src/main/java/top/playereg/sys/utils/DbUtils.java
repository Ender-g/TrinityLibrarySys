/*
 *
 * @author: playereg
 * @description: 数据库工具类
 * @version: 1.0
 *
 * */

package top.playereg.sys.utils;

import javax.swing.*;
import java.sql.*;

public abstract class DbUtils<T> {
    // 静态代码块 被static修饰的语句只在类加载的时候执行
    static {
        // 建立连接
        // 1.1 加载驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    protected static Connection conn; // 数据库连接
    protected PreparedStatement statement; // 预编译语句
    protected ResultSet set; // 结果集

    void close() {
        try {
            if (set != null) set.close();
            if (statement != null) statement.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        // 1.2 建立连接
        try {
            /*
            本地数据库连接：
            String url = "jdbc:mysql://127.0.0.1:3306/db_library_app?useSSL=false&serverTimezone=Asia/Shanghai";
            String username = "root";
            String password = "123456";
            */

            // 远程Mysql连接
            String url = "jdbc:mysql://frp-put.com:33060/db_library_app?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=Asia/Shanghai";
            String username = "dev";
            String password = "dev";
            conn = DriverManager.getConnection(url, username, password);
            return conn;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }

    // 通用的增删改方法
    int commonUpdate(String sql, Object... params) {
        getConnection();
        try {
            statement = conn.prepareStatement(sql);
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    statement.setObject(i + 1, params[i]);
                }
            }
            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            close();
        }
    }

    // 通用的查询方法
    ResultSet commonQuery(String sql, Object... params) {
        getConnection();
        try {
            statement = conn.prepareStatement(sql);
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    statement.setObject(i + 1, params[i]);
                }
            }
            return statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    // 将结果集的列名映射为属性名
    abstract T columnToProperty() throws SQLException;

}
