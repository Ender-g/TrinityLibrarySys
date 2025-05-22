package top.playereg.sys.dao;

import javax.swing.*;
import java.sql.*;

public abstract class BaseDao<T> {

    // 静态代码块 被static修饰的语句只在类加载的时候执行
    static{
        // 建立连接
        // 1.1 加载驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    protected Connection conn;
    protected PreparedStatement statement;
    protected ResultSet set;
    void close(){
        try {
            if(set != null)set.close();
            if(statement != null)statement.close();
            if(conn != null)conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    Connection getConnection(){
        // 1.2 建立连接
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db_mobile?serverTimezone=Asia/Shanghai",
                    "root","root");
            return conn;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
            return null;
        }
    }
    // 通用的增删改方法
    int commonUpdate(String sql,Object... params){
        getConnection();
        try {
            statement = conn.prepareStatement(sql);
            if(params != null){
                for (int i=0;i<params.length;i++){
                    statement.setObject(i+1,params[i]);
                }
            }
            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally{
            close();
        }
    }

    // 通用的查询方法
    ResultSet commonQuery(String sql,Object... params){
        getConnection();
        try {
            statement = conn.prepareStatement(sql);
            if(params != null){
                for (int i=0;i<params.length;i++){
                    statement.setObject(i+1,params[i]);
                }
            }
            return statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    abstract T columnToProperty()throws SQLException;
}
