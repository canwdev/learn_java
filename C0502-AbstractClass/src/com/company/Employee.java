package com.company;

import java.time.LocalDate;

public class Employee extends Person{
    private double salary;
    private LocalDate hireDay;

    public Employee(String name, double salary, LocalDate hireDay) {
        super(name);
        this.salary = salary;
        this.hireDay = hireDay;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    // 按百分率加薪
    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    @Override
    public String getDescription() {
        return String.format("an employee with a salary of $%.2f", salary);
    }
}
