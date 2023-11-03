package leetcodes;

import java.util.Arrays;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1] ，就返回 0。
 * <p>
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 * <p>
 *
 * 123 / 10  = 12 .. 3
 * 12 /10 = 1 。。。2
 * 1 /10 = 0 ..1
 *
 *
 * 12 /10 = 1....2
 * 1/10 = 0 ...1
 *
 */
public class 整数反转 {
    public static int reverse(int x) {
        if(x == Integer.MIN_VALUE || x == Integer.MAX_VALUE){
            return 0;
        }
        // 小于0 的都表示为负数
        int sign = (int)Math.signum(x);
        int divid = Math.abs(x) / 10;
        if(divid == 0){
            return x;
        }
        int reverseAns = 0;
        //如果两位数以上
        int[] ans = new int[33]; //1...33 一共33位
        int i = 1;
        int firstRemainder  = Math.abs(x) % 10 ;
        ans[1] = firstRemainder;
        while (divid > 0){
            int remainder = divid % 10;
            divid = divid / 10;
            i++;
            ans[i] = remainder;
        }

        int wei = i-1;
        int j = 1;
        while (j <= i && reverseAns < Integer.MAX_VALUE){
            reverseAns += ans[j] * Math.pow(10,wei);
            wei--;
            j++;
        }
        reverseAns *= j <= i ? 0 : (sign < 0 ? -1 : 1);
        return reverseAns;
    }

    public static void main(String[] args) {
        int x = 123;
        System.out.println(Math.abs(x));
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(reverse(x));
    }
}
