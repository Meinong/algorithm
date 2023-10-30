package exercises;

public class exercises4 {

    /**
     * 题目：一个数组只有两种字符'G'和'B'
     * 想让所有的G都放在左侧，所有的B都放在右侧
     * 但是只能在相邻字符之间进行交换操作
     * 返回至少需要交换几次
     * 时间复杂度为 N
     * eg: BBGGBBGBG
     *     012345678
     *     L
     *       R ==> 移动2个 L++
     *      L R
     */

    public static int getSwapNumber(int[] arr) {
        int L = 0;
        int R = 0;
        int nums = 0;
        while (R < arr.length) {
            if (arr[R] == 'G') {
                nums += R - L;
                L++;
            }
            R++;
        }
        return nums;
    }
}
