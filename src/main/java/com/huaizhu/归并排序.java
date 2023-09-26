package com.huaizhu;

public class 归并排序 {

    //递归方式
    public static void process(int[] arr,int L,int R){
        if(L == R){
            return;
        }
        int mid = L + (R-L) >> 1; //(R-L) /2
        process(arr,L,mid);
        process(arr,mid+1,R);
        merge(arr,L,mid,R);
    }

    //非递归方式
    public static void process2(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        int step = 1;
        int N = arr.length;
        while (step < N){
            int L = 0;
            while (L < N){
                int mid;
                if(N-1+L+1 >= step){
                    mid = L + step -1;
                }else{
                    mid = N-1;
                }
                if(mid == N-1){
                    break;
                }
                int R;
                if(N-1 + mid+1 -1 >=step){
                    R = mid + 1 + step -1;
                }else{
                    R = N-1;
                }
                merge(arr,L,mid,R);
                if(R == N-1){
                    break;
                }else{
                    L = R +1;
                }
            }
            if(step > N/2){
                break;
            }else{
                step *= 2;
            }
        }
    }

    public static void merge(int[] arr,int L,int mid,int R){
        int[] help = new int[R-L+1];
        int i = 0;
        int p1 = L;
        int p2 = mid +1;
        while (p1 <= mid && p2 <= R){
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        //要么p1 越界 要么p2 越界
        while(p1 <= mid){
            help[i++] = arr[p1++];
        }

        while (p2 <= R){
            help[i++] = arr[p2++];
        }

        for (i = 0;i<help.length;i++){
            arr[L + i] = help[i];
        }
    }
}
