package offer.day27;

import java.util.Stack;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/8/24 15:36
 * @Version
 **/
public class Solution1 {
    public static void main(String[] args) {
        Solution1 s = new Solution1();
        String str = s.reverseWords("the sky is blue");
//        System.out.println(str);
        String s1 = s.reverseLeftWords("abcdefg", 2);
        System.out.println(s1);
    }

    public String reverseWords(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                if (!"".equals(tmp.toString())) {
                    //将单词加入栈中
                    stack.push(tmp.toString());
                }
                tmp = new StringBuilder();
            } else {
                //将字符拼接成字符串
                tmp.append(c);
            }
        }
        stack.push(tmp.toString());
        tmp = new StringBuilder();
        //从栈中取出字符串，拼接成新的字符串
        while (!stack.isEmpty()) {
            tmp.append(stack.pop()).append(" ");
        }
        return tmp.toString().trim();
    }

    public String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder(s);
        String substring = sb.substring(0, n);
        StringBuilder builder = sb.delete(0, n);
        return builder.append(substring).toString();
    }
}
