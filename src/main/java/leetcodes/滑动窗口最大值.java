package leetcodes;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回 滑动窗口中的最大值 。
 * <p>
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 */
public class 滑动窗口最大值 {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        if (nums.length < k) {
            return ans;
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o2[0]-o1[0] : o2[1]-o1[1];
            }
        });
        for (int i = 0;i<k;i++){
            int[] cur = new int[]{nums[i],i};
            queue.offer(cur);
        }

        int L = 1;
        int R = k;
        int N = nums.length;
        ans[0] = queue.peek()[0];
        int i = 1;
        while (R < N) {
            queue.add(new int[]{nums[R],R});
            //[1,3,-1,-3,5,3,6,7]
            while (queue.peek()[1] < L){
                queue.poll();
            }
            int[] max = queue.peek();
            ans[i] = max[0];
            i++;
            L++;
            R++;
        }
        return ans;
    }




    public static void main(String[] args) {
        int[] nums = {1,-9,8,-6,6,4,0,5};
        int k = 4;
        int[] ints = maxSlidingWindow(nums, k);
        for (int i : ints) {
            System.out.print(i + " ");
        }
        System.out.println();
    }


}
