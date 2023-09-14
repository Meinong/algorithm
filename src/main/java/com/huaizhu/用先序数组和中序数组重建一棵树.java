package com.huaizhu;

import java.util.HashMap;

/**
 * 先序数组：【1，2，4，5，3，6，7】
 * 中序数组：【4, 2,5, 1, 6, 3, 7】
 */
public class 用先序数组和中序数组重建一棵树 {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode buildTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length != in.length) {
            return null;
        }

        HashMap<Integer, Integer> valueIndexMap = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            valueIndexMap.put(in[i], i);
        }

        return f(pre, 0, pre.length - 1, in, 0, in.length - 1, valueIndexMap);
    }

    public static TreeNode f(int[] pre, int L1, int R1, int[] in, int L2, int R2,
                             HashMap<Integer, Integer> valueIndexMap) {
        if (L1 > R1) {
            return null;
        }
        TreeNode head = new TreeNode(pre[L1]);
        if (L1 == R1) {
            return head;
        }

        int find = valueIndexMap.get(pre[L1]);
        head.left = f(pre, L1 + 1, L1 + find - L2, in, L2, find - 1, valueIndexMap);
        head.right = f(pre, L1 + find - L2 + 1, R1, in, find + 1, R2, valueIndexMap);
        return head;
    }

}
