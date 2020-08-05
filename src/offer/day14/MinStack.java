package offer.day14;

import java.util.Stack;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/8/4 16:03
 * @Version
 **/
public class MinStack {
    Stack<Integer> numStack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();

    public MinStack() {

    }

    public void push(int x) {
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            if (minStack.peek() >= x) {
                minStack.push(x);
            }
        }
        numStack.push(x);
    }

    public void pop() {
        if (numStack.peek().equals(minStack.peek())) {
            numStack.pop();
            minStack.pop();
        } else {
            numStack.pop();
        }
    }

    public int top() {
        if (numStack.isEmpty()) {
            return -1;
        } else {
            return numStack.peek();
        }
    }

    public int min() {
        if (minStack.isEmpty()) {
            return -1;
        } else {
            return minStack.peek();
        }
    }
}
