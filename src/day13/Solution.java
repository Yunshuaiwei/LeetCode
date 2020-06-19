package day13;

import java.util.Stack;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/6/19 14:49
 * @Version
 **/
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        String s1 = s.removeDuplicateLetters("bbcaac");
        System.out.println(s1);
    }

    public String removeDuplicateLetters(String s) {
        if (s == null) {//当字符串为空时，直接返回
            return null;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //当栈中存在该元素时，则跳出本次循环
            if (stack.contains(c)) {
                continue;
            }
            if (!stack.isEmpty()) {
                //循环判断，当栈顶元素在字符串索引i之后的位置也存在时，则可以将该栈顶元素出栈
                while (!stack.isEmpty() && stack.peek() > c) {
                    boolean flag = false;
                    for (int j = i + 1; j < s.length(); j++) {
                        if (s.charAt(j) == stack.peek()) {
                            //当字符串索引i之后存在该栈顶元素时，则该栈顶元素出栈
                            //将标志位改为true
                            flag = true;
                            stack.pop();
                            break;
                        }
                    }
                    //当标志位为false时，即字符串索引i之后不存在栈顶元素，则退出本次循环
                    if (!flag) {
                        break;
                    }
                }
            }
            //将该元素入栈
            stack.push(c);
        }
        String result = "";
        for (int i = 0; i < stack.size(); i++) {
            result += stack.get(i);
        }
        return result;
    }
}
