package top.playereg.sys.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashTool {
//    test
    public static void main(String[] args) {
        String testString = "Hello, World!";
        getHashCode(testString);
    }
    public static void getHashCode(String inputStr) {
        String originalString = inputStr;

        try {
            // 创建MessageDigest实例（支持算法：SHA-256/SHA-512/MD5等）
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // 添加要哈希的字节数据
            md.update(originalString.getBytes());

            // 获取哈希字节数组
            byte[] hashBytes = md.digest();

            // 将哈希字节数组转换为十六进制字符串
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            System.out.println("原始字符串: " + originalString);
            System.out.println("SHA-256哈希值: " + hexString.toString());

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
