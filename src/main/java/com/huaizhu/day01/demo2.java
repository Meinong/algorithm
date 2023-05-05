package com.huaizhu.day01;


/**
 * 给定一个数N 求 1!+2!+....N!
 */
public class demo2 {

    public static void main(String[] args) {
        int n = 10;
        print(n);
    }

    /**
     * 设计思路1
     * 1! = 1
     * +
     * 2! = 1*2
     * +
     * 3!=  1*2*3
     * +
     * ....
     * +
     * N! = 1*2*3*...N
     *
     * 设计思路2
     * 1! = 1
     * 2!= 1!*2
     * 3! = 2!*3
     * ...
     * N! = (N-1)! * N
     *
     *
     * @param n
     */
    private static void print(int n) {
         long result = 0;
         long cur = 1;
         //采用设计方案2
        for (int i = 1; i <=n ; i++) {
            cur = cur * i;
            result +=cur;
        }
        System.out.println(result);
    }

}
