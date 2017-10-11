package com.company;

public class Student extends Person {
    private String major;

    public Student(String name, String major) {
        // 实例化抽象超类的name
        super(name);
        this.major = major;
    }

    // 实现抽象方法（必须）
    @Override
    public String getDescription() {
        return "a student majoring in " + major;
    }
}
