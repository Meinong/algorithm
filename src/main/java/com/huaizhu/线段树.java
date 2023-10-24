package com.huaizhu;

/**
 * 当存在一个数组时，
 * 问题：需要将 1-100位置上的数 统一+6
 * 问题：需要将 1-100位置上的数 统一更新为10
 * 问题：需要查询出 1-100 位置上的数的 和
 */
public class 线段树 {

    public static class SegmentTree {
        private int MAXN;
        private int[] arr;  //为原序例的信息从0开始，但在arr里是从1开始
        private int[] sum; //模拟线段树维护区间和
        private int[] lazy; //为累加和懒惰标记
        private int[] change; //为更新的值
        private boolean[] update; //为更新懒惰标记

        public SegmentTree(int[] origin) {
            MAXN = origin.length + 1;
            arr = new int[MAXN];//arr[0] 不用，从1 开始
            for (int i = 1; i < MAXN; i++) {
                arr[i] = origin[i - 1];
            }
            sum = new int[MAXN << 2];// 4N
            lazy = new int[MAXN << 2]; // 4N
            change = new int[MAXN << 2];
            update = new boolean[MAXN << 2];
        }

        private void pushUp(int rt) {
            sum[rt] = sum[rt << 1] + sum[rt << 1 | 1]; // root = 左 + 右 ==> root = 2* root + 2*root +1
        }

        //初始化阶段，先把sum 数组 填好
        //arr[1-r] 范围上 去build 1~N
        //rt: 这个范围在sum 中的下标
        public void build(int l, int r, int rt) {
            if (l == r) {
                sum[rt] = arr[l];
                return;
            }
            int mid = (l + r) >> 1;
            build(l, mid, rt << 1);
            build(mid, r, rt << 1 | 1);
            pushUp(rt);
        }


        /**
         * 需求: 将L 到 R 位置的数 统一加 C
         * eg: l:1 r:10 rt：1
         * L: 4 R:4 C 2
         */
        public void add(int L, int R, int C,
                        int l, int r, int rt) {
            //任务如果把此时的范围全包了
            if (L <= l && r <= R) {
                sum[rt] += C * (r - l + 1);
                lazy[rt] += C;
                return;
            }
            //任务没有把此时的范围全包
            int mid = (l + r) >> 1; //5
            pushDown(rt, mid - l + 1, r - mid);

            if (L <= mid) {
                add(L, R, C, l, mid, rt << 1);
            }
            if (R > mid) {
                add(L, R, C, mid + 1, r, rt << 1 | 1);
            }
            pushUp(rt);

        }

        //需求: 将L 到 R 位置的数变成C
        public void update(int L, int R, int C,
                           int l, int r, int rt) {
            if (L <= l && r <= R) {
                update[rt] = true;
                change[rt] = C;
                sum[rt] = C * (r - l + 1);
                lazy[rt] = 0;
                return;
            }
            int mid = (l + r) >> 1; //5
            pushDown(rt, mid - l + 1, r - mid);
            if(L <= mid){
                update(L,R,C,l,mid,rt<<1);
            }
            if (R > mid) {
                add(L, R, C, mid + 1, r, rt << 1 | 1);
            }
            pushUp(rt);
        }

        private void pushDown(int rt, int ln, int rn) {
            if (update[rt]) {
                update[rt << 1] = true;
                update[rt << 1 | 1] = true;
                change[rt << 1] = change[rt];
                change[rt << 1 | 1] = change[rt];
                lazy[rt << 1] = 0;
                lazy[rt << 1 | 1] = 0;
                sum[rt << 1] = change[rt] * ln;
                sum[rt << 1 | 1] = change[rt] * rn;
                update[rt] = false;
            }
            if (lazy[rt] != 0) {
                lazy[rt << 1] += lazy[rt];
                sum[rt << 1] += lazy[rt] * ln;
                lazy[rt << 1 | 1] += lazy[rt];
                sum[rt << 1 | 1] += lazy[rt] * rn;
                lazy[rt] = 0;
            }
        }

        public long query(int L,int R,int l,int r,int rt){
            if (L <= l && r <= R) {
                return sum[rt];
            }
            int mid = (l + r) >> 1; //5
            pushDown(rt, mid - l + 1, r - mid);
            long ans = 0;
            if(L <= mid){
                ans +=query(L,R,l,mid,rt<<1);
            }
            if (R > mid) {
                ans += query(L, R, mid + 1, r, rt << 1 | 1);
            }
            return ans;
        }
    }
}
