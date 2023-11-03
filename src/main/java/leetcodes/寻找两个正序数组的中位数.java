package leetcodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * <p>
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * <p>
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * <p>
 * [1,3,5,7] [2,4,6,8]
 * <p>
 * 0 1 2 3
 * 0 1 2 3
 */
public class 寻找两个正序数组的中位数 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int M = nums1.length;
        int N = nums2.length;
        int[] newNums;
        if ((nums1 == null || nums1.length < 1) && (nums2 == null || nums2.length < 1)) {
            return 0;
        }
        if (nums1 == null || nums1.length < 1) {
            newNums = nums2;
        } else if (nums2 == null || nums2.length < 1) {
            newNums = nums1;
        } else {
            newNums = process(nums1, 0, M, nums2, 0, N);
        }
        Arrays.stream(newNums).forEach(i -> {
            System.out.print(i + " ");
        });
        System.out.println();
        return newNums.length % 2 != 0
                ? (double) newNums[(newNums.length - 1) / 2]
                : (double) (newNums[(newNums.length - 1) / 2] + newNums[((newNums.length - 1) / 2) + 1]) / 2;
    }

    public static int[] process(int[] nums1, int L1, int R1, int[] nums2, int L2, int R2) {
        int[] ans = new int[R1 + R2];
        int i = 0;
        while (L1 < R1 && L2 < R2) {
            if (nums1[L1] > nums2[L2]) {
                ans[i++] = nums2[L2++];
            } else {
                ans[i++] = nums1[L1++];
            }
        }

        while (L2 < R2) {
            ans[i++] = nums2[L2++];
        }
        while (L1 < R1) {
            ans[i++] = nums1[L1++];
        }
        return ans;
    }

    //int[] num1 = {5, 6};
    //int[] num2 = {1, 2, 3, 4, 7};
    public static int[] process2(int[] nums1, int L1, int R1, int[] nums2, int L2, int R2) {
        int[] ans = new int[R1 + R2];
        int LN = (R1 + L1) / 2;
        int LM = (R2 + L2) / 2;

        while (nums2[LM] < nums1[LN]) {
            LM = (R2 + LM) / 2;
        }




        int i = 0;
        while (L1 < R1 && L2 < R2) {
            if (nums1[L1] > nums2[L2]) {
                ans[i++] = nums2[L2++];
            } else {
                ans[i++] = nums1[L1++];
            }
        }

        while (L2 < R2) {
            ans[i++] = nums2[L2++];
        }
        while (L1 < R1) {
            ans[i++] = nums1[L1++];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] num1 = {5, 6};
        int[] num2 = {1, 2, 3, 4, 7};
        System.out.println(findMedianSortedArrays(num1, num2));
    }
}
