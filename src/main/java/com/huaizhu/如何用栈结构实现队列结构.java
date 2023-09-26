package com.huaizhu;

import java.util.Stack;

/**
 * 栈结构是一个黑盒
 */
public class 如何用栈结构实现队列结构 {


    public static class TwoStashQueue{
        public Stack<Integer> stackPush;
        public Stack<Integer> stackPop;

        public TwoStashQueue(){
            stackPush = new Stack<Integer>();
            stackPop = new Stack<Integer>();
        }

        //push栈向pop栈倒入数据
        public void pushToPop(){
            if(stackPop.isEmpty()){
                while (!stackPush.isEmpty()){
                    stackPop.push(stackPush.pop());
                }
            }
        }

        public void add(int pushInt){
            stackPush.push(pushInt);
            pushToPop();
        }

        public int poll(){
            if(stackPush.isEmpty() && stackPop.isEmpty()){
              throw new RuntimeException("queue is empty");
            }
            pushToPop();
            return stackPop.pop();
        }

    }

}
