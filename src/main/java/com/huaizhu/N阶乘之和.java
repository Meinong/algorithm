package com.huaizhu;

/**
 * 求：1!+2!+3!+4!+....+N!
 */
public class N阶乘之和 {

    public static void main(String[] args) {
        int n = 10;
        print(n);
    }


    /**
     * 1! = 1*1
     * 2!= 1!*2
     * 3! = 2!*3
     * N! = (N-1)!*N
     * @param n
     */
    public static void print(int n){
        long ans = 0;
        long cur = 1;
        for (int i = 1;i<=n;i++){
            cur = cur * i;
            ans += cur;
        }
        System.out.println(ans);
    }


}
