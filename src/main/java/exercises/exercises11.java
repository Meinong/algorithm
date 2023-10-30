package exercises;

public class exercises11 {


    public static int getMaxMoney(int[][] arr) {
        if (arr == null || arr.length < 2 || (arr.length & 1) != 0) {
            return 0;
        }

        int N = arr.length;
        int M = arr.length >> 1;
        return process(arr, 0, M);
    }

    //rest ==> A 区域司机剩余的名额
    public static int process(int[][] arr, int index, int rest) {
        if (index == arr.length) {
            return 0;
        }
        if (arr.length - index == rest) {
            return arr[index][0] + process(arr, index + 1, rest - 1);
        }
        if (rest == 0) {
            return arr[index][1] + process(arr, index + 1, rest);
        }

        int p1 = arr[index][0] + process(arr, index + 1, rest - 1);
        int p2 = arr[index][1] + process(arr, index + 1, rest);
        return Math.max(p1, p2);
    }

    public static int getMaxMoney1(int[][] arr) {
        if (arr == null || arr.length < 2 || (arr.length & 1) != 0) {
            return 0;
        }

        int N = arr.length;
        int M = arr.length >> 1;

        int[][] dp = new int[N+1][M+1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M+1; j++) {
                dp[i][j] = -1;
            }
        }
        return process1(arr, 0, M, dp);
    }

    //rest ==> A 区域司机剩余的名额
    public static int process1(int[][] arr, int index, int rest, int[][] dp) {
        if (dp[index][rest] != -1) {
            return dp[index][rest];
        }
        int ans = 0;
        if (index == arr.length) {
            ans = 0;
        }else if (arr.length - index == rest) {
            ans = arr[index][0] + process1(arr, index + 1, rest - 1, dp);
        } else if (rest == 0) {
            ans = arr[index][1] + process1(arr, index + 1, rest, dp);
        } else {
            int p1 = arr[index][0] + process1(arr, index + 1, rest - 1, dp);
            int p2 = arr[index][1] + process1(arr, index + 1, rest, dp);
            ans = Math.max(p1, p2);
        }
        dp[index][rest] = ans;
        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = new int[1000][2];
        arr[0] = new int[]{10, 20};
        arr[1] = new int[]{10, 20};
        arr[2] = new int[]{10, 20};
        arr[3] = new int[]{10, 20};

        System.out.println(getMaxMoney(arr));
        System.out.println(getMaxMoney1(arr));

    }

}
