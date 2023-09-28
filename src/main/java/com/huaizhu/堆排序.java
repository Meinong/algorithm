package com.huaizhu;

import java.util.Arrays;

/**
 * 左节点为  i* 2 +1
 * 右节点为  i* 2 +2
 * 头节点为（i-1）/2
 * 时间复杂度： O(n*logN)
 *
 * 先让整个数组都变成大根堆结构
 * 把堆的最大值和堆末尾的值交换，然后减少堆的大小之后，再去调整堆，一直周而复始
 * 堆的大小减为0之后，排序完成
 */
public class 堆排序 {

    public static void main(String[] args) {

        int[] arr = {2, 4, 5, 1, 3, 6, 8, 3, 5, 7};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));

    }


    public static void heapSort(int[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }

        //1.每个数向上比较(和父类做比较)
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }

//        //2.或者 从最后一个数开始向下比较
//        for (int i = arr.length-1;i>=0;i++){
//            heapify(arr,i,arr.length);
//        }



        int heapSize = arr.length;
        swap(arr, 0, --heapSize);

        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    public static void heapInsert(int[] arr, int i) {
        while (arr[i] > arr[(i - 1) / 2]) {
            swap(arr, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    public static void heapify(int[] arr, int i, int heapSize) {
        int left = i * 2 + 1;
        while (left < heapSize) {
            int lagest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            lagest = arr[lagest] > arr[i] ? lagest : i;
            if (lagest == i) {
                break;
            }
            swap(arr, lagest, i);
            i = lagest;
            left = i * 2 + 1;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
