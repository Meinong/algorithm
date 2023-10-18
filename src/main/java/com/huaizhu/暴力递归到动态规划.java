package com.huaizhu;

public class 暴力递归到动态规划 {
    /**
     * N: 一共有几个数
     * start: 机器人当前在什么位置
     * aim: 机器人最终需要到达的位置
     * K: 一共走几步 到达aim 位置
     * return 有多少种方式
     */
    public static int test1(int N, int start, int aim, int K) {
        return f(start, K, aim, N);
    }

    public static int f(int cur, int rest, int aim, int N) {
        if (rest == 0) {
            //剩余步数为0 判定当位置与目标位置是否一致
            return cur == aim ? 1 : 0;
        }
        if (cur == 1) {
            //当cur == 1 时 只能往右走
            return f(2, rest - 1, aim, N);
        }
        if (cur == N) {
            //当cur == N 时 只能往左走
            return f(N - 1, rest - 1, aim, N);
        }
        //当前cur 在中间 既可以往左 又可以往右
        return f(cur - 1, rest - 1, aim, N) + f(cur + 1, rest - 1, aim, N);
    }


    /**
     * 动态规划
     */
    public static int test2(int N, int start, int aim, int K) {
        return f(start, K, aim, N);
    }

    public static int f2(int start, int K, int aim, int N) {
        int[][] dp = new int[N + 1][K + 1];
        dp[aim][0] = 1;
        for (int rest = 1; rest <= K; rest++) {
            dp[1][rest] = dp[2][rest - 1];
            for (int cur = 2; cur < N; cur++) {
                dp[cur][rest] = dp[cur - 1][rest - 1] + dp[cur + 1][rest - 1];
            }
            dp[N][rest] = dp[N - 1][rest - 1];
        }
        return dp[start][K];
    }
}
