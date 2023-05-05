package com.huaizhu.day02;


/**
 * 二分查询
 */
public class demo1 {



    public static void main(String[] args) {
        //arr 是有序的
        int[] arr = {1,2,2,3,3,4,5,6,7,7,8,9};
        //System.out.println(find(arr,4));
        //System.out.println(mostLeftNoMoreNum(arr,3));
        System.out.println(mostRightNoMoreNum(arr,3));
    }



    public static boolean find(int[] arr,int num){
        if(arr == null || arr.length ==0){
            return false;
        }
        int L = 0;
        int R = arr.length -1;

        while (L <= R){
            int mid  = (L+R) / 2;
            if(arr[mid] == num){
                return true;
            }else if (arr[mid] > num){
                R = mid - 1;
            }else{
                L = mid + 1;
            }
        }
        return false;
    }

    //找到>=num 最左的位置

    public static int mostLeftNoMoreNum(int[] arr,int num){

        if(arr == null || arr.length == 0){
            return -1;
        }
        int L = 0;
        int R = arr.length - 1;
//        int index = arr.length-1;
//        while (L <= R){
//            int mid = (L + R) / 2;
//            if(arr[mid] == num){
//                R = mid -1;
//                index = Math.min(index,mid);
//            } else if (arr[mid] < num) {
//                L = mid + 1;
//            }else{
//                R = mid -1;
//            }
//        }


        int index = -1;
        while (L <= R){
            int mid = (L + R) / 2;
            if(arr[mid] >= num){
                R = mid -1;
                index = mid;
            } else{
                L = mid + 1;
            }
        }
        return index-1;
    }

    //返回 <=num 最右边的index
    // int[] arr = {1,2,2,3,3,4,5,6,7,7,8,9};
    public static int mostRightNoMoreNum(int[] arr,int num){

        if(arr == null || arr.length == 0){
            return -1;
        }

        int L = 0;
        int R = arr.length - 1;
        int index = -1;

        while (L <= R){
            int mid = (L + R) / 2;
            if(arr[mid] <= num){
                L = mid + 1;
                index = mid;
            }else{
                R = mid -1;
            }
        }
        return index;
    }


    // 数组无序 且 相邻的不相等
    //局部最小
    //定义 [0] < [1] 那么 0位置是局部最小
    //[n-2] > [n-1] 那么 n-1 位置上局部最小
    // [i-1] > [i] < [i+1] 那么i 位置上局部最小
    public static int oneMinIndex(int[] arr){
        if(arr == null || arr.length == 0){
            return -1;
        }

        int N = arr.length;
        if(N == 1 || arr[0] < arr[1]){
            return 0;
        }

        if(arr[N -2] > arr[N - 1]){
            return arr.length - 1;
        }

        int L = 0;
        int R = arr.length -1 ;
        // L mid R 存在边界的问题
        // L R 无法计算
        while (L < R-1){
            int mid = (L + R) / 2;
            if(arr[mid] < arr[mid + 1] && arr[mid] < arr[mid-1]){
               return mid;
            }
            if(arr[mid] > arr[mid-1]){
                R = mid -1;
            }else{
                L = mid + 1;
            }
        }

        return arr[L] < arr[R] ? L : R;

    }

}
