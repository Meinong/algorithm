package leetcodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个长度为 n 的整数数组和一个目标值 target ，
 * 寻找能够使条件 nums[i] + nums[j] + nums[k] < target 成立的三元组  i, j, k 个数（0 <= i < j < k < n）。
 * <p>
 * 输入: nums = [-2,0,1,3], target = 2
 * 输出: 2
 * 解释: 因为一共有两个三元组满足累加和小于 2:
 * [-2,0,1]
 * [-2,0,3]
 */
public class 较小的三数之和 {



    public static int threeSumSmaller(int[] nums,int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }

        int N = nums.length;
        if (N == 3) {
            int sum = Arrays.stream(nums).sum();
            if (sum < target) {
                return 1;
            }
            return 0;
        }
        int ans = 0;

        Arrays.sort(nums);
        //N > 3
        //[-1,0,1,2,-1,-4]
        for (int i = 0; i < N - 2; i++) {
            int j = i + 1; //1
            int x = N - 1; //5
            while (j < x) {
                int cur = nums[i] + nums[j] + nums[x];
                if (cur < target) {
                    ans += x-j;
                    j++;
                }
                if(cur >= target){
                    x--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-2,0,1,3};
        int target = 2;
        System.out.println(threeSumSmaller(nums, target));
    }
}

