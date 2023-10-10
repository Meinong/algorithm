package com.huaizhu;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 题目二：
 *  一些项目要占用一个会议室宣讲，会议室不能同时容纳两个项目的宣讲
 *  给你每一个项目开始的时间和结束的时间
 *  你来安排宣讲的日程，要求会议室进行的宣讲场次最多
 *  返回最多的宣讲场次
 */
public class 贪心算法2 {



    public static class Programs{
        public int start;//开始时间
        public int end;//结束时间
    }
    public static class MyComparator implements Comparator<Programs>{

        @Override
        public int compare(Programs o1, Programs o2) {
            return o1.end- o2.end;
        }
    }

    public static int getMaxNum(Programs[] programs){
        Arrays.sort(programs,new MyComparator());
        int timeEnd = 0;
        int result = 0;
        for (Programs pr:programs){
            if(pr.start >= timeEnd){
                timeEnd = pr.end;
                result++;
            }
        }
        return result;
    }
}
