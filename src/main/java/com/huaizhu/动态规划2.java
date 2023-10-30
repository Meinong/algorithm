package com.huaizhu;

public class 动态规划2 {

    /**
     * 给定一个整数数组 arr,代表数值不同的纸牌排成一条线
     * 玩家A和玩家B依次拿走每张纸牌
     * 规定玩家A先拿，玩家B后拿
     * 但是每个玩家每次只能拿走最左或最右的纸牌
     * 玩家A和玩家B都聪明绝顶
     * 请返回最后获胜者的分数
     */


    public static int getMaxScore(int[] arr){
        if(arr == null || arr.length < 1){
            return 0;
        }
        int firstUser = f(arr,0,arr.length-1);
        int secondUser = g(arr,0,arr.length-1);
        return Math.max(firstUser,secondUser);
    }

    //先手
    public static int f(int[] arr,int L,int R){
        if(L == R){
            return arr[L];
        }
        int p1 = arr[L] + g(arr,L+1,R);
        int p2 = arr[R] + g(arr,L,R-1);
        return Math.max(p1,p2);
    }

    //后手
    public static int g(int[] arr,int L,int R){
        if(L == R){ //只剩下最后一张牌，你是后手 没牌可拿
            return 0;
        }
        int p1 = f(arr,L+1,R); //对方拿走了L
        int p2 = f(arr,L,R-1); //对方拿走了R
        return Math.min(p1,p2);
    }
}
