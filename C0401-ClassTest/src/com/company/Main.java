package com.company;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main extends Object {

    public static void main(String[] args) {
        example();
        printCalendar();
        printCalendarMondayFirst();
    }

    private static void printCalendar() {
        // 创建一个以当日期为日期的LocaleDate对象实例
        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();
        int today = date.getDayOfMonth();

        // 设为这个月的第一天
        date = date.minusDays(today - 1);
        // 获取这天是星期几
        DayOfWeek weekday = date.getDayOfWeek();
        int value = weekday.getValue();

        // 输出星期标题与缩进
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
        if (date.getDayOfWeek().getValue() != 7)
            for (int i = 1; i < value; i++) {
                System.out.print("    ");
            }

        while (date.getMonthValue() == month) {
            System.out.printf("%3d", date.getDayOfMonth());
            // 在今天标注一个星号
            if (date.getDayOfMonth() == today) {
                System.out.print("*");
            } else {
                System.out.print(" ");
            }
            // 把日期往后加一天
            date = date.plusDays(1);
            if (date.getDayOfWeek().getValue() == 7) {
                System.out.println();
            }
        }

        if (date.getDayOfWeek().getValue() != 7) {
            System.out.println();
        }
    }

    private static void printCalendarMondayFirst() {
        // 创建一个以当日期为日期的LocaleDate对象实例
        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();
        int today = date.getDayOfMonth();

        // 设为这个月的第一天
        date = date.minusDays(today - 1);
        // 获取这天是星期几
        DayOfWeek weekday = date.getDayOfWeek();
        int value = weekday.getValue();

        // 输出星期标题与缩进
        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        for (int i = 1; i < value; i++) {
            System.out.print("    ");
        }

        while (date.getMonthValue() == month) {
            System.out.printf("%3d", date.getDayOfMonth());
            // 在今天标注一个星号
            if (date.getDayOfMonth() == today) {
                System.out.print("*");
            } else {
                System.out.print(" ");
            }
            // 把日期往后加一天
            date = date.plusDays(1);
            // 如果（星期天）之后是星期一，则输出换行
            if (date.getDayOfWeek().getValue() == 1) {
                System.out.println();
            }
        }
        // 如果这个月的最后一天不是星期一，则输出换行
        if (date.getDayOfWeek().getValue() != 1) {
            System.out.println();
        }
    }

    private static void example() {
        Date today = new Date();
        Date deadline;
        // 引用了today对象
        deadline = today;
        System.out.println(deadline);

        LocalDate localDay = LocalDate.now();
        System.out.println(localDay);
        // 访问器方法
        LocalDate aThousandDaysLater = localDay.plusDays(1000);
        System.out.println("aThousandDaysLater: " + aThousandDaysLater);

        GregorianCalendar someDay = new GregorianCalendar(localDay.getYear(), localDay.getMonthValue(), localDay.getDayOfMonth());
        System.out.println(someDay.get(Calendar.YEAR));
        // 更改器方法
        someDay.add(Calendar.MONTH, 12);
        System.out.println(someDay.get(Calendar.YEAR));
    }


}
