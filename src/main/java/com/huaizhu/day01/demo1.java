package com.huaizhu.day01;


/**
 * int型(32位) 打印二进制
 *
 * -1:  ～1+1 （+1 取反 + 1）
 *
 */
public class demo1 {

    public static void main(String[] args) {
        int num = -5; //11111111111111111111111111111011
        //+5 取反  + 1
        int num1 = ~5 + 1;//11111111111111111111111111111011
        print(num);
        print(num1);
        System.out.println(num1); // -5
    }

    private static void print(int num) {
        for (int i = 31; i >=0 ; i--) {
            System.out.print((num & (1<<i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }


}
