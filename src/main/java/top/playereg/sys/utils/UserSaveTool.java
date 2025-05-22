package top.playereg.sys.utils;

public class UserSaveTool {
    private static String curerntLoginUserName = null; // 当前登录用户名
    private static String curerntLoginUserPassword = null; // 当前登录用户密码
    private static String curerntLoginUserEmail = null; // 当前登录用户邮箱
    private static String curerntLoginUserIsRoot = null; // 当前登录用户是否是管理员
    private static String curerntLoginUserIsDel = null; // 当前登录用户是否被删除

    public static String getCurerntLoginUserName() {
        return curerntLoginUserName;
    }

    public static void setCurerntLoginUserName(String curerntLoginUserName) {
        UserSaveTool.curerntLoginUserName = curerntLoginUserName;
    }

    public static String getCurerntLoginUserPassword() {
        return curerntLoginUserPassword;
    }

    public static void setCurerntLoginUserPassword(String curerntLoginUserPassword) {
        UserSaveTool.curerntLoginUserPassword = curerntLoginUserPassword;
    }

    public static String getCurerntLoginUserEmail() {
        return curerntLoginUserEmail;
    }

    public static void setCurerntLoginUserEmail(String curerntLoginUserEmail) {
        UserSaveTool.curerntLoginUserEmail = curerntLoginUserEmail;
    }

    public static String getCurerntLoginUserIsRoot() {
        return curerntLoginUserIsRoot;
    }

    public static void setCurerntLoginUserIsRoot(String curerntLoginUserIsRoot) {
        UserSaveTool.curerntLoginUserIsRoot = curerntLoginUserIsRoot;
    }

    public static String getCurerntLoginUserIsDel() {
        return curerntLoginUserIsDel;
    }

    public static void setCurerntLoginUserIsDel(String curerntLoginUserIsDel) {
        UserSaveTool.curerntLoginUserIsDel = curerntLoginUserIsDel;
    }
}
