package com.company;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Manager boss = new Manager("Carl Craker", 80000
                , LocalDate.of(1987,12,15));
        boss.setBonus(5000);

        System.out.println("Name: "+boss.getName()+", Salary: "+boss.getSalary()+"\n");

        Employee[] staff = new Employee[3];
        staff[0] = boss;
        staff[1] = new Employee("Harry Hacker", 50000
                , LocalDate.of(1989,10,1));
        staff[2] = new Employee("Tommy Tester", 40000
                , LocalDate.of(1990,3,15));

        /**
         * 一个对象变量（例如, 变量e)
         * 可以指示多种实际类型的现象被称为多态（polymorphism)。
         * 在运行时能够自动地选择调用哪个方法的现象称为动态绑定（dynamic binding)。
         */
        for (Employee e : staff) {
            System.out.println("Name: "+e.getName()+", Salary: "+e.getSalary());
        }
    }
}
