package day11;

import java.util.Stack;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/5/26 17:10
 * @Version
 **/
public class Solution {

    public boolean isValid(String s) {
        //题目描述，字符串为空返回true
        if (s == null) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        //遍历字符串
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //若c是左括号则入栈
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
            } else {
                //若栈为空则说明匹配到了一个右括号且没有左括号与其匹配，则直接返回false
                if (stack.isEmpty()) {
                    return false;
                } else {
                    //取栈顶元素
                    Character p = stack.peek();
                    //判断是否匹配成功，若成功则pop栈顶元素
                    if ((p == '{' && c == '}') || (p == '(' && c == ')') || (p == '[' && c == ']')) {
                        stack.pop();
                    } else {
                        //匹配失败则直接返回false
                        return false;
                    }
                }
            }
        }
        //若栈为空则说明所有括号都匹配成功则返货true，否则返回false，即存在左括号或由括号没有匹配项
        return stack.isEmpty();
    }
}
