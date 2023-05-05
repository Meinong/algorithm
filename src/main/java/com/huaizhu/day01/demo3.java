package com.huaizhu.day01;

/**
 * 选择排序 （从小到大）
 * [1,2,4,2,4,4,2,2,4,6,7,8]
 * 第一次排序：index=0 与 index=1-----n-1 之间进行比较 选择最小的 放在index=0的位置
 * 第二次排序：index=1 与 index=2-----n-1 之间进行比较 选择最小的 放在index=1的位置
 *
 *
 *
 */
public class demo3 {
    public static void main(String[] args) {
        int[] arr = {1,3,5,6,7,3,4,2,4,6,7,2,3,1,0};
        print(arr);
        //selectSort(arr);
        //bubbleSort(arr);
        //insertSort(arr);
        insertSort2(arr);
        print(arr);
    }

    //插入排序
    public static void insertSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        //设计思路
        //0 -- 第0个位置 排序
        //0-1 第0到1个位置排序
        //0-2 第0到2个位置排序
        //0-n-1 第0到n-1个位置排序
        int N = arr.length;
        for (int end = 1; end < N ; end++) {
            int newNumIndex = end;

            // 左边的数存在 并且 左边的数大于当前的数交换
            while (newNumIndex - 1 >= 0 && arr[newNumIndex -1] > arr[newNumIndex]){
                swap(arr,newNumIndex-1,newNumIndex);
                newNumIndex--;
            }
        }
    }


    public static void insertSort2(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        int N = arr.length;
        for (int end = 1; end < N; end++) {
            for (int pre = end-1; pre >= 0 && arr[pre] > arr[pre+1] ; pre--) {
                swap(arr,pre,pre+1);
            }
        }
    }

    //冒泡排序
    public static void bubbleSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        //0---n-1
        //0---n-2
        //0---n-3

        int N = arr.length;
        //每一次循环请求一个最大值放在 end的位置
        for (int end = N-1; end >=0 ; end--) {

            for (int second = 1; second <= end; second++) {
                //0 1 相比较   1 2 相比较   2 3 相比较
                if(arr[second-1] > arr[second]){
                    swap(arr,second-1,second);
                }
            }
        }

    }


    //选择排序
    public static void selectSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        //选择排序 先排首部
        //0 ～ n-1
        //1 ～ n-1
        //2 ～ n-1
        for (int i = 0; i < arr.length; i++) {
            int minValIndex = i;
            for (int j = i+1; j < arr.length ; j++) {
                //比较最小值,找到最小index
                if(arr[j] < arr[minValIndex]){
                    minValIndex = j;
                }
            }
            //交换数据
            swap(arr,minValIndex,i);
        }
    }

    public static void swap(int[] arr,int i,int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void print(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
