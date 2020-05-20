package day08;

import java.util.HashSet;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/5/20 14:25
 * @Version
 **/
public class Solution {
    public static void main(String[] args) {

    }

    public boolean isHappy(int n) {
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        String s = "" + n;
        int num = 0;
        HashSet<Integer> set = new HashSet<>();
        while (true) {
            for (int i = 0; i < s.length(); i++) {
                int a = s.charAt(i) - 48;
                num += (int) Math.pow(a, 2);
            }
            if (num == 1) {
                return true;
            }
            if (num == 0) {
                return false;
            }
            if (set.contains(num)) {
                return false;
            } else {
                set.add(num);
            }
            s = "" + num;
            num = 0;
        }
    }
}
