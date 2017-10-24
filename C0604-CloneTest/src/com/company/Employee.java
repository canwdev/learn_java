package com.company;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Employee 20171024
 * implements Cloneable
 * LocalDate -> Date
 */
public class Employee implements Comparable<Employee>, Cloneable {
    private String name;
    private double salary;
    private Date hireDay;

    public Employee(String name, double salary, Date hireDay) {
        this.name = name;
        this.salary = salary;
        this.hireDay = hireDay;
    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        this.hireDay = new Date();
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public Date getHireDay() {
        return hireDay;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    @Override
    public int compareTo(Employee o) {
        return Double.compare(salary, o.salary);
    }

    /**
     * Clone Employee类对象
     */
    public Employee clone() throws CloneNotSupportedException {
        Employee cloned = (Employee) super.clone();

        // clone mutable fields
        // Clone 可变的域，例如Date
        cloned.hireDay = (Date) hireDay.clone();

        return cloned;
    }

    /**
     * 设置雇佣日期代替特定日期
     * @param year
     * @param month
     * @param day
     */
    public void setHireDay(int year, int month, int day) {
        Date newHireDay = new GregorianCalendar(year, month-1, day).getTime();

        // 实例化可变(mutation)域的例子
        hireDay.setTime(newHireDay.getTime());
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
