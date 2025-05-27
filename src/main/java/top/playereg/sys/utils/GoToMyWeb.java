package top.playereg.sys.utils;

import javax.swing.*;
import java.awt.*;

import static top.playereg.sys.utils.DiyColors.skyblue;

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
        SetFrameTool.setTopImgBtnStyle(jButton, btnColor, skyblue,
            20, x, y, width, height, Panel);
        jButton.addActionListener(e -> {
            try {
                Desktop.getDesktop().browse(java.net.URI.create(webUrl));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }
}
