package top.playereg.sys.utils;

public class UserSaveTool {
    private static String curerntLoginUserId = null;
    private static String curerntLoginUserName = null; // 当前登录用户名
    private static String curerntLoginUserPassword = null; // 当前登录用户密码
    private static String curerntLoginUserEmail = null; // 当前登录用户邮箱
    private static String curerntLoginUserIsRoot = null; // 当前登录用户是否是管理员
    private static String curerntLoginUserIsDel = null; // 当前登录用户是否被删除
    private static String curerntLoginUserBookBorrowID = null; // 当前登录用户借阅
    private static String curerntLoginUserBookBorrowTime = null;
    //  清空用户信息
    public static void clear() {
        curerntLoginUserId = null;
        curerntLoginUserName = null;
        curerntLoginUserPassword = null;
        curerntLoginUserEmail = null;
        curerntLoginUserIsRoot = null;
        curerntLoginUserIsDel = null;
        curerntLoginUserBookBorrowID = null;
        curerntLoginUserBookBorrowTime = null;
        System.out.println("用户信息已清空！");
    }

    public static String getCurerntLoginUserId() {
        return curerntLoginUserId;
    }

    public static void setCurerntLoginUserId(String curerntLoginUserId) {
        UserSaveTool.curerntLoginUserId = curerntLoginUserId;
        System.out.println("当前登录用户ID：" + curerntLoginUserId);
    }

    // 获取当前登录用户名
    public static String getCurerntLoginUserName() {
        return curerntLoginUserName;
    }

    // 设置当前登录用户名
    public static void setCurerntLoginUserName(String curerntLoginUserName) {
        UserSaveTool.curerntLoginUserName = curerntLoginUserName;
        System.out.println("当前登录用户名：" + curerntLoginUserName);
    }

    // 获取当前登录用户密码
    public static String getCurerntLoginUserPassword() {
        return curerntLoginUserPassword;
    }

    // 设置当前登录用户密码
    public static void setCurerntLoginUserPassword(String curerntLoginUserPassword) {
        UserSaveTool.curerntLoginUserPassword = curerntLoginUserPassword;
        System.out.println("当前登录用户密码：" + curerntLoginUserPassword);
    }

    // 获取当前登录用户邮箱
    public static String getCurerntLoginUserEmail() {
        return curerntLoginUserEmail;
    }

    // 设置当前登录用户邮箱
    public static void setCurerntLoginUserEmail(String curerntLoginUserEmail) {
        UserSaveTool.curerntLoginUserEmail = curerntLoginUserEmail;
        System.out.println("当前登录用户邮箱：" + curerntLoginUserEmail);
    }

    // 获取当前登录用户是否是管理员
    public static String getCurerntLoginUserIsRoot() {
        return curerntLoginUserIsRoot;
    }

    // 设置当前登录用户是否是管理员
    public static void setCurerntLoginUserIsRoot(String curerntLoginUserIsRoot) {
        UserSaveTool.curerntLoginUserIsRoot = curerntLoginUserIsRoot;
        System.out.println("当前登录用户是否是管理员：" + curerntLoginUserIsRoot);
    }

    // 获取当前登录用户是否被删除
    public static String getCurerntLoginUserIsDel() {
        return curerntLoginUserIsDel;
    }

    // 设置当前登录用户是否被删除
    public static void setCurerntLoginUserIsDel(String curerntLoginUserIsDel) {
        UserSaveTool.curerntLoginUserIsDel = curerntLoginUserIsDel;
        System.out.println("当前登录用户是否被删除：" + curerntLoginUserIsDel);
    }

    public static String getCurerntLoginUserBookBorrowID() {
        return curerntLoginUserBookBorrowID;
    }

    public static void setCurerntLoginUserBookBorrowID(String curerntLoginUserBookBorrowID) {
        UserSaveTool.curerntLoginUserBookBorrowID = curerntLoginUserBookBorrowID;
        System.out.println("当前登录用户借阅：" + curerntLoginUserBookBorrowID);
    }

    public static String getCurerntLoginUserBookBorrowTime() {
        return curerntLoginUserBookBorrowTime;
    }

    public static void setCurerntLoginUserBookBorrowTime(String curerntLoginUserBookBorrowTime) {
        UserSaveTool.curerntLoginUserBookBorrowTime = curerntLoginUserBookBorrowTime;
        System.out.println("当前登录用户借阅时间：" + curerntLoginUserBookBorrowTime);
    }
}
