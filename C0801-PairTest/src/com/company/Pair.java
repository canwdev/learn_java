package com.company;

/**
 * 类型变量使用大写形式，且比较短，这是很常见的。在 Java 库中，
 * 使用变量 E 表示集合的元素类型，K 和 V 分别表示表的关键字与值的类型。
 * T (需要时还可以用临近的字母 U 和 S) 表示“任意类型”。
 * @param <T>
 */
class Pair<T> {
    private T first;
    private T second;

    public Pair() {
        this.first = null;
        this.second = null;
    }

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }
}
