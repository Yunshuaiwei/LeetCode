package day12;

import java.util.Stack;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/6/2 14:24
 * @Version
 **/
public class Solution {
}

class MinStack {

    /**
     * initialize your data structure here.
     */
    public MinStack() {
    }

    Stack<Integer> stackNum = new Stack<>();
    Stack<Integer> stackMin = new Stack<>();

    public void push(int x) {
        stackNum.push(x);
        if (stackMin.empty()) {
            stackMin.push(x);
            return;
        }
        if (stackMin.peek() >= x) {
            stackMin.push(x);
        }
    }

    public void pop() {
        if (stackNum.peek().equals(stackMin.peek())) {
            stackNum.pop();
            stackMin.pop();
        } else {
            stackNum.pop();
        }
    }

    public int top() {
        if (!stackNum.empty()) {
            return stackNum.peek();
        }
        return -1;
    }

    public int getMin() {
        if (!stackMin.empty()) {
            return stackMin.peek();
        }
        return -1;
    }
}