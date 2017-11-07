package com.company;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This is my logger class
 */
public class Log {
    public static void d(String TAG, String message) {
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long time = new Date().getTime();
        sb.append(sdf.format(time));
        sb.append(" " + time);
        sb.append(" " + TAG);
        sb.append(" " +message);
        System.out.println(sb);
    }
}
