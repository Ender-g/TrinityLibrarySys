/*
 *
 * @Author: Playereg
 * @description: 用户数据访问层
 * @version: 1.0
 *
 * */

package top.playereg.sys.dao;

import javax.swing.*;
import java.sql.*;


import top.playereg.sys.entity.User;
import top.playereg.sys.utils.DbUtils;
import top.playereg.sys.utils.HashTool;
import top.playereg.sys.utils.UserSaveTool;

public class UserDao {

    /* 登录逻辑%start========================================================================================== */
    public static boolean login(
            String email,
            String password
    ) {
        Connection conn = DbUtils.getConnection();
        PreparedStatement ps = null; // 预编译
        String sql = "select * from tb_user where email = ? and password = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, HashTool.toHashCode(password));
            ResultSet rs = ps.executeQuery(); // 执行查询
            if (rs.next() && rs.getString("email").equals(email)) {
                if (rs.getString("password").equals(HashTool.toHashCode(password))) {
                    UserSaveTool.setCurerntLoginUserName(rs.getString("username"));
                    UserSaveTool.setCurerntLoginUserPassword(rs.getString("password"));
                    UserSaveTool.setCurerntLoginUserEmail(rs.getString("email"));
                    UserSaveTool.setCurerntLoginUserIsRoot(rs.getString("is_root"));
                    UserSaveTool.setCurerntLoginUserIsDel(rs.getString("is_del"));
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "密码错误！", "错误", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            } else {
                JOptionPane.showMessageDialog(null, "用户不存在！", "错误", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "数据库操作失败！请检查数据库是否正常！", "错误", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    /* 登录逻辑%end========================================================================================== */

    /* 注册逻辑%start========================================================================================== */
    public static boolean register(User user) {
        Connection conn = DbUtils.getConnection();
        PreparedStatement ps = null;
        String sql;
        try {
            // 检查邮箱是否已存在
            sql = "select * from tb_user where email = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ResultSet rs = ps.executeQuery();
            // 邮箱不存在，继续插入新用户
            sql = "insert into tb_user (username, password, email, is_root, is_del) values (?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getIs_root());
            ps.setString(5, user.getIs_del());
            int count = ps.executeUpdate();
            if (count > 0) {
                JOptionPane.showMessageDialog(null, "注册成功！", "成功", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "注册失败！", "错误", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "数据库操作失败！请检查数据库是否正常！", "错误", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    /* 注册逻辑%end========================================================================================== */

    /* 修改改密码逻辑%start========================================================================================== */
    public static boolean updatePassword(User user) {
        Connection conn = DbUtils.getConnection();
        PreparedStatement ps = null;
        String sql = "update tb_user set password = ? where email = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, HashTool.toHashCode(user.getPassword()));
            ps.setString(2, user.getEmail());
            int count = ps.executeUpdate();
            if (count > 0) {
                JOptionPane.showMessageDialog(null, "更改密码成功！", "成功", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "更改密码失败！", "错误", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "数据库操作失败！请检查数据库是否正常！", "错误", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    /* 修改改密码逻辑%end========================================================================================== */
}
