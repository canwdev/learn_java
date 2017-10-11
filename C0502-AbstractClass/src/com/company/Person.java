package com.company;

/**
 * 这是一个抽象类
 */
public abstract class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    // 抽象方法
    public abstract String getDescription();

    // 也可以存在非抽象方法
    public String getName() {
        return name;
    }
}
