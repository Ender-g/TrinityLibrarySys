/*
 *
 * @author: playereg
 * @description: 密码哈希工具类
 * @version: 1.0
 *
 * */

package top.playereg.sys.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GetHashCodeTool {
    public static String toHashCode(String inputChars) {
        String originalString = inputChars;
        StringBuilder hexString = null;

        try {
            // 创建MessageDigest实例（支持算法：SHA-256/SHA-512/MD5等）
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // 添加要哈希的字节数据
            md.update(originalString.getBytes());

            // 获取哈希字节数组
            byte[] hashBytes = md.digest();

            // 将哈希字节数组转换为十六进制字符串
            hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hexString.toString();
    }
}
