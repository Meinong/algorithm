package leetcodes;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * <p>
 * 你返回所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 */
public class 三数之和 {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return ans;
        }

        int N = nums.length;
        if (N == 3) {
            int sum = Arrays.stream(nums).sum();
            if (sum == 0) {
                process(nums, 0, 1, 2, ans);
            }
            return ans;
        }

        Arrays.sort(nums);
        //N > 3
        //[-1,0,1,2,-1,-4]
        for (int i = 0; i < N - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int x = N - 1;
            while (j < x) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    j++;
                    continue;
                }

                if (x < N - 1 && nums[x] == nums[x + 1]) {
                    x--;
                    continue;
                }

                if (nums[i] + nums[j] + nums[x] < 0) {
                    j++;
                    continue;
                }

                if (nums[i] + nums[j] + nums[x] > 0) {
                    x--;
                    continue;
                }
                process(nums, i, j, x, ans);
                j++;
                x--;
            }
        }
        return ans;
    }


    public static void process(int[] nums, int i, int j, int x, List<List<Integer>> ans) {
        List<Integer> cur = new ArrayList<>();
        cur.add(nums[i]);
        cur.add(nums[j]);
        cur.add(nums[x]);
        ans.add(cur);
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(nums);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
