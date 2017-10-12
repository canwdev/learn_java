package com.company;

import java.time.LocalDate;
import java.util.Objects;

public class Employee {
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

    // 按百分率加薪
    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    /**
     * 判断两个类是否相等
     *
     * @param obj 另一个类
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        // 快速确认对象是否一致
        if (this == obj) return true;

        // 当obj为空时，必须返回false
        if (null == obj) return false;

        // 如果class不匹配，则不可能相等
        if (getClass() != obj.getClass()) return false;

        // 现已知obj是一个不为null的Employee对象
        // 强制类型转换
        Employee other = (Employee) obj;

        return Objects.equals(name, other.name)
                && salary == other.salary
                && Objects.equals(hireDay, other.hireDay);
    }

    /**
     * 计算该类的散列值
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, salary, hireDay);
    }

    @Override
    public String toString() {
        return getClass().getName()
                + "[name=" + name
                + ",salary=" + salary
                + ",hireDay=" + hireDay
                + "]@" + Integer.toHexString(hashCode());
    }
}
