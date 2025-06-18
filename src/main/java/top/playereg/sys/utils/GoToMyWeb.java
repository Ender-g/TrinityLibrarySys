/*
 *
 * @author: playereg
 * @description: 跳转到我的网站
 * @version: 1.0
 *
 * */

package top.playereg.sys.utils;

import javax.swing.*;
import java.awt.*;

import static top.playereg.sys.utils.MoreColors.skyblue;

public class GoToMyWeb extends JFrame{
    public static void goToMyWebBtn(
            String webUrl,
            String imgUrl,
            Color btnColor,
            int x, int y,
            int width, int height,
            JLabel Panel
    ){
        JButton jButton = new JButton(null,  new ImageIcon(imgUrl));
        SetFrameTool.setImgBtnStyle(jButton, btnColor, skyblue,
            20, x, y, width, height, Panel);
        //点击后颜色不变
        jButton.setRolloverEnabled(false);
        jButton.addActionListener(e -> {
            try {
                Desktop.getDesktop().browse(java.net.URI.create(webUrl));
            } catch (Exception ex) {
                System.err.println("Error opening web browser: " + ex.getMessage());
                JOptionPane.showMessageDialog(null, "无法打开浏览器");
                ex.printStackTrace();
            }
        });
    }
}
