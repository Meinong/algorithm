package com.huaizhu;

public class 找出数组中出现一种数为奇数次的数 {

    public static void main(String[] args) {
        int[] arr = {1,1,1,1,2,2,2,3,3,3,3};

    }


    //偶数次数异或 == 0
    //奇数次数异或 == 自己
    public static int find(int[] arr){
        int ans = 0;
        for (int i = 0;i<arr.length;i++){
            ans = ans ^ arr[i];
        }
        return ans;
    }

}
