package com.huaizhu.day01;

public class demo5 {

    public static void main(String[] args) {
        int testCount = 10000;
        int count = 0;
        double x = 0.7;
        for (int i = 0; i < testCount; i++) {
            if(xToXPower2() < x){
                count++;
            }
        }
        System.out.println( (double) count / (double) testCount);
        System.out.println(Math.pow(x,2));
    }


    //1-4
    //1 2 3 4

    // [0,1)
    public static int f(){
        return (int) (Math.random() * 5) +1;
    }

    public static double f2(){
        return Math.random();
    }

    //返回[0,1) 的一个小数
    //任意的X ,X属于[0,1) ,[0,x) 范围上的数出现的概率由原来的x调整成x的平方

    //只有当 两个Math.random 都落到0-x 范围上时。math.max 结果才落在0-x 上
    public static double xToXPower2(){
        return Math.max(Math.random(),Math.random());

        //2x - x的平方 ==>  1-(1-x)2
        //return Math.min(Math.random(),Math.random());
    }
}
