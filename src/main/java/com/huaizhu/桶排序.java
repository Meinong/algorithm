package com.huaizhu;

import java.util.Arrays;

/**
 * 桶排序是不比较排序
 */
public class 桶排序 {


    public static void main(String[] args) {
        int[] arr = {103, 19, 392, 33, 2, 1, 39};
        sort(arr, 0, arr.length - 1, digest(arr));
        System.out.println(Arrays.toString(arr));
    }

    /**
     * @param arr
     * @param l
     * @param r
     * @param digest 表示最大值的个数
     */
    public static void sort(int[] arr, int l, int r, int digest) {
        int[] help = new int[arr.length];
        for (int i = 0; i < digest; i++) { //求出最大数的 有几位数
            int[] count = new int[10];
            for (int j=l;j<=r;j++){
                int positionValue = getDigest(arr[j], i); //遍历第i位数
                count[positionValue] ++; // 在count 中记录存在的次数
            }
            for (int j=1;j<count.length;j++){
                count[j] = count[j-1] + count[j]; //每个次数当前位+前一位
            }

            for (int j = r;j>=l;j--){ //从后往前遍历
                int positionValue = getDigest(arr[j], i);
                // positionValue = 5
                // count[5] == 6
                // 那么表示 0-5位置 因为从后往前遍历 所以取最后一位
                //之后 count[5]-- == 5
                help[count[positionValue]-1] = arr[j];
                count[positionValue]--;
            }
            for (int j=0;j<help.length;j++){
                arr[j] = help[j];
            }
        }

    }

    public static int digest(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int c : arr) {
            max = Math.max(c, max);
        }

        int res = 0;
        while (max > 0) {
            res++;
            max = max / 10;
        }
        return res;
    }

    public static int getDigest(int value,int position){
        int positionValue = 0;
        for (int i=0;i<=position;i++){
            positionValue = value % 10;
            value = value /10;
        }
        return positionValue;
    }

}
