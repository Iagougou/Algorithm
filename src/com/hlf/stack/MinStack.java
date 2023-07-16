package com.hlf.stack;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * 实现一个特殊的栈，再实现栈的基本功能的基础上，再实现返回栈中最小的元素的操作
 */
public class MinStack {
    private Stack<Integer> stack ;
    private Stack<Integer> minStack;

    public MinStack(){
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    /**
     * 数据线先入栈，小栈和最顶的数比较，如果大于不入小于入栈
     * @param x
     */
    public void push(int x){
        stack.push(x);
        if (minStack.isEmpty()){
            minStack.push(x);
        }else {
           minStack.push(Math.min(x,minStack.peek()));
        }
    }

    /**
     * 获取最小堆元素
     * @return
     */
    public int getMin(){
        if (minStack.isEmpty()){
            throw  new NoSuchElementException("Stack is empty ,no min value");
        }
        return  minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(5);
        minStack.push(3);
        minStack.push(10);
        minStack.push(1);
        System.out.printf(minStack.getMin()+"");
    }
}
