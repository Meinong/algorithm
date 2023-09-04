package com.huaizhu;

/**
 * 打印某个数的二进制位
 */
public class 求int型的二进制 {


    public static void main(String[] args) {
//        int num = Integer.MAX_VALUE;
//        print(num);
        int a = 1;
        int b = -a;
        //print(a);
        int c = ~a + 1;
        //正数取反加1 -->负数  负数取反加1-->正数
        System.out.println(a); //1
        System.out.println(b); //-1
        System.out.println(c); //-1
        int d = ~c + 1;
        System.out.println(d); // 1
    }


    /**
     * 一个32位的整数上的每一位 与 相同位置的1 像& 来判定当前位置是0还是1
     * @param num
     */
    public static void print(int num){
        for (int i = 31;i>=0;i--){
            System.out.print((num & (1<<i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }


}
