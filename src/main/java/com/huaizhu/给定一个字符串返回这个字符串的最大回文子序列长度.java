package com.huaizhu;

/**
 * str = "a12b3c43def2ghi1lpm"
 * 最大的回文子序列为1234321  或者 123c321
 * 返回长度7
 */
public class 给定一个字符串返回这个字符串的最大回文子序列长度 {

    public static int test(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
            return 0;
        }
        char[] str1 = s1.toCharArray();
        char[] str2 = s1.toCharArray();
        return process(str1, str2, str1.length - 1, str2.length - 1);
    }


    //求相同最长子序列
    //如果求最大回文的化，可以采用 s1 = str s2=str的逆序
    public static int process(char[] str1, char[] str2, int i, int j) {
        if (i == 0 && j == 0) {
            return str1[i] == str2[j] ? 1 : 0;
        } else if (i == 0) {
            if (str1[i] == str2[j]) {
                return 1;
            } else {
                return process(str1, str2, i, j - 1);
            }
        } else if (j == 0) {
            if (str1[i] == str2[j]) {
                return 1;
            } else {
                return process(str1, str2, i - 1, j);
            }
        } else {
            int p1 = process(str1, str2, i - 1, j);
            int p2 = process(str1, str2, i, j - 1);
            int p3 = str1[i] == str2[j] ? 1 + process(str1, str2, i - 1, j - 1) : 0;
            return Math.max(p1, Math.max(p2, p3));
        }
    }




    //最大回文方式2
    public static int test2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] str = s.toCharArray();
        return f(str, 0, s.length() - 1);
    }

    public static int f(char[] str, int L, int R) {
        if (L == R) {
            return 1;
        }
        if (L == R - 1) {
            return str[L] == str[R] ? 2 : 1;
        }

        int p1 = f(str, L + 1, R - 1);
        int p2 = f(str, L + 1, R);
        int p3 = f(str, L, R - 1);
        int p4 = str[L] == str[R] ? 2 + f(str, L + 1, R - 1) : 0;
        return Math.max(Math.max(p1, p2), Math.max(p3, p4));
    }


}
