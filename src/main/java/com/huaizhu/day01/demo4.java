package com.huaizhu.day01;

/**
 * 求数组的第i 到 n 位的和
 */


public class demo4 {
    public static void main(String[] args) throws Exception {

        int[] arr = {1,2,4,5,6,7,8,8,3,3,2};

        int sum = sum(arr,2,6);

        System.out.println(sum);
    }

    public static int sum(int[] arr,int l,int r) throws Exception {
        //定义一个h数组
        //h 数组的 第0位 表示 arr 0-0 的和
        //第1位表示 arr数组的0-1位置的和
        int[] h = new int[arr.length];

        h[0] = arr[0];
        for (int i = 1; i < arr.length-1 ; i++) {
            h[i] = h[i-1] + arr[i];
        }

        //需要判定l 和 r 是否越界
        if(r <0 || r > arr.length-1){
            throw new Exception("index out");
        }

        if(l == 0){
            return h[r];
        }
        //3-8
        //h[8] -h[2]
        return h[r] - h[l-1];
    }

}
