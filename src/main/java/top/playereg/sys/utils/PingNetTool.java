/*
 *
 * @author: playereg
 * @description: 网络连接测试
 * @version: 1.0
 *
 * */

package top.playereg.sys.utils;

import java.net.InetAddress;

public class PingNetTool {
    public static boolean ping(String ip) {
        try {
            InetAddress address = InetAddress.getByName(ip);
            return address.isReachable(2000);
        } catch (Exception e) {
             e.printStackTrace();
            return false;
        }
    }
}
