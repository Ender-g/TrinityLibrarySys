/*
 *
 * @Author: Playereg
 * @description: 用户数据访问层
 * @version: 1.0
 *
 * */

package top.playereg.sys.dao;

import top.playereg.sys.entity.User;
import top.playereg.sys.utils.DbUtils;
import top.playereg.sys.utils.HashTool;
import top.playereg.sys.utils.UserSaveTool;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    /* 登录逻辑%start========================================================================================== */
    public static boolean login(String email, String password) {
        Connection conn = DbUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String currentPassword = "";
        int tempIsDel = -1;
        int tempIsRoot = -1;
        String sql = "SELECT * FROM tb_user WHERE email = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            tempIsDel = -1;
            tempIsRoot = -1;
            while (rs.next()) {
                int currentIsDel = rs.getInt("is_del");
                if (currentIsDel == 0) {
                    tempIsDel = 0;
                    tempIsRoot = rs.getInt("is_root");
                    currentPassword = rs.getString("password");
                    break;
                } else {
                    continue;
                }
            }
            if (currentPassword.equals(HashTool.toHashCode(password)) && tempIsDel == 0) { // 密码正确
                UserSaveTool.setCurerntLoginUserId(rs.getString("id"));
                UserSaveTool.setCurerntLoginUserName(rs.getString("username")); // 保存用户名
                UserSaveTool.setCurerntLoginUserPassword(currentPassword); // 密码保存
                UserSaveTool.setCurerntLoginUserEmail(email); // 邮箱保存
                UserSaveTool.setCurerntLoginUserIsRoot(String.valueOf(rs.getInt("is_root"))); // 保存is_root
                UserSaveTool.setCurerntLoginUserIsDel(String.valueOf(rs.getInt("is_del"))); // 保存is_del
                UserSaveTool.setCurerntLoginUserBookBorrowID(String.valueOf(rs.getInt("bookBorrowID"))); // 借阅数保存
                UserSaveTool.setCurerntLoginUserBookBorrowTime(rs.getString("bookBorrowTime")); // 借阅时间保存
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
        ResultSet rs = null;
        int tempIsDel = -1;
        String sql = "SELECT * FROM tb_user WHERE email = ? and is_del = 0";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            rs = ps.executeQuery();
            tempIsDel = -1;
            while (rs.next()) {
                int currentIsDel = rs.getInt("is_del");
                if (currentIsDel == 0) {
                    tempIsDel = 0;
                    break;
                } else {
                    continue;
                }
            }
            if (tempIsDel == 0) {
                JOptionPane.showMessageDialog(null, "不准开小号！！！(╯•̀ὤ•́)╯", "错误", JOptionPane.ERROR_MESSAGE);
                return false;
            } else {
                sql = "insert into tb_user (username, password, email, is_root, is_del) values (?, ?, ?, ?, ?)"; // 插入用户数据
                ps = conn.prepareStatement(sql);
                ps.setString(1, user.getUsername());
                ps.setString(2, HashTool.toHashCode(user.getPassword()));
                ps.setString(3, user.getEmail());
                ps.setString(4, "0");
                ps.setString(5, "0");
                int rows = ps.executeUpdate();
                System.out.println("rows = " + rows);
                if (rows > 0) {
                    JOptionPane.showMessageDialog(null, "注册成功！欢迎加入我们！ ( ﾟ∀ﾟ)ﾉ", "恭喜", JOptionPane.INFORMATION_MESSAGE);
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "注册失败！( ﾟ∀ﾟ)ﾉ", "错误", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "数据库操作失败！请检查数据库是否正常！", "错误", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    /* 注册逻辑%end========================================================================================== */

    /* 修改改密码逻辑%start========================================================================================== */
    public static boolean updatePassword(String email, String password) {
        Connection conn = DbUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int tempIsDel = -1;
        String sql = "SELECT * FROM tb_user WHERE email = ? and is_del = 0";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery(); //  查询用户数据
            tempIsDel = -1;
            while (rs.next()) {
                int currentIsDel = rs.getInt("is_del");
                if (currentIsDel == 0) {
                    tempIsDel = 0;
                    break;
                } else {
                    continue;
                }
            }
            if (tempIsDel == 0) {
                sql = "UPDATE tb_user SET password = ? WHERE email = ? and is_del = 0";
                ps = conn.prepareStatement(sql);
                ps.setString(1, HashTool.toHashCode(password));
                ps.setString(2, email);
                int rows = ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "密码修改成功！请记住新密码哦~ (＾∀＾●)ノ", "成功", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "用户不存在！请检查邮箱是否正确！", "错误", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "数据库操作失败！请检查数据库是否正常！", "错误", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    /* 修改改密码逻辑%end========================================================================================== */

    /* 删除用户逻辑%start========================================================================================== */
    public static boolean deleteUser(String email) {
        Connection conn = DbUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int tempIsDel = -1;
        String sql = "SELECT * FROM tb_user WHERE email = ? and is_del = 0";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            tempIsDel = -1;
            while (rs.next()) {
                int currentIsDel = rs.getInt("is_del");
                if (currentIsDel == 0) {
                    tempIsDel = 0;
                    break;
                } else {
                    continue;
                }
            }
            if (tempIsDel == 0) {
                sql = "UPDATE tb_user SET is_del = 1 WHERE email = ? and is_del = 0";
                ps = conn.prepareStatement(sql);
                ps.setString(1, email);
                int rows = ps.executeUpdate();
                if (rows > 0) {
                    JOptionPane.showMessageDialog(null, "用户删除成功！", "成功", JOptionPane.INFORMATION_MESSAGE);
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "用户删除失败！请检查邮箱是否正确！", "错误", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            } else {
                JOptionPane.showMessageDialog(null, "用户不存在！请检查邮箱是否正确！", "错误", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "数据库操作失败！请检查数据库是否正常！", "错误", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    /* 删除用户逻辑%end========================================================================================== */
}
