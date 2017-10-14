package com.company.util;

public class Util {
    public static final boolean SHOW_FULL_NAME = false;

    /**
     * 输出i个tab，每个tab4个空格
     *
     * @param i
     */
    public static void printTabs(int i) {
        for (int j = 0; j < i; j++) {
            System.out.print("    ");
        }
    }

    /**
     * 获取“.”最后的名称
     *
     * @param paraName 例 java.lang.Double
     * @return 例 Double
     */
    public static String classLastName(String paraName) {

        if (!SHOW_FULL_NAME && paraName.contains(".")) {
            // 如果是数组型参数（参数数量可变的方法）
            if (paraName.contains(";")) {
                String temp = paraName.substring(paraName.lastIndexOf(".") + 1);
                // return temp.substring(0,temp.length()-1);
                return temp.replace(";", "...");
            } else {
                return paraName.substring(paraName.lastIndexOf(".") + 1);
            }
        } else {
            return paraName;
        }
    }

    @Override
    public String toString() {
        return getClass() + "@" + Integer.toHexString(hashCode());
    }
}
