package com.huaizhu;

public class 选择冒泡插入N阶乘二进制测试联系 {

    public static void main(String[] args) {
        int num = 10;
        binaryPrint(num);

        int[] arr = {3,1,35,3,5,7,9,5,6,9,6,2};
        selectSort(arr);
        print(arr);

        bubbleSort(arr);
        print(arr);

        insertSort(arr);
        print(arr);

    }

    public static void binaryPrint(int num){
        for(int i=31; i>=0; i--){
            System.out.print((num & 1<<i) == 0 ? "0" : "1");
        }
        System.out.println();
    }

    public static void selectSort(int[] arr){
        if(arr == null || arr.length <2){
            return;
        }
        for (int i=0;i<arr.length;i++){
            int minValueIndex = i;
            for (int j=i+1;j<arr.length;j++){
                minValueIndex = arr[j]<arr[minValueIndex] ? j : minValueIndex;
            }
            swap(arr,i,minValueIndex);
        }
    }

    public static void bubbleSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        for (int end = arr.length-1;end>=0;end--){
            for (int second = 1;second <=end;second++){
                if(arr[second-1] > arr[second]){
                    swap(arr,second-1,second);
                }
            }
        }
    }

    public static void insertSort(int[] arr){
        if(arr == null || arr.length <2){
            return;
        }
        for(int end= 1;end<arr.length;end++){
            for (int pre = end-1;pre >=0 && arr[pre] > arr[pre+1];pre--){
                swap(arr,pre,pre+1);
            }
        }
    }

    public static void swap(int[] arr,int i,int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static int jiecheng(int n){
        int ans = 0;
        int cur = 1;
        for(int i=1;i<=n;i++){
            cur = cur * i;
            ans += cur;
        }
        return ans;
    }

    public static void print(int[] arr){
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


}
