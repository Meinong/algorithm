package com.huaizhu;

import java.util.HashSet;

public class 有序表题目 {
    /**
     * 题目一： 给定一个数组arr,和两个整数a和b(a<=b)
     * 求arr 中有多少个子数组，累加和在[a,b]这个范围上
     * 返回达标的子数组数量
     */

    //[10,20]
    // 5,5,5,8,3
    //sum = 0  5  10,15,23,28
    //25--->[3,13]
    // < 3  < 14
    public static int countRangeSum(int[] nums, int lower, int upper) {
        //当前是个黑盒，加入数字(前缀和)，不去重，可以接受重复数字
        //< num 有几个数？
        SizeBalanceTreeSet treeSet = new SizeBalanceTreeSet();
        long sum = 0;
        int ans = 0;
        treeSet.add(0);
        for (int num : nums) {
            sum += num;
            long a = treeSet.lesskeySize(sum - lower + 1);
            long b = treeSet.lesskeySize(sum - upper);
            ans += a - b;
            treeSet.add(sum);
        }
        return ans;
    }

    public static class SBTNode {
        public long key;
        public SBTNode l;
        public SBTNode r;
        public long size; //不同key 的size;
        public long all;//总的size;

        public SBTNode(long k) {
            key = k;
            size = 1;
            all = 1;
        }
    }

    public static class SizeBalanceTreeSet {
        private SBTNode root;
        private HashSet<Long> set = new HashSet<>();

        private SBTNode rightRotate(SBTNode cur) {
            long same = cur.all - (cur.l != null ? cur.l.all : 0) - (cur.r != null ? cur.r.all : 0);
            SBTNode leftNode = cur.l;
            cur.l = leftNode.r;
            leftNode.r = cur;
            leftNode.size = cur.size;
            cur.size = (cur.l != null ? cur.l.size : 0) - (cur.r != null ? cur.r.size : 0);
            leftNode.all = cur.all;
            cur.all = (cur.l != null ? cur.l.all : 0) + (cur.r != null ? cur.r.all : 0) + same;
            return leftNode;
        }


        private SBTNode leftRotate(SBTNode cur) {
            long same = cur.all - (cur.l != null ? cur.l.all : 0) - (cur.r != null ? cur.r.all : 0);
            SBTNode rightNode = cur.r;
            cur.r = rightNode.l;
            rightNode.l = cur;
            rightNode.size = cur.size;
            cur.size = (cur.l != null ? cur.l.size : 0) - (cur.r != null ? cur.r.size : 0);
            rightNode.all = cur.all;
            cur.all = (cur.l != null ? cur.l.all : 0) + (cur.r != null ? cur.r.all : 0) + same;
            return rightNode;
        }

        private SBTNode maintain(SBTNode cur) {
            if (cur == null) {
                return null;
            }

            long leftSize = cur.l != null ? cur.l.size : 0;
            long leftLeftSize = cur.l.l != null ? cur.l.l.size : 0;
            long leftRightSize = cur.l.r != null ? cur.l.r.size : 0;

            long rightSize = cur.r != null ? cur.r.size : 0;
            long rightLeftSize = cur.r.l != null ? cur.r.l.size : 0;
            long rightRightSize = cur.r.r != null ? cur.r.r.size : 0;

            if (leftLeftSize > rightSize) {
                //LL
                cur = rightRotate(cur);
                cur.r = maintain(cur.r);
                cur = maintain(cur);
            } else if (leftRightSize > rightSize) {
                //LR
                cur.l = leftRotate(cur.l);
                cur = rightRotate(cur);
                cur.l = maintain(cur.l);
                cur.r = maintain(cur.r);
                cur = maintain(cur);
            } else if (rightLeftSize > leftSize) {
                //RL
                cur.r = rightRotate(cur.r);
                cur = leftRotate(cur);
                cur.l = maintain(cur.l);
                cur.r = maintain(cur.r);
                cur = maintain(cur);
            } else if (rightRightSize > leftSize) {
                //RR
                cur = leftRotate(cur);
                cur.l = maintain(cur.l);
                cur = maintain(cur);
            }

            return cur;
        }

        private SBTNode add(SBTNode cur, long key, boolean contains) {
            if (cur == null) {
                return new SBTNode(key);
            } else {
                cur.all++;
                if (key == cur.key) {
                    return cur;
                } else {
                    if (!contains) {  //当这个key 不存在时
                        cur.size++;
                    }
                    if (key < cur.key) {
                        cur.l = add(cur.l, key, contains);
                    } else {
                        cur.r = add(cur.r, key, contains);
                    }
                }
                return maintain(cur);
            }
        }

        private SBTNode delete(SBTNode cur, long key){
            if(set.contains(key)){
                cur.size --;
                cur.all--;
                if(key < cur.key ){
                    cur.l = delete(cur.l,key);
                }else if (key > cur.key){
                    cur.r = delete(cur.r,key);
                }else{
                    if(cur.l ==null && cur.r ==null){
                        cur = null;
                    }else if(cur.l != null && cur.r == null){
                        cur = cur.l;
                    }else if(cur.r != null && cur.l == null){
                        cur = cur.r;
                    }else{
                        SBTNode pre = null;
                        SBTNode des = cur.r;
                        des.size--;
                        des.all --;
                        while (des.l != null){
                            pre = des;
                            des = des.l;
                            des.size--;
                            des.all --;
                        }
                        long same = des.all - (des.r != null ? des.r.all : 0);
                        if(pre != null){
                            pre.l = des.r;
                            des.r = cur.r;
                        }
                        des.l = cur.l;
                        des.size = des.l.size + (des.r == null ? 0 : des.r.size) + 1;
                        des.all = des.l.all + (des.r == null ? 0 : des.r.all) + same;
                        cur = des;
                    }
                }
                return maintain(cur);
            }
            return cur;
        }

        public void add(long sum) {
            boolean contains = set.contains(sum);
            root = add(root, sum, contains);
            set.add(sum);
        }

        public long lesskeySize(long key) {
            SBTNode cur = root;
            long ans = 0;
            while (cur != null) {
                if (key == cur.key) {
                    return ans + (cur.l != null ? cur.l.all : 0);
                } else if (key < cur.key) {
                    cur = cur.l;
                } else {
                    ans += cur.all - (cur.r != null ? cur.r.all : 0);
                    cur = cur.r;
                }
            }
            return ans;
        }
    }


    /**
     * 有一个滑动窗口
     * 1）L 是滑动窗口最左位置 ，R是滑动窗口最右位置，一开始LR 都在数组左侧
     * 2）任何一步都可能R往右动，表示某个数进了窗口
     * 3）任何一步都可能L往右动，表示某个数出了窗口
     *
     * 求每一个窗口状态的中位数
     */



}
