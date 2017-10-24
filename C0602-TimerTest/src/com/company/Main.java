package com.company;

import java.awt.event.ActionListener;
// 解决冲突with java.util.Timer
import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        ActionListener listener = new TimerPrinter();

        // 构造一个调用listener的timer
        // import javax.swing.*;
        Timer t = new Timer(1000, listener);
        t.start();

        // 显示一个对话框用于卡住主线程防止退出
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}
