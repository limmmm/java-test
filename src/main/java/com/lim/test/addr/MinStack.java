package com.lim.test.addr;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author lim

 * @since 2020-12-08
 */

/**
 * 使用双栈，一个保存实际栈数据，一个保存对应的最小值
 */
public class MinStack {

    /** 栈数据 */
    private Stack<Integer> stack;

    /** 对应的最小数 */
    private Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            minStack.push(x < minStack.peek() ? x : minStack.peek());
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

}
