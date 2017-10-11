package com.company;

import java.time.LocalDate;

// 继承了超类Employee
public class Manager extends Employee {
    // 经理有奖金
    private double bonus;

    public Manager(String name, double salary, LocalDate hireDay) {
        // 调用超类构造器
        super(name, salary, hireDay);
        bonus = 0;
    }

    public double getSalary() {
        // 调用超类方法获取private salary
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
