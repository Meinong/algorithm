package leetcodes;

import com.sun.xml.internal.ws.util.StringUtils;

/**
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 * <p>
 * 函数 myAtoi(string s) 的算法如下：
 * <p>
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−2^31,  2^31 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −2^31 的整数应该被固定为 −231 ，大于 2^31 − 1 的整数应该被固定为 2^31 − 1 。
 * 返回整数作为最终结果。
 * 注意：
 * <p>
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
 */
public class 字符串转换整数 {

    public static int myAtoi(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        char[] str = s.toCharArray();
        String sign = "";
        int i = 0;
        //去掉前面的空格
        for (; i < str.length; i++) {
            if (str[i] != ' ') {
                break;
            }
        }
        //获取+/-
        if (i < str.length && (str[i] == '+' || str[i] == '-')) {
            sign = str[i] == '-' ? "-" : "";
            i++;
        }
        //排除前面是0的数据
        while (i < str.length && (str[i] == '0')) {
            i++;
        }
        int digitStartIndex = -1;
        int digitEndIndex = -1;
        if (i < str.length && Character.isDigit(str[i])) {
            digitStartIndex = i;
            digitEndIndex = i;
        } else {
            return 0;
        }

        //字母+数字
        for (int j = i + 1; j < str.length; j++) {
            if (!Character.isDigit(str[j])) {
                break;
            }
            digitEndIndex = j;
        }
        String newStr = s.substring(digitStartIndex, digitEndIndex + 1);
        if(!sign.equals("")){
            newStr = sign + newStr;
            String minStr = String.valueOf(Integer.MIN_VALUE);
            if(newStr.length() > minStr.length() || (newStr.length() == minStr.length() && newStr.compareTo(minStr) > 0) ){
                return Integer.MIN_VALUE;
            }
            if(newStr.length() < minStr.length() || newStr.compareTo(minStr) <= 0){
                return Integer.parseInt(newStr);
            }
        }
        String maxStr = String.valueOf(Integer.MAX_VALUE);
        if(newStr.length() > maxStr.length() || (newStr.length() == maxStr.length() && newStr.compareTo(maxStr) > 0)  ){
            return Integer.MAX_VALUE;
        }
        if(newStr.length() < maxStr.length() || newStr.compareTo(maxStr) <= 0){
            return Integer.parseInt(newStr);
        }
        return 0;
    }

    public static void main(String[] args) {
        String s = "2147483647";
        System.out.println(myAtoi(s));

        String s1 = String.valueOf(Integer.MIN_VALUE);
        System.out.println(myAtoi(s1));

//        String s1 = "-4";
//        String s2 = "-22";
//        System.out.println(s1.compareTo(s2));
    }
}
