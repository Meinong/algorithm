package com.huaizhu;

public class 不用任何变量交换两个数 {


    //异或：相同为0 不同为1
    //异或: 无进位相加
    public void swap(int a, int b) {
        if(a == b){
            return;
        }
        a = a ^ b;
        b = a ^ b;    //a ^ b ^ b ==>a
        a = a ^ b;    // a ^ b ^ a ==> b
    }




}
