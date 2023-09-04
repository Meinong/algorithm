package com.huaizhu;

/**
 * 冒泡排序：
 * 0-N-1 两两比较算出最大值  N-1 值已确定
 * 0-N-2 两两比较算出最大值  N-2 值已确定
 */
public class 冒泡排序 {

    public static void main(String[] args) {
        int[] arr = {1,4,5,2,4,5,6,8,5,4,8,7};
        bubbleSort(arr);
        print(arr);
    }

    public static void bubbleSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        int n = arr.length;
        for (int end = n-1; end >= 0 ;end--){
            //0 1  1 2  2 3    end-1 end 相比较  （相临的相比较）
            for (int second = 1; second <= end; second++){
                if(arr[second-1] > arr[second]){
                    swap(arr,second-1,second);
                }
            }
        }
    }

    public static void swap(int[] arr,int i,int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void print(int[] arr){
        for (int i = 0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }
}
