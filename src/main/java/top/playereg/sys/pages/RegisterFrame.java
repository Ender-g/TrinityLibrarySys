/*
 *
 * @author: playereg
 * @description: 注册页面
 * @version: 1.0
 *
 * */

package top.playereg.sys.pages;

import top.playereg.sys.utils.SetFrameTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static top.playereg.sys.utils.DiyColors.*;


public class RegisterFrame extends javax.swing.JFrame {
    /* 声明组件%start================================================================================== */
    private JLabel registerPanel;
    private JLabel titleLabel;
    private JLabel nameLabel, emailLabel, newPasswordLabel, confirmPasswordLabel, emailCodeLabel; // 用户名、邮箱、密码、确认密码、验证码（文本）
    private JTextField nameField, emailField, emailCodeField; // 用户名、邮箱、验证码（文本框）
    private JPasswordField newPasswordField, confirmPasswordField; //  密码、确认密码（密码框）
    private JButton sendEmailCodeBtn, registerBtn, backBtn; // 发送验证码、注册、返回（按钮）
    private JLabel backgroundImg; // 背景图片
    /* 声明组件%end================================================================================== */

    public RegisterFrame() {
        /* 设置窗体%start============================================================================ */
        SetFrameTool.setFrame(
                "崔尼蒂图书馆-注册",
                960, 540,
                "src/main/java/top/playereg/sys/img/book.png",
                this
        );
        /* 设置窗体%end============================================================================ */

        /* 设置登录面板%start======================================================================== */
        registerPanel = new JLabel();
        registerPanel.setLayout(null);
        this.add(registerPanel);
        /* 设置登录面板%end======================================================================== */

        /* 创建组件%start=========================================================================== */
        // todo 创建组件
        /* 创建组件%end=========================================================================== */

        /* 设置登录背景%start====================================================================== */
        SetFrameTool.setPanleBackgroundImg(
                "src/main/java/top/playereg/sys/img/background_2.png",
                0, 0, 960, 540
                , registerPanel
        );
        /* 设置登录背景%end====================================================================== */
        setVisible(true); // 显示窗体
        /* 监听%start=========================================================================== */
        //  todo 监听
        /* 监听%end=========================================================================== */
    }

    public static void main(String[] args) {
        new RegisterFrame().setVisible(true);
    }
}
