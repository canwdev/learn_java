package com.company;

import java.util.Random;

public class Employee {
    private static int nextId;

    // 静态初始化块
    static {
        System.out.println("静态初始化块");
        Random generator = new Random();
        // 设置一个随机的id在1~9999之间
        nextId = generator.nextInt(10000);
    }

    private String name = "Unknown";   // 实例域初始化
    private double salary;
    private int id;

    // 初始化块
    {
        System.out.println("初始化块");
        id = nextId;
        nextId++;
    }

    // 重载的构造器
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    // 重载的构造器
    public Employee(double salary) {
        // 调用Employee(String name, double salary)构造器
        this("Employee #" + nextId, salary);
    }

    // 默认构造器
    public Employee() {
        /**
         * name已在实例域初始化
         * salary将自动初始化为0
         * id在初始化块中初始
         */
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    public int getId() {
        return id;
    }
}
