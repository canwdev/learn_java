package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class TalkingClock3 {

    public void start(int interval, boolean beepOn) {

        /**
         * 匿名内部类
         */
        /*Timer timer = new Timer(interval, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("At the tone, the time is "+ new Date());
                if (beepOn) Toolkit.getDefaultToolkit().beep();
            }
        });*/
        // lambda
        Timer timer = new Timer(interval, e -> {
            System.out.println("At the tone, the time is " + new Date());
            if (beepOn) Toolkit.getDefaultToolkit().beep();
        });
        timer.start();
    }

}
