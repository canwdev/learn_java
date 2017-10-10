package com.company;

import java.text.NumberFormat;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Employee[] staff = new Employee[4];
        staff[0] = new Employee("Stan Marsh", 75000, LocalDate.of(1997, 12, 15));
        staff[1] = new Employee("Kyle Broflovski", 60000, LocalDate.of(1997, 10, 2));
        staff[2] = new Employee("Eric Theodore Cartman", 85000, LocalDate.of(1997, 3, 1));
        staff[3] = new Employee("Kenny McCormick", 40000, LocalDate.of(1997, 4, 5));

        // 设置id并统一加薪 5%
        for (Employee e : staff) {
            e.setId();
            e.raiseSalary(Employee.DEFAULT_RISE_SALARY_BY_PERCENT);
        }

        for (Employee e : staff) {
            String output = String.format(e.getId() + ". Name: %s,\tSalary: %.2f,\tHire Day: %s"
                    , e.getName(), e.getSalary(), e.getHireDay());
            System.out.println(output);
        }
        System.out.print(staff[3].equals(staff[3]));
        System.out.println(Employee.getNextId());

        final StringBuilder test;
        test = new StringBuilder();
        test.append("final 关键字只是表示存储在 test 变量中的对象引用" +
                "不会再指示其他 StringBuilder 对象 。");

        double x = 0.1;
        System.out.println(NumberFormat.getCurrencyInstance().format(x));
        System.out.println(NumberFormat.getPercentInstance().format(x));


    }
}
