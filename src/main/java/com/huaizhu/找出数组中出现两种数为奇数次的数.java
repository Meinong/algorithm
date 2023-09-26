package com.huaizhu;

public class 找出数组中出现两种数为奇数次的数 {

    public static void main(String[] args) {

    }


    public static void find(int[] arr) {

        int ans = 0;

        //获取到两个奇数 ans  = a ^ b
        for (int i = 0; i < arr.length; i++) {
            ans ^= arr[i];
        }

        //获取到最右边为1的数 000000010000
        int rightOne = ans & (-ans); //最右边为1 时 表示 a 和 b 在此位置上 一定不相同 a^b 的结果在此位置上一定是1

        int eof = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & rightOne) != 0) {
                eof ^= arr[i];
            }
        }
        System.out.println(eof + "," + (ans ^ eof));


    }


}
