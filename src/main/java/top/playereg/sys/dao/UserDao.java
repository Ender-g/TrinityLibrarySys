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
import top.playereg.sys.utils.GetHashCodeTool;
import top.playereg.sys.utils.UserSaveTool;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    /* 登录逻辑%start========================================================================================== */
    public static boolean login(String email, String password) {
        Connection conn = DbUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String currentPassword = "";
        int tempIsDel = -1;
        int tempIsRoot = -1;
        try {
            ps = conn.prepareStatement("SELECT * FROM tb_user WHERE email = ?");
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
            if (currentPassword.equals(GetHashCodeTool.toHashCode(password)) && tempIsDel == 0) { // 密码正确
                UserSaveTool.setCurerntLoginUserId(rs.getInt("id"));
                UserSaveTool.setCurerntLoginUserName(rs.getString("username")); // 保存用户名
                UserSaveTool.setCurerntLoginUserPassword(currentPassword); // 密码保存
                UserSaveTool.setCurerntLoginUserEmail(email); // 邮箱保存
                UserSaveTool.setCurerntLoginUserIsRoot(String.valueOf(rs.getInt("is_root"))); // 保存is_root
                UserSaveTool.setCurerntLoginUserIsDel(String.valueOf(rs.getInt("is_del"))); // 保存is_del
                UserSaveTool.setCurerntLoginUserBookBorrowID((int) rs.getLong("bookBorrowID"));
                UserSaveTool.setCurerntLoginUserBookBorrowTime(rs.getLong("bookBorrowTime")); // 借阅时间保存
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
        try {
            ps = conn.prepareStatement("SELECT * FROM tb_user WHERE email = ? and is_del = 0");
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
                ps = conn.prepareStatement("insert into tb_user (username, password, email, is_root, is_del) values (?, ?, ?, ?, ?)");
                 ps.setString(1, user.getUsername());
                 ps.setString(2, GetHashCodeTool.toHashCode(user.getPassword()));
                 ps.setString(3, user.getEmail());
                 ps.setString(4, user.getIs_root());
                 ps.setString(5, user.getIs_del());
                int rows = ps.executeUpdate();
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
        try {
            ps = conn.prepareStatement("SELECT * FROM tb_user WHERE email = ? and is_del = 0");
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
                ps = conn.prepareStatement("UPDATE tb_user SET password = ? WHERE email = ? and is_del = 0");
                ps.setString(1, GetHashCodeTool.toHashCode(password));
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
    public static boolean deleteUserByEmail(String email) {
        Connection conn = DbUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int tempIsDel = -1;
        try {
            ps = conn.prepareStatement("SELECT * FROM tb_user WHERE email = ? and is_del = 0");
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
                ps = conn.prepareStatement("UPDATE tb_user SET is_del = 1 WHERE email = ? and is_del = 0");
                ps.setString(1, email);
                int rows = ps.executeUpdate();
                if (rows > 0) {
                    JOptionPane.showMessageDialog(null, "用户删除成功！", "成功", JOptionPane.INFORMATION_MESSAGE);
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "用户删除失败！", "错误", JOptionPane.ERROR_MESSAGE);
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
        }
    }

    public static boolean deleteUserById(String id) {
        Connection conn = DbUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int tempIsDel = -1;
        try {
            ps = conn.prepareStatement("SELECT * FROM tb_user WHERE id = ? and is_del = 0");
            ps.setString(1, id);
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
                ps = conn.prepareStatement("UPDATE tb_user SET is_del = 1 WHERE id = ? and is_del = 0");
                ps.setString(1, id);
                int rows = ps.executeUpdate();
                if (rows > 0) {
                    JOptionPane.showMessageDialog(null, "用户删除成功！", "成功", JOptionPane.INFORMATION_MESSAGE);
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "用户删除失败！", "错误", JOptionPane.ERROR_MESSAGE);
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
        }
    }
    /* 删除用户逻辑%end========================================================================================== */

    /* 赋权逻辑%start========================================================================================== */
    public static boolean updateUserRole(String id, int role) {
        Connection conn = DbUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 先检查用户是否存在
            ps = conn.prepareStatement("SELECT * FROM tb_user WHERE id = ? and is_del = 0");
            ps.setString(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                // 更新角色权限
                ps = conn.prepareStatement("UPDATE tb_user SET is_root = ? WHERE id = ? AND is_del = 0");
                ps.setInt(1, role);
                ps.setString(2, id); // 此时两个参数都存在，不会报错


                int rows = ps.executeUpdate();
                if (rows > 0) {
                    JOptionPane.showMessageDialog(null, "赋予权限成功！", "成功", JOptionPane.INFORMATION_MESSAGE);
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "赋予权限失败！", "错误", JOptionPane.ERROR_MESSAGE);
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
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    /* 赋权逻辑%end========================================================================================== */

    /* 更新用户借阅信息%start======================================================================================== */
    public static void updateUserBookBorrowInfo(int curerntLoginUserId, int bookId, long time) {
        Connection conn = DbUtils.getConnection();
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("UPDATE tb_user SET bookBorrowID = ?, bookBorrowTime = ? WHERE id = ? and is_del = 0");
            ps.setInt(1, bookId);              // 设置借阅图书ID
            ps.setLong(2, time);               // 设置借阅时间戳
            ps.setInt(3, curerntLoginUserId);  // 设置用户ID

            int rows = ps.executeUpdate();     // 执行更新
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "数据库操作失败！请检查数据库是否正常！", "错误", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /* 更新用户借阅信息%end======================================================================================== */

    /* 获取所有用户逻辑%start========================================================================================== */
    public static List<User> getAllUsers() {
        Connection conn = DbUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<User> userList = new ArrayList<>();

        try {
            ps = conn.prepareStatement("SELECT * FROM tb_user WHERE is_del = 0");
            rs = ps.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setIs_root(rs.getString("is_root"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "数据库操作失败！请检查数据库是否正常！", "错误", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return userList;
    }
    /* 获取所有用户逻辑%end========================================================================================== */
}
