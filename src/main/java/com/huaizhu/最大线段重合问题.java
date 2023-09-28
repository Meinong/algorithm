package com.huaizhu;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 最大线段重合问题 {

    public static class Line{
        public Integer start;
        public Integer end;

        public Line(Integer start, Integer end) {
            this.start = start;
            this.end = end;
        }
    }

    public static class StartCompare implements Comparator<Line> {

        @Override
        public int compare(Line o1,Line o2) {
            return o1.start- o2.start;
        }
    }

    public static void main(String[] args) {

    }

    public static int maxCover(int[][] m){
        Line[] lines = new Line[m.length];
        for (int i=0;i<m.length;i++){
            lines[i] = new Line(m[i][0],m[i][1]);
        }
        Arrays.sort(lines,new StartCompare());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int max = 0;
        for (int i =0;i<lines.length;i++){
            while (!priorityQueue.isEmpty() && priorityQueue.peek() <= lines[i].start){
                priorityQueue.poll();
            }
            priorityQueue.add(lines[i].end);
            max = Math.max(max,priorityQueue.size());
        }

        return max;
    }

}
