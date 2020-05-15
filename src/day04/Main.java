package day04;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/5/9 17:48
 * @Version
 **/
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int i = s.lengthOfLongestSubstring("ahjhkjhj");
        System.out.println(i);
    }
}

class Solution {
    public int lengthOfLongestSubstring1(String s) {
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

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s.length();
        }
        HashSet<Object> set = new HashSet<>();
        int result = 1;
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            //得到字符c
            char c = s.charAt(i);
            //判断set中是否存在
            if (set.contains(c)) {
                //保存set的长度
                if (set.size() > result) {
                    result = set.size();
                }
                //查找c在字符串s中出现的位置
                //例如abcad，当遍历到第二个a时出现重复，则删除set中保存在第一个a
                //则下一轮将在新的区间bcad中继续遍历
                for (int j = l; j < s.length(); j++) {
                    if (s.charAt(j) != c) {
                        set.remove(s.charAt(j));
                    } else {
                        l = j + 1;
                        set.remove(s.charAt(j));
                        break;
                    }

                }
                set.add(c);
            } else {//若set中不存在则加入c
                set.add(c);
            }
        }
        return Math.max(result, set.size());
    }
}