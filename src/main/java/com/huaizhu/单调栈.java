package com.huaizhu;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 单调栈 {

    /**
     * 返回数组中某位置左边离他最小的数，右边离他最小的数
     * 思路：设计一个栈 从栈底到栈顶 是从小到大的
     * 当将要压力一个数时，如果将要压入的一个数小于栈顶的数，那么此时弹出栈顶的数 ，将要压入的数 是 弹出数的最右边离他最近的最小的数，下一个将要弹出的数，是弹出数最左边离他最小的数，
     * 之后 再比较栈顶和将要压入的数，如果还是小于栈顶 重复上面的过程，如果大于这压入栈顶
     * 最后 无数需要压入栈顶时，此时一次弹出栈内的数据，最右边的离他最小的数不存在(-1表示)
     */

    /**
     * return int[][] ==>{
     *
     *     0:{-1,1} //0位置 左边 和 右边的位置
     *
     *
     *
     * }
     * @param arr
     * @return
     */
    //当前版本是数组中无重复值
    public static int[][] test(int[] arr){
        int[][] res = new int[arr.length][2];
        Stack<Integer> stack = new Stack<>();// 存的是位置
        for(int i = 0;i< arr.length;i++){
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                Integer popIndex = stack.pop();
                res[popIndex][0] = stack.isEmpty() ? -1 : stack.peek();
                res[popIndex][1] = i;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()){
            Integer popIndex = stack.pop();
            res[popIndex][0] = stack.isEmpty() ? -1 : stack.peek();
            res[popIndex][1] = -1;
        }
        return res;
    }

    //支持重复值
    public static int[][] test1(int[] arr){
        int[][] res = new int[arr.length][2];
        Stack<List<Integer>> stack = new Stack<>();// 存的是位置
        for(int i = 0;i< arr.length;i++){
            while (!stack.isEmpty() && arr[stack.peek().get(0)] > arr[i]){
                List<Integer> popIndexList = stack.pop();
                for (Integer index:popIndexList){
                    res[index][0] = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size()-1);
                    res[index][1] = i;
                }
            }
            if(!stack.isEmpty() && arr[stack.peek().get(0)] == i){
                stack.peek().add(i);
            }else{
                List<Integer> indexList = new ArrayList<>();
                indexList.add(i);
                stack.push(indexList);
            }
        }

        while (!stack.isEmpty()){
            List<Integer> popIndexList = stack.pop();
            for (Integer index:popIndexList){
                res[index][0] = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size()-1);
                res[index][1] = -1;
            }
        }
        return res;
    }

    /**
     * 题目二： 给定一个二维数组matrix,其中的值不是0就是1
     * 返回全部由1组成的最大子矩形，内部有多少个1
     */
}
