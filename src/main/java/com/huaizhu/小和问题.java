package com.huaizhu;

/**
 * 数组中每个数 左边比他小的数之后
 * 所有和累加
 *
 * 通过归并排序 求最小和问题
 */
public class 小和问题 {

    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    public static int process(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return process(arr, l, mid) + process(arr, mid + 1, r) + merge(arr, l, mid, r);
    }

    public static int merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int p1 = l;
        int p2 = mid + 1;
        int res = 0;
        int i = 0;
        while (p1 <= mid && p2 <= r) {
            res += arr[p1] < arr[p2] ? arr[p1] * (r - p2 + 1) : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= mid){
            help[i++] = arr[p1++];
        }

        while (p2 <= mid){
            help[i++] = arr[p2++];
        }

        for (i = 0;i<help.length;i++){
            arr[l+i] = help[i];
        }
        return res;
    }
}
