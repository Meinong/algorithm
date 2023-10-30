package leetcodes;

/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aa", p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * <p>
 * 输入：s = "aa", p = "a*"
 * 输出：true
 * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3：
 * <p>
 * 输入：s = "ab", p = ".*"
 * 输出：true
 * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 */
public class 正则表达式匹配 {


    public static boolean isMatch(String s, String p) {
        char[] str = s.toCharArray();
        char[] pStr = p.toCharArray();
        return process(str, str.length-1, pStr, pStr.length-1);
    }

    public static boolean process(char[] str,  int R, char[] pStr,  int PR) {
        if(R <0 && PR < 0){
            return true;
        }
        if(R < 0){
            //PR 不小于0
            return pStr[PR] == '*' && process(str, R, pStr, PR - 2);
        }
        if(PR < 0){
            return false;
        }

        //R !<0 && PR !< 0

        if(pStr[PR] == '*'){
            if(pStr[PR-1] == '.'){
                return process(str,  R, pStr, PR -2) || process(str,  R-1, pStr, PR);
            }else if(pStr[PR-1] == str[R]){
               return  process(str,  R-1, pStr, PR -2) || process(str,  R, pStr, PR -2) ;
            }else {
                return process(str,  R, pStr, PR -2);
            }
        }else if (str[R] == pStr[PR] || pStr[PR] == '.') {
            return process(str,  R-1, pStr, PR-1);
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        String s = "baabbbaccbccacacc";
        String p = "c*..b*a*a.*a..*c";
        System.out.println(isMatch(s, p));
    }

}
