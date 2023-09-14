package com.huaizhu;

public class 快速排序 {


    /**
     * 小于最后一个数放左边 大于放右边
     *
     * @param arr
     */
    public static void splitNum(int[] arr) {
        int lessEqualR = -1;
        int index = 0;
        int mostR = arr.length - 1; //拿最后一个数作比较

        while (index < arr.length) {
            if (arr[index] <= arr[mostR]) {
                swap(arr, lessEqualR + 1, index);
                lessEqualR++;
                index++;
            } else {
                index++;
            }
        }
    }

    /**
     * 小于放左边 等于放中间 大于放右边
     * 条件1:小于 时 小边界的后一个数 与 index 交换 小边界移动下一个位置 并且 index移动下一个位置
     * 条件2：大于 时 大边界的前一个数 与 index 交换 大边界往前移动一个位置
     * 条件3: 相等 时 index 移动一个位置
     * 最后交换 最后一个数 与 大边界的第一个数
     * @param arr
     */
    public static void splitNum2(int[] arr) {
        int LessEqualR = -1;
        int moreEqualR = arr.length - 1;
        int index = 0;
        int mostR = arr.length - 1;
        while (index < arr.length) {
            if (arr[index] < arr[mostR]) {
                swap(arr, LessEqualR + 1, index);
                LessEqualR++;
                index++;
            } else if (arr[index] > arr[mostR]) {
                swap(arr, moreEqualR - 1, index);
                moreEqualR--;
            } else {
                index++;
            }
        }
        //最后交换 大区域第一个和最后一个交换
        swap(arr, moreEqualR, mostR);
    }

    public static int[] partion(int[] arr, int L, int R) {
        int lessR = L - 1;
        int moreR = R;
        int index = L;
        while (index < arr.length) {
            if (arr[index] < arr[R]) {
                swap(arr, lessR + 1, index);
                lessR++;
                index++;
            } else if (arr[index] > arr[R]) {
                swap(arr, moreR - 1, index);
                moreR--;
            } else {
                index++;
            }
        }
        //最后交换 大区域第一个和最后一个交换
        swap(arr, moreR, R);
        return new int[]{lessR + 1, moreR};
    }

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    public static void process(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        //L < R
        int[] partion = partion(arr, L, R);
        process(arr, L, partion[0] - 1);
        process(arr, partion[1] + 1, R);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

}
