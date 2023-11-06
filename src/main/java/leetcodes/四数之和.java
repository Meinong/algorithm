package leetcodes;

import java.util.*;

/**
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。
 * 请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 * <p>
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 */
public class 四数之和 {

    //{-2,-1,-1,1,1,2,2};
    public static List<List<Integer>> fourSum1(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        //首先先排序
        Arrays.sort(nums);
        int N = nums.length;
        if (N < 4) {
            return new ArrayList<>();
        }
        if(N == 4){
            int sum = 0;
            for (int num : nums) {
                if(sum >= 0 && Integer.MAX_VALUE - sum > num) {
                    sum += num;
                }else if(sum < 0 && sum - Integer.MIN_VALUE > -num) {
                    sum += num;
                } else {
                    return new ArrayList<>();
                }
            }
            if(sum == target){
                process1(nums,0,1,2,3,ans);
                return ans;
            }else {
                return new ArrayList<>();
            }
        }

        for (int i = 0; i < N - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < N - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int L = j + 1;
                int R = N - 1;
                while (L < R) {
                    if (L > j + 1 && nums[L] == nums[L - 1]) {
                        L++;
                        continue;
                    }
                    if (R < N-1 && nums[R] == nums[R + 1]) {
                        R--;
                        continue;
                    }
                    if (nums[i] + nums[j] + nums[L] + nums[R] > target) {
                        R--;
                        continue;
                    }
                    if (nums[i] + nums[j] + nums[L] + nums[R] < target) {
                        L++;
                        continue;
                    }
                    process1(nums,i,j,L,R,ans);
                    L++;
                    R--;
                }
            }
        }
        return ans;
    }


    public static void process1(int[] nums,int i,int j,int L,int R, List<List<Integer>> ans) {
        ArrayList<Integer> cur = new ArrayList<>();
        cur.add(nums[i]);
        cur.add(nums[j]);
        cur.add(nums[L]);
        cur.add(nums[R]);
        ans.add(cur);
    }


    // {1, 0, -1, 0, -2, 2}  N ==6
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> ans = new HashSet<>();

        int N = nums.length;
        for (int i = 0; i < N - 3; i++) {
            List<Integer> cur = new ArrayList<>();
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            cur.add(nums[i]);
            for (int j = i + 1; j < N - 2; j++) {
                if(j > i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                cur.add(nums[j]);
                for (int x = j + 1; x < N - 1; x++) {
                    if(x > j+1 && nums[x] == nums[x-1]){
                        continue;
                    }
                    cur.add(nums[x]);
                    for (int y = x + 1; y < N; y++) {
                        if(y > x+1 && nums[y] == nums[y-1]){
                            continue;
                        }
                        if(cur.size() == 4){
                            process(target,cur,ans);
                            cur.remove(3);
                        }
                        cur.add(nums[y]);
                    }
                    if(cur.size() == 4){
                        process(target,cur,ans);
                        cur.remove(3);
                        cur.remove(2);
                    }
                }
                cur.remove(1);
            }
        }


        return new ArrayList<>(ans);
    }


    public static void process(int target, List<Integer> list, Set<List<Integer>> ans) {
        List<Integer> temp = new ArrayList<>(list);
        temp.sort(Comparator.comparingInt(a -> a));
        int sum = list.stream().reduce(Integer::sum).orElse(Integer.MIN_VALUE);
        if (sum == target) {
            ans.add(temp);
        }
    }


    //1234 1235 1236 1245 1246 1345 1346 1456
    public static void main(String[] args) {
        int[] nums = {1000000000,1000000000,1000000000,1000000000 };
        int target = -294967296;
        //List<List<Integer>> lists1 = fourSum(nums, target);
        List<List<Integer>> lists2 = fourSum1(nums, target);
//        for (List<Integer> list : lists1) {
//            for (Integer cur : list) {
//                System.out.print(cur + " ");
//            }
//            System.out.println();
//        }

        System.out.println("++++++++++++");
        for (List<Integer> list : lists2) {
            for (Integer cur : list) {
                System.out.print(cur + " ");
            }
            System.out.println();
        }
    }


}
