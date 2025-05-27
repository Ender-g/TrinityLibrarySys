package top.playereg.sys;

import top.playereg.sys.pages.safeFrame.LoginFrame;
import top.playereg.sys.utils.UserSaveTool;

public class Main {
    public static void main(String[] args) {
        UserSaveTool.clear(); // 初始化用户信息
        new LoginFrame(); // 启动登录界面
    }
}