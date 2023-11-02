package leetcodes;

public class 最长回文子串 {

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        char[] str = s.toCharArray();

        boolean[][] dp = new boolean[str.length][str.length];
        int N = dp.length;
        int maxLength = 1;
        int startIndex = 0;
        for (int i = 0; i < N - 1; i++) {
            dp[i][i] = true; //对角线都只有一个
            dp[i][i + 1] = str[i] == str[i + 1];
            if (dp[i][i + 1] && maxLength < 2) {
                maxLength = 2;
                startIndex = i;
            }
        }
        dp[N - 1][N - 1] = true;

        for (int i = N - 3; i >= 0; i--) {
            for (int j = i + 2; j < N; j++) {
                if (str[i] == str[j] && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    if (maxLength < j - i + 1) {
                        maxLength = j - i + 1;
                        startIndex = i;
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return s.substring(startIndex, startIndex + maxLength);
    }


    public static void main(String[] args) {
        String str = "babad";
        System.out.println(longestPalindrome(str));
    }

}
