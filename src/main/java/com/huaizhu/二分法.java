package com.huaizhu;

public class 二分法 {

    public static void main(String[] args) {
        int[] arr = {1,2,2,4,5,6,7,7};
        int index = find(arr, 4);
        System.out.println("下标为:" + index);
    }

    public static int find(int[] arr,int num){
        int ans = -1;
        if(arr == null || arr.length == 0){
            return ans;
        }
        int L = 0;
        int R = arr.length - 1;
        while (L <= R){
            int mid = (L + R) / 2;
            if(arr[mid] == num){
                return mid;
            }
            if(arr[mid] < num){
                L = mid + 1;
            }else{
                R = mid -1;
            }
        }
        return ans;
    }
}
