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
    public static boolean login(String email, String password) {
        Connection conn = DbUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String currentPassword = "";
        int tempIsDel = -1;
        int tempIsRoot = -1;
        String sql;
        try {
            sql = "SELECT * FROM tb_user WHERE email = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            tempIsDel = -1;
            tempIsRoot = -1; // 新增重置初始值
            while (rs.next()) {
                int currentIsDel = rs.getInt("is_del");
                if (currentIsDel == 0) {
                    tempIsDel = 0;
                    tempIsRoot = rs.getInt("is_root"); // 新增获取is_root值
                    currentPassword = rs.getString("password");
                    break;
                } else {
                    continue;
                }
            }
            if (currentPassword.equals(HashTool.toHashCode(password)) && tempIsDel == 0) { // 密码正确
                UserSaveTool.setCurerntLoginUserName(rs.getString("username")); // 保存用户名
                UserSaveTool.setCurerntLoginUserPassword(currentPassword); // 密码保存
                UserSaveTool.setCurerntLoginUserEmail(email); // 邮箱保存
                UserSaveTool.setCurerntLoginUserIsRoot(String.valueOf(tempIsRoot)); // 保存is_root
                UserSaveTool.setCurerntLoginUserIsDel(String.valueOf(tempIsDel)); // 保存is_del
                return true;
            } else {
                if (tempIsDel != 0) {
                    JOptionPane.showMessageDialog(null, "您还没加入我们？快去点“注册”按钮！ ヽ( ^ω^ ゞ )", "快加入我们！！！", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "嗯。。。密码好像有问题。 ∑(✘Д✘๑ )", "不对劲！", JOptionPane.ERROR_MESSAGE);
                }
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "数据库操作失败！请检查数据库是否正常！", "错误", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(e);
        } finally {
            // 添加资源关闭逻辑
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
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
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "数据库操作失败！请检查数据库是否正常！", "错误", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
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
            ps.setString(1, user.getPassword());
            ps.setString(2, user.getEmail());
            int count = ps.executeUpdate();
            if (count > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "数据库操作失败！请检查数据库是否正常！", "错误", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    /* 修改改密码逻辑%end========================================================================================== */
}
