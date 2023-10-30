package exercises;

public class exercises5 {
    /**
     * 给定一个二维数组matrix
     * 你可以从任何位置出发，走向上下左右四个方向
     * 返回能走出来的最长的递增链长度
     */
    public static int process(int[][] arr, int i, int j) {
        int up = i > 0 && arr[i][j] < arr[i - 1][j] ? process(arr, i - 1, j) : 0;
        int down = i < arr.length && arr[i][j] < arr[i + 1][j] ? process(arr, i + 1, j) : 0;
        int left = j > 0 && arr[i][j] < arr[i][j - 1] ? process(arr, i, j - 1) : 0;
        int right = j < arr.length && arr[i][j] < arr[i][j + 1] ? process(arr, i, j + 1) : 0;
        return Math.max(Math.max(up, down), Math.max(left, right)) + 1;
    }

    public static int test(int[][] arr) {
        int ans = 0;
        int N = arr.length;
        int M = arr[0].length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                ans = Math.max(ans, process(arr, i, j));
            }
        }
        return ans;
    }
}
