package com.huaizhu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class IndexTree和AC自动机 {


    /**
     * 问1：tree 数组的每个位置 是原数组中那些位置的和？
     * 解1: tree[4] ： 4== 0100 ==> 0000+1==0001~0100 其中 0001 是 将0100最右边的1去掉之后再加1得到 所以tree[4]   = 原数组{1~4}的和
     *      tree[3]:  3==011 ==> 010+1==011~011  所以tree[3]   = 原数组{3~3}的和
     * 问2:  求原数组中1-10的和
     * 解： 10 == 01010 (tree[10] == (9-10)(01001-01010)的和)
     * 1-10 的和 = tree[10] + (01000)tree[8](将01001最右边的1抹掉) + (00000)tree[0]
     * (减掉最右边的1)
     *
     *
     *
     *
     * 问3: 将原数组中第3个数的值加上某个数，那么 需要变动tree 数组中的那些位置
     * 解： 3 == 011
     * 第一个位置 是 011
     * 第二个位置： 011+001 = 0100 = 4
     * 第三个位置： 0100+0100 = 1000 = 8
     * 第四个位置： 1000+1000 = 10000 = 16
     * 。。。。 以此类推（从右到左某个位置的1 + 000 某个位置的1 000）
     * (加上最右边的1)
     */

    /**
     * indexTree
     * 下标从1 开始
     */

    public static class IndexTree {
        private int[] tree;
        private int N;

        //0位置不用
        public IndexTree(int size) {
            N = size;
            tree = new int[N + 1];
        }

        public int sum(int index) {
            int ret = 0;
            while (index > 0) {
                ret += tree[index];
                index -= index & -index;
            }
            return ret;
        }


        /**
         * index & -index: 提取出index最右侧的1出来
         * index: 0011001000
         * -index == ~index + 1 = 1100110111+1 = 1100111000
         * index & -index : 0000001000
         */
        public void add(int index, int d) {
            while (index <= N) {
                tree[index] += d;
                index += index & -index;
            }
        }
    }

    /**
     * AC 自动机
     */

    //前缀树的节点
    public static class Node {
        //如果一个node,end 为空，不是结尾
        //如果end 不为空，表示这个点是某个字符串的结尾，end 的值就是这个字符串
        public String end;
        //只有在上面的end变量不为空的时候，endUse 才有意义
        //表示，这个字符串之前有没有加入过答案
        public boolean enduse;
        public Node fail;

        public Node[] nexts;

        public Node() {
            enduse = false;
            end = null;
            fail = null;
            nexts = new Node[26];//26个字母
        }
    }

    public static class AcAutomation {
        private Node root;

        public AcAutomation() {
            root = new Node();
        }

        //将s字符串的敏感词挂在前缀树上
        public void insert(String s) {
            char[] str = s.toCharArray();
            Node cur = root;
            int index = 0;
            for (int i = 0; i < str.length; i++) {
                index = str[i] - 'a';
                if (cur.nexts[index] == null) {
                    Node next = new Node();
                    cur.nexts[index] = next;
                }
                cur = cur.nexts[index];
            }
            cur.end = s;
        }

        //构建一个fail 指针
        public void build() {
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            Node cur = null;
            Node cfail = null;
            while (!queue.isEmpty()) {
                //弹出节点的时候，设置好子节点的fail 指针
                cur = queue.poll();
                for (int i = 0; i < 26; i++) {
                    if (cur.nexts[i] != null) {
                        //先将cur 孩子的fail 指针设置成root
                        // 接下来如果找到fail 指针在设置成具体的值，如果没找到那么fail 指针就是指向root
                        cur.nexts[i].fail = root;

                        cfail = cur.fail; //cur的fail指针
                        while (cfail != null) {
                            if (cfail.nexts[i] != null) {
                                cur.nexts[i].fail = cfail.nexts[i];
                                break;
                            }
                            cfail = cfail.fail;
                        }
                        queue.add(cur.nexts[i]);
                    }
                }
            }
        }

        // eg: "abcf"
        //      "bcd"
        //      "cd"
        //      "b"


        //content 是大文章
        public List<String> containWords(String content) {
            char[] str = content.toCharArray();
            Node cur = root;
            Node follow = null;
            int index = 0;
            List<String> ans = new ArrayList<>();
            for (int i = 0; i < str.length; i++) {
                index = str[index] - 'a';

                //如果当前没有路时，跳到fail 指针
                while (cur.nexts[index] == null && cur != root) {
                    cur = cur.fail;
                }

                //当前cur 存在index 的路
                //当前cur 不存在当前index的路 并且 来到了root 位置
                //以上两种可能性
                cur = cur.nexts[index] != null ? cur.nexts[index] : root;
                follow = cur;
                while (follow != root) {
                    if (follow.enduse) {
                        break;
                    }
                    if (follow.end != null) {
                        ans.add(follow.end);
                        follow.enduse = true;
                    }
                    follow = follow.fail;
                }

            }

            return ans;
        }

    }

}
