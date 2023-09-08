package com.huaizhu;

public class 二分法局部最小 {


    public static void main(String[] args) {
        int[] arr = {2,4,1,3,5,6,3};
        int ans = find(arr);
        System.out.println(ans);
    }


    public static int find(int[] arr){
        int ans = -1;
        if(arr == null || arr.length == 0){
            return ans;
        }
        int L= 0;
        int R = arr.length -1;
        if(arr.length == 1){
            return arr[0];
        }
        if(arr.length == 2){
            return Math.min(arr[L], arr[R]);
        }
        while (L <= R-1){
            int mid = (L + R) / 2;
            if(arr[mid-1] > arr[mid] && arr[mid+1] > arr[mid]){
                return arr[mid];
            }
            if(arr[mid-1] < arr[mid]){
                R = mid -1;
            }else{
                L = mid + 1;
            }
        }
        return Math.min(arr[L], arr[R]);
    }

    // 2 4 2 1
}
