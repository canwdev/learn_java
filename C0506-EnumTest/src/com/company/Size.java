package com.company;

/**
 * 枚举类
 */
public enum Size{
    // 枚举常量，从0开始计数
    SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");

    // 域
    private String abbr;

    // 构造器
    private Size(String abbr) {
        this.abbr = abbr;
    }

    // 方法
    public String getAbbr() {
        return abbr;
    }
}
