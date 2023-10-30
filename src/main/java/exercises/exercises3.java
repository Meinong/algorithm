package exercises;

public class exercises3 {
    /**
     * 题目：给定一个非负整数num
     * 如何不用循环语句，
     * 返回 >= num 并且离num最近的，2的某次方
     * <p>
     * eg:如果num == 7 那么返回 8
     * 如果num == 14 那么返回 16
     */

    public static int tableSizeFor(int n) {
        n--; //-1的目的是 n 自己本身就是2的某次方
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : n + 1;
    }
}
