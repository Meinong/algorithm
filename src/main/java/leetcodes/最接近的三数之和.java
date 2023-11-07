package leetcodes;

import java.util.Arrays;

/**
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * <p>
 * 返回这三个数的和。
 * <p>
 * 假定每组输入只存在恰好一个解。
 * <p>
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 */
public class 最接近的三数之和 {
    public static int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }

        int N = nums.length;
        if (N == 3) {
            return Arrays.stream(nums).sum();
        }
        //N  > 3
        Arrays.sort(nums);
        Integer min = null;
        int ans = 0;


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

                int cur = nums[i] + nums[j] + nums[x];
                if (cur == target) {
                    return cur;
                }
                if (cur < target) {
                    j++;
                }
                if (cur > target) {
                    x--;
                }
                if(min == null){
                    min = Math.abs(target - cur);
                    ans = cur;
                }else{
                    if(min > Math.abs(target - cur)){
                        ans = cur;
                        min = Math.abs(target-cur);
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {833,736,953,-584,-448,207,128,-445,126,248,871,860,333,-899,463,488,-50,-331,903,575,265,162,-733,648,678,549,579,-172,-897,562,-503,-508,858,259,-347,-162,-505,-694,300,-40,-147,383,-221,-28,-699,36,-229,960,317,-585,879,406,2,409,-393,-934,67,71,-312,787,161,514,865,60,555,843,-725,-966,-352,862,821,803,-835,-635,476,-704,-78,393,212,767,-833,543,923,-993,274,-839,389,447,741,999,-87,599,-349,-515,-553,-14,-421,-294,-204,-713,497,168,337,-345,-948,145,625,901,34,-306,-546,-536,332,-467,-729,229,-170,-915,407,450,159,-385,163,-420,58,869,308,-494,367,-33,205,-823,-869,478,-238,-375,352,113,-741,-970,-990,802,-173,-977,464,-801,-408,-77,
                694,-58,-796,-599,-918,643,-651,-555,864,-274,534,211,-910,815,-102,24,-461,-146};
        int target = -7111;
        System.out.println(threeSumClosest(nums, target));
    }
}
