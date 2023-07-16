package com.hlf.stack;

import java.util.Stack;

/**
 * 两个堆实现一个队列
 * 队列是先进先出
 * 堆事先进后出
 */
public class StackQueue {

    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    public StackQueue(){
        stackIn = new Stack();
        stackOut = new Stack();
    }

    public void push(int x){
        stackIn.push(x);
    }

    public Integer poll(){
        if (stackOut.isEmpty()){
            while (!stackIn.isEmpty()){
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.pop();
    }

    public Integer peek(){
        if (stackOut.isEmpty()){
            while (!stackIn.isEmpty()){
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.peek();
    }

    public static void main(String[] args) {
        StackQueue stackQueue = new StackQueue();
        stackQueue.push(1);
        stackQueue.push(2);
        stackQueue.push(3);
        System.out.printf(stackQueue.peek()+"");

    }
}
