package com.company;

import javax.swing.*;
import java.util.Arrays;
import java.util.Date;

// Lambda（大写Λ，小写λ，中文音译：兰布达），是第十一个希腊字母。
public class Main {

    public static void main(String[] args) {
        String[] planets = {"Mercury", "Venus", "Earth", "Mars",
                "Jupiter", "Saturn", "Uranus", "Neptune"};
        System.out.println(Arrays.toString(planets));

        System.out.println("Sorted in dictionary order:");
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));

        System.out.println("Sorted by length");
        // 一般写法
        /*Arrays.sort(planets, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });*/

        // lambda 表达式写法
        Arrays.sort(planets, (o1, o2) -> o1.length() - o2.length());
        System.out.println(Arrays.toString(planets));

        /*Timer t = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(new Date());
            }
        });*/
        Timer t = new Timer(1000, e -> {
            System.out.println(new Date());
        });
        t.start();

        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}
