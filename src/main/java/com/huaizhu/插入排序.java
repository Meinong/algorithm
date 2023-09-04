package com.huaizhu;

/**
 * 0-0 位置上有序
 * 0-1 位置上有序
 * 0-2 位置上有序
 * 0-3 位置上有序
 */
public class 插入排序 {

    public static void main(String[] args) {
        int[] arr = {1,4,2,4,5,6,3,9,8,4};
        insertSort(arr);
        printArr(arr);
    }

    public static void insertSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        int n = arr.length;
        for (int end = 1;end < n;end++){
            /*
            int newNumIndex = end;
            while (newNumIndex-1 >=0 && arr[newNumIndex-1] > arr[newNumIndex]){
                swap(arr,newNumIndex-1,newNumIndex);
                newNumIndex--;
            }*/
            for (int pre = end-1;pre >=0 && arr[pre]>arr[pre+1];pre-- ){
                swap(arr,pre,pre+1);
            }
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
