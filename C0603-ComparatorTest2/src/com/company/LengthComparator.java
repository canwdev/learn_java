package com.company;

import java.util.Comparator;

/**
 * 实现比较器接口，字符串按照长度比较
 */
public class LengthComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }
}
