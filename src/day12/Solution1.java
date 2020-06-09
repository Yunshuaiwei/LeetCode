package day12;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/6/2 14:50
 * @Version
 **/
public class Solution1 {
    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int i = s.calculate("2-4-(8+2-6+(8+4-(1)+8-10))");
        System.out.println(i);
    }

    public int calculate(String s) {
        if (s == null) {
            return 0;
        }

        ArrayList<Integer> list = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        Stack<Character> numStack = new Stack<>();
        String tmp = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //排除空格的情况
            if (c == ' ') {
                continue;
            }
            //左括号则直接入栈
            if (c == '(') {
                stack.push(c);
            } else {
                if (c > 47 && c < 58) {
                    //多位数
                    tmp += c;
                } else {
                    if (!tmp.equals("")) {
                        int num = Integer.parseInt(tmp);
                        list.add(num);
                        tmp = "";
                    }
                    if (c != ')') {
                        stack.push(c);
                    } else {//匹配到右括号
                        while (stack.peek() != '(') {//将stack中的元素放入numStack，即倒序字符串
                            int a = list.remove(list.size() - 1);
                            numStack.push((char) a);
                            numStack.push(stack.pop());
                        }
                        int a = list.remove(list.size() - 1);
                        numStack.push((char) a);
                        int num = 0;
                        //计算numStack中表达式的结果
                        while (!numStack.isEmpty()) {
                            Character pop = numStack.pop();
                            if (pop != '+' && pop != '-') {
                                num = pop;
                                continue;
                            }
                            if (pop == '+') {
                                num += numStack.pop();
                            } else {
                                num -= numStack.pop();
                            }
                        }
                        stack.pop();
                        //将结果入栈
                        if (num < 0) {
                            stack.pop();
                            stack.push('+');
                            list.add(-num);
                        } else {
                            list.add(num);
                        }
                    }
                }
            }
        }
        if (!tmp.equals("")) {
            list.add(Integer.parseInt(tmp));
        }
        //表达式没有括号，则计算栈中表达式的值
        if (!stack.isEmpty()) {
            while (!stack.isEmpty()) {
                int a = list.remove(list.size() - 1);
                if (stack.pop() == '+') {
                    if ((!stack.isEmpty()) && stack.peek() == '-') {
                        a -= list.remove(list.size() - 1);
                        stack.pop();
                        stack.push('+');
                    } else {
                        a = list.remove(list.size() - 1) + a;
                    }

                } else {
                    a = list.remove(list.size() - 1) - a;
                }
                list.add(a);
            }
        }
        return list.remove(0);
    }
}
