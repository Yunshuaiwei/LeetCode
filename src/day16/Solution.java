package day16;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/6/25 14:47
 * @Version
 **/
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int i = s.myAtoi(" -42");
        System.out.println(i);
    }

    public int myAtoi(String str) {
        //去除首位的空格
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        //若非空格的第一个字符是无效字符则直接返回0
        if (str.charAt(0) != '-' && str.charAt(0) != '+' && (str.charAt(0) < 48 || str.charAt(0) > 57)) {
            return 0;
        }
        char c = 0;
        //若第一个字符是正负号则去除并保存
        if (str.charAt(0) == '-' || str.charAt(0) == '+') {
            c = str.charAt(0);
            str = str.substring(1, str.length());
            if (str.length() == 0) {
                return 0;
            }
        }
        //去除字符串起始有多个+-号的情况
        if (str.charAt(0) < 48 || str.charAt(0) > 57) {
            return 0;
        }
        int index = 0;
        //去除以0开头的字符串
        while (index < str.length() - 1 && str.charAt(index) - 48 == 0) {
            index++;
        }
        str = str.substring(index, str.length());
        String tmp = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < 48 || str.charAt(i) > 57) {
                break;
            } else {
                tmp += str.charAt(i);
            }
        }
        if (tmp.length() > 0) {
            if (c != 0) {
                //拼串，将符号拼到索引0的位置
                tmp = c + "" + tmp;
            }
        } else {
            return 0;
        }
        if (tmp.length() > 11) {
            if (tmp.charAt(0) == '-') {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }
        if (Long.parseLong(tmp) >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else {
            return (int) Math.max(Long.parseLong(tmp), -2147483648);
        }
    }
}
