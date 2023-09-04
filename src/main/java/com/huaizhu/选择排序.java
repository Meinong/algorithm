package com.huaizhu;

/**
 * 0～N-1位置选择一个最小的
 * 1～N-1位置选择一个最小的
 * ...
 */
public class 选择排序 {

    public static void main(String[] args) {
        int[] arr = {1,4,2,4,5,6,3,9,8,4};
        selectSort(arr);
        printArr(arr);
    }

    public static void selectSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        for (int i = 0; i< arr.length;i++){
            int minValueIndex = i; //最小值位置
            for (int j = i+1;j<arr.length;j++){
                minValueIndex = arr[j] < arr[minValueIndex] ? j : minValueIndex;
            }
            swap(arr,i,minValueIndex);
        }
    }

    public static void swap(int[] arr,int i,int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void printArr(int[] arr){
        for (int i = 0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
