package exercises;


public class exercises1 {

    /**
     * 题目：
     * 给定一个有序数组arr,代表坐落在X轴上的点
     * 给定一个正数K，代表绳子的长度
     * 返回绳子最多压中几个点？
     * 即使绳子边缘处盖住点也算盖住。
     */

    /**
     * 第一种解题思路：
     * 以每个点X为结尾，往前推数 ，之后查询>=(x-k) && <= X 的个数(采用二分)
     * 时间复杂度为 nlogN
     */
    public static int maxPoint1(int[] arr, int K) {
        int res = 1;
        for (int i = 0; i < arr.length; i++) {
            int nearest = nearestIndex(arr, i, arr[i] - K);
            res = Math.max(res, i - nearest + 1);
        }
        return res;
    }

    public static int nearestIndex(int[] arr, int R, int value) {
        int L = 0;
        int index = 0;
        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] >= value) {
                index = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return index;
    }


    /**
     * 第二种方法：采用滑动窗口的方式
     * 时间复杂度为 N
     */
    public static int maxPoint2(int[] arr, int K) {
        int max = 0;
        int L = 0;
        int R = 0;
        while (L < arr.length) {
            while (R < arr.length && arr[R] - arr[L] <= K) {
                R++;
            }
            max = Math.max(max, R - L);
            L++;
        }
        return max;
    }


}
