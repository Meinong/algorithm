package com.huaizhu;

import sun.security.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * 给定一个数组arr两个整数lower和upper,返回arr中有多少个数组的累加和在两个整数[lower,upper]范围上
 */
public class 给定一个数组arr两个整数返回arr中有多少个数组的累加和在两个整数范围上 {

    //0-0 0-1 0-2 0-3
    //1-1 1-2 1-3
    //2-2 2-3
    //3-3
    //[1,2,3,4]
    public static class Test{

    }


    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        for(int num:nums){
            output.add(num);
        }

        process(nums,0,ans);
        return ans;
    }


    public static void process(int[] nums, int index, List<List<Integer>> ans){
        if(index == nums.length){
            ans.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        }else{
            for(int i = index;i<nums.length;i++){
                swap(nums,i,index);
                process(nums,index+1,ans);
                swap(nums,i,index);
            }
        }
    }


    public static void swap(int[] nums, int i, int j){
        Integer temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }

}
