package com.company;

import java.time.LocalDate;

public class Employee {
    private String name;
    private double salary;
    private LocalDate hireDay;
    public static final int DEFAULT_RISE_SALARY_BY_PERCENT = 5;
    // 静态可变变量
    private static int nextId = 1;
    private int id;

    public void setId() {
        this.id = nextId;
        nextId++;
    }

    public int getId() {
        return id;
    }

    public static int getNextId() {

        return nextId;
    }

    public Employee(String name, double salary, LocalDate hireDay) {
        this.name = name;
        this.salary = salary;
        this.hireDay = hireDay;
    }

    // 典型的访问器方法
    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    // 按百分率加薪（更改器）
    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    public boolean equals(Employee other) {
        return name.equals(other.name);
    }

    // 可以在不同的类中存放 main，通常用于单元测试
    public static void main(String[] args) {
        Employee e = new Employee("Harry", 50000, LocalDate.of(2017, 12, 15));
        String output = String.format("Name: %s,\tSalary: %.2f,\tHire Day: %s"
                , e.getName(), e.getSalary(), e.getHireDay());
        System.out.println(output);
    }
}
