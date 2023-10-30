package leetcodes;

import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 */
public class 两数之和 {

    public static int[] twoSum(int[] nums, int target) {
        return process(nums,target);
    }



    public static int[] process(int[] nums, int target){
        HashMap<Integer,Integer> indexMap = new HashMap<Integer,Integer>();
        for(int i = 0;i<nums.length;i++){
            indexMap.put(nums[i],i);
        }

        for(int i = 0;i<nums.length;i++){
            if(indexMap.containsKey(target-nums[i]) && i!=indexMap.get(target-nums[i])){
                return new int[]{i,indexMap.get(target-nums[i])};
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        System.out.println(twoSum(nums, target));
    }
}
