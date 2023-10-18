package com.huaizhu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class 暴力递归 {

    /**
     * 1.移动圆盘问题
     * 打印n层汉诺塔从最左边移动到最右边的全部过程
     */

    public static void func(int N, String from, String to, String other) {
        if (N == 1) {
            System.out.println("Move 1 from " + from + " to" + to);
        } else {
            func(N - 1, from, other, to);
            System.out.println("Move " + N + "from " + from + " to" + to);
            func(N - 1, other, to, from);
        }
    }

    /**
     * 2.打印一个字符串的全部子序列
     */
    public static List<String> func2Test(String s) {
        char[] str = s.toCharArray();
        List<String> ans = new ArrayList<>();
        String path = "";
        func2(str, ans, 0, path);
        return ans;
    }

    //path表示index 前面0-index-1 的决定，无法改变，只能决定index当前要还是不要
    public static void func2(char[] str, List<String> ans, int index, String path) {
        if (index == str.length) {
            ans.add(path);
            return;
        }
        func2(str, ans, index + 1, path);
        func2(str, ans, index + 1, path + String.valueOf(str[index]));
    }


    /**
     * 3.打印一个字符串的全部子序列 要求不要出现重复字面值的子序列
     */
    public static List<String> func3Test(String s) {
        char[] str = s.toCharArray();
        HashSet<String> set = new HashSet<>();
        String path = "";
        func3(str, set, 0, path);
        return new ArrayList<>(set);
    }

    public static void func3(char[] str, HashSet<String> ans, int index, String path) {
        if (index == str.length) {
            ans.add(path);
            return;
        }
        func3(str, ans, index + 1, path);
        func3(str, ans, index + 1, path + String.valueOf(str[index]));
    }


    /**
     * 4.打印一个字符串的全部排列
     */

    public static List<String> func4Test(String s) {
        List<String> ans = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return ans;
        }
        char[] str = s.toCharArray();
        func4(str, 0, ans);
        return ans;
    }

    public static void func4(char[] str, int index, List<String> ans) {
        if (index == str.length) {
            ans.add(String.valueOf(str));
        } else {
            for (int i = index; i < str.length; i++) {
                swap(str, index, i);
                func4(str, index + 1, ans);
                //还原原始数据
                swap(str, index, i);
            }
        }
    }

    public static void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }


    /**
     * 5.打印一个字符串的全部排列，要求不要出现重复的排列
     */

    public static void func5(char[] str, int index, List<String> ans) {
        if (index == str.length) {
            ans.add(String.valueOf(str));
        } else {
            boolean[] visited = new boolean[256];
            for (int i = index; i < str.length; i++) {
                if (!visited[str[i]]) {
                    visited[str[i]] = true;
                    swap(str, index, i);
                    func5(str, index + 1, ans);
                    //还原原始数据
                    swap(str, index, i);
                }

            }
        }
    }

    /**
     * 6.给你一个栈，请你逆序这个栈，不能申请额外的数据结构，只能使用递归函数
     */
    public static void r(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        //步骤1: i=3 r=void 将3压入栈
        //步骤2: i=2 r=void 将2压入栈
        //步骤3: i=1 r=void 将1压入栈
        int i = f(stack);
        r(stack);
        stack.push(i);
    }

    //返回栈中最后一名元素
    //(栈顶)1->2->3
    public static int f(Stack<Integer> stack){
        //f1）：1  步骤1
        //f2): 2  步骤3
        //f3): 3  步骤5
        Integer result = stack.pop();
        //f3): 返回 步骤6
        if(stack.isEmpty()){
            return result;
        }
        //f1）last = f2  步骤1
        //f2) last = f3  步骤4
        //f2) last = 3  步骤7
        //f1) last = 3  步骤9
        int last = f(stack);
        //f2) 2 压入栈 步骤8
        //f1) 1 压入栈 步骤10
        stack.push(result);
        return last;
    }
}
