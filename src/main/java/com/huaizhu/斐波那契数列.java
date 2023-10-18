package com.huaizhu;

/**
 * F(n) = F(n-1) + F(n-2)
 * F1 = 1
 * F2 = 1
 */
public class 斐波那契数列 {

    /**
     * 求 f(n) 的值
     * <p>
     * <p>
     * ｜F(n),F(n-1)｜ = ｜ F(2),F(1) | * | 1,1|
     * //      | 1,0|
     *
     * @param n
     * @return
     */
    public static int f(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        //算出来的值 这是2阶的值
        int[][] base = {
                {1, 1},
                {1, 0}
        };

        int[][] res = matrixPower(base, n - 2);
        return res[0][0] + res[1][0]; //｜1,1｜ * res==>｜a,b｜
        //   ｜c,d｜

        // == a+b ==> res[0][0] + res[1][0]
    }

    //1个矩阵的 power 次方
    public static int[][] matrixPower(int[][] base, int power) {
        int[][] res = new int[base.length][base[0].length];
        //res 矩阵中对角线全为1
        for (int i = 0; i < res.length; i++) {
            res[i][i] = 1;
        }

        //。。。。


    }
}
