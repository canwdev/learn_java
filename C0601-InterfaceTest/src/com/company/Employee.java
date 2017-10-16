package com.company;

import java.time.LocalDate;

/**
 * 继承了 Comparable 接口，可以使用Arrays.sort()方法
 */
public class Employee implements Comparable<Employee>{
    private String name;
    private double salary;
    private LocalDate hireDay;

    public Employee(String name, double salary, LocalDate hireDay) {
        this.name = name;
        this.salary = salary;
        this.hireDay = hireDay;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    // 实现接口方法
    @Override
    public int compareTo(Employee o) {
        return Double.compare(salary, o.salary);
    }
}
