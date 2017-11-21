package com.company;

// 泛型测试 1
// 泛型程序设计（Generic programming) 意味着编写的代码可以被很多不同类型的对象所重用
public class PairTest1 {
    public static void main(String[] args) {
        String[] words = {
                "Aaa", "aaa", "Bbb", "bbb", "Ccc"};

        /*"Who You Are Is Not Enough",
          "Golevka",
          "Those Who Tell the Truth Shall Die, Those Who Tell the Truth Shall Live Forever",
          "Enjoy Eternal Bliss"*/

        Pair<String> result = ArrayAlg.minMax(words);
        System.out.println("min: " + result.getFirst() + "\n" + "max: " + result.getSecond());
    }

    public static class ArrayAlg {

        /**
         * 按照字典顺序，比较出最小与最大的单词 (A<a<B<b<C<c...)
         *
         * @param a 字符串数组
         * @return 包含泛型的Pair对象
         */
        public static Pair<String> minMax(String[] a) {
            if (a == null || a.length == 0) return null;
            String min = a[0];
            String max = a[0];
            for (int i = 1; i < a.length; i++) {
                if (min.compareTo(a[i]) > 0) min = a[i];
                if (max.compareTo(a[i]) < 0) max = a[i];
            }
            return new Pair<>(min, max);
        }
    }
}
