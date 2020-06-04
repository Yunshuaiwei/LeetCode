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
        String tmp = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (c == '(') {
                stack.push(c);
            } else {
                if (c > 47 && c < 58) {
                    tmp += c;
                } else {
                    if (!tmp.equals("")) {
                        int num = Integer.parseInt(tmp);
                        list.add(num);
                        tmp = "";
                    }
                    if (c != ')') {
                        stack.push(c);
                    } else {
                        int a = list.remove(list.size() - 1);
                        while (stack.peek() != '(') {
                            Character pop = stack.pop();
                            if (pop == '+') {
                                a = (list.remove(list.size() - 1) + a);
                            } else {
                                a = (list.remove(list.size() - 1) - a);
                            }
                        }
                        stack.pop();
                        list.add(a);
                    }
                }
            }
        }
        if (!tmp.equals("")) {
            list.add(Integer.parseInt(tmp));
        }
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
