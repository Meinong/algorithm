package com.huaizhu;

/**
 * 一个数出现K次 其他数出现M次
 * K < M  && M > 1
 */
public class 找出数组中出现K次数的数 {


    public static int find(int[] arr,int K,int M){
        int[] t = new int[32];
        for (int num :arr){
            for (int i = 0; i<32; i++){
                if(((num >> i) & 1) !=0){ //计算num 每一位的值
                    t[i] ++; //计算每一位上出现的次数
                }
            }
        }
        int ans = 0;
        for (int i= 0;i<32;i++){
            if(t[i] % M !=0){ //当结果不等于0 说明第i位上有K次代表的数
                ans |= (1<<i);
            }
        }
        return ans;

    }
}
