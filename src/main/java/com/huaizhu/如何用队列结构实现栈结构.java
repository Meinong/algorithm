package com.huaizhu;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列是一个黑盒
 */
public class 如何用队列结构实现栈结构 {

    public static class TwoQueueStack<T> {
        public Queue<T> queue;
        public Queue<T> help;

        public TwoQueueStack() {
            queue = new LinkedList<>();
            help = new LinkedList<>();
        }

        public void push(T value) {
            queue.offer(value);
        }

        public T poll() {
            while (queue.size() > 1) {
                help.offer(queue.poll());
            }

            T ans = queue.poll();

            Queue<T> tmp = queue;
            queue = help;
            help = tmp;
            return ans;
        }
    }
}
