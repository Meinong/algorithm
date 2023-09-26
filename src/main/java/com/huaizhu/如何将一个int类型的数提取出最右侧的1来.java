package com.huaizhu;


public class 如何将一个int类型的数提取出最右侧的1来 {

    //0111011110000 ==> a
    //1000100001111 ==> ~a
    //1000100010000 ===> -a

    // a & -a ==> 00000000010000
    public static void main(String[] args) {
        int a = 101;

        System.out.println(a & -a);
    }
}
