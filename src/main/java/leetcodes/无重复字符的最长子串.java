package leetcodes;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 输入: s = "pwwkew"
 *           012345
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 提示： 0 <= s.length <= 5 * 10^4
 */
public class 无重复字符的最长子串 {


    /**
     * abcabcbb
     * 01234567
     *   0 1 2 3 4 5 6 7
     * 0 1 2
     * 1   1 2
     * 2     1 2 3 3
     * 3       1 2 3 3 3
     * 4         1 2 2 2
     * 5           1 2 2
     * 6             1 1
     * 7               1
     * @param s
     * @return
     */


    //测试用利通过，但是内存超出限制
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() < 1){
            return 0;
        }

        char[] str = s.toCharArray();
        int N = str.length;
        int[][] dp = new int[N][N];
        for (int i = 0;i<N-1;i++){
            dp[i][i] = 1;
            dp[i][i+1] = str[i] != str[i+1] ? 2: 1;
        }
        dp[N-1][N-1] = 1;

        for (int i = N-3;i>=0;i--){
            for (int j=i+2;j<N;j++){
                if(dp[i][j-1] != dp[i+1][j]){
                    dp[i][j] = Math.max(dp[i][j-1],dp[i+1][j]);
                }else{
                    dp[i][j] = str[j] == str[i] ? dp[i][j-1] :  ( dp[i][j-1] + 1 != j-i+1 ? dp[i][j-1] :  dp[i][j-1] + 1) ;
                }
            }
        }
        return dp[0][N-1];
    }


    /**
     * 通过
     * "abcabcbb"
     *  01234567
     *
     * "pwwkew"
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        if(s == null || s.length() < 1){
            return 0;
        }
        char[] str = s.toCharArray();
        int N = str.length;
        int L = 0;
        int R = 0;
        int ans = 1;
        HashMap<Character,Integer> charIndex = new HashMap<>();
        charIndex.put(str[L],L);
        while (++R < N){
            if(charIndex.containsKey(str[R])){
                L = Math.max(L,charIndex.get(str[R]) + 1);
            }
            charIndex.put(str[R],R);
            ans = Math.max(R-L+1,ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring2(s));
    }

}
