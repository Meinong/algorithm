package com.huaizhu;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 题目1:
 * 给定一个由字符串组成的数组strs，
 * 必须把所有的字符串拼接起来，
 * 返回所有可能的拼接结果中，字典序最小的结果
 */
public class 贪心算法1 {

    public static class MyComparator implements Comparator<String> {

        @Override
        public int compare(String a, String b) {
            return (a + b).compareTo(b + a);
        }
    }

    public static String lowestString(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        Arrays.sort(strs, new MyComparator());
        String ans = "";
        for (String str : strs) {
            ans += str;
        }
        return ans;
    }
}
