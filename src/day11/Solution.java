package day11;

import java.util.Stack;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/5/28 16:08
 * @Version
 **/
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int i = s.longestValidParentheses(")(");
        System.out.println(i);
    }

    public int longestValidParentheses(String s) {
        int length = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    length = Math.max(length, i - stack.peek());
                }
            }
        }
        return length;
    }
}
