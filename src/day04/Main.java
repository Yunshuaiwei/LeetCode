package day04;

import java.util.ArrayList;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/5/9 17:48
 * @Version
 **/
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int i = s.lengthOfLongestSubstring("dvdf");
        System.out.println(i);
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s.length();
        }
        ArrayList<Character> list = new ArrayList<>();
        list.add(s.charAt(0));
        boolean flag = true;
        int result = 1;
        int index = 1;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            for (int j = 0; j < list.size(); j++) {
                if (c == list.get(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(c);
            } else {
                if (list.size() > result) {
                    result = list.size();
                }
                list.clear();
                list.add(s.charAt(index));
                i = index;
                index++;
            }
            flag = true;
        }
        if (list.size() > result) {
            return list.size();
        } else {
            return result;
        }
    }
}