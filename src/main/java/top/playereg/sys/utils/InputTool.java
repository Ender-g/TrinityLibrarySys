/*
 *
 * @author: playereg
 * @description: 输入限制工具
 * @version: 1.0
 *
 * */

package top.playereg.sys.utils;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputTool {
    /**
     * 为文本框添加数字输入限制监听器
     * @param textField 需要限制的文本框
     */
    public static void jast6NumberInput(@NotNull JTextField textField) {
        textField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                // 验证字符有效性
                if (!((c >= '0') && (c <= '9') ||
                        (c == KeyEvent.VK_BACK_SPACE) ||
                        (c == KeyEvent.VK_DELETE))) {
                    evt.consume();
                }
                // 验证长度限制
                if (textField.getText().length() >= 6 &&
                        !(c == KeyEvent.VK_BACK_SPACE ||
                                c == KeyEvent.VK_DELETE)) {
                    evt.consume();
                }
            }
        });
    }
    public static String nameInput = "^[a-zA-Z0-9_-]{2,16}$";
    public static String emailInput = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
    public static String passwordInput = "^[a-zA-Z0-9_-]{6,16}$";
}