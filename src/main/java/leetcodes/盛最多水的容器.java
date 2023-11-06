package leetcodes;

/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * <p>
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 返回容器可以储存的最大水量。
 * <p>
 * 说明：你不能倾斜容器。
 * <p>
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 */
public class 盛最多水的容器 {

    public static int maxArea(int[] height) {
        int L = 0;
        int max = 0;
        int R = height.length - 1;

        while (L <= R) {
            max = Math.max(max, (R - L) * Math.min(height[L], height[R]));
            if (height[L] < height[R]) {
                L++;
            } else {
                R--;
            }
        }
        return max;
    }

    public static int maxArea1(int[] height) {
        if (height == null || height.length < 1) {
            return 0;
        }
        int N = height.length;
        int[][] dp = new int[N][N];
        for (int i = 0; i < N - 1; i++) {
            dp[i][i] = 0;
            dp[i][i + 1] = Math.min(height[i], height[i + 1]);
        }
        dp[N - 1][N - 1] = 0;
        for (int i = N - 3; i >= 0; i--) {
            for (int j = i + 2; j < N; j++) {
                int current = (j - i) * Math.min(height[i], height[j]);
                dp[i][j] = Math.max(Math.max(current, dp[i][j - 1]), Math.max(dp[i + 1][j], dp[i + 1][j - 1]));
            }
        }
        return dp[0][N - 1];
    }


    public static int maxArea2(int[] height) {
        if (height == null || height.length < 1) {
            return 0;
        }
        int N = height.length;
        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = -1;
            }
        }
        process(height, 0, N - 1, dp);
        return dp[0][N - 1];
    }

    public static int process(int[] height, int L, int R, int[][] dp) {
        if (dp[L][R] != -1) {
            return dp[L][R];
        }
        if (L >= R) {
            dp[L][R] = 0;
        } else {
            //两边都要
            int p1 = (R - L) * Math.min(height[L], height[R]);
            //要左边不要右边
            int p2 = process(height, L, R - 1, dp);
            int p3 = process(height, L + 1, R, dp);
            int p4 = process(height, L + 1, R - 1, dp);
            dp[L][R] = Math.max(Math.max(p1, p2), Math.max(p3, p4));
        }
        return dp[L][R];
    }


    public static int process1(int[] height, int L, int R) {
        if (L >= R) {
            return 0;
        }
        //两边都要
        int p1 = (R - L) * Math.min(height[L], height[R]);
        //要左边不要右边
        int p2 = process1(height, L, R - 1);
        int p3 = process1(height, L + 1, R);
        int p4 = process1(height, L + 1, R - 1);
        return Math.max(Math.max(p1, p2), Math.max(p3, p4));
    }

    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(process1(height, 0, height.length - 1));
        System.out.println(maxArea2(height));
        System.out.println(maxArea1(height));
        System.out.println(maxArea(height));
    }
}
