package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class TalkingClock {
    private int interval;
    private boolean beepOn;

    public TalkingClock(int interval, boolean beepOn) {
        this.interval = interval;
        this.beepOn = beepOn;
    }

    public void start() {
        ActionListener listener = new TimePrinter();
        Timer timer = new Timer(interval, listener);
        timer.start();
    }

    /**
     * 内部类
     */
    private class TimePrinter implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("At the tone, the time is "+ new Date());
            if (beepOn) Toolkit.getDefaultToolkit().beep();
        }
    }
}
