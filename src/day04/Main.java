package day04;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/5/9 17:48
 * @Version
 **/
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int i = s.lengthOfLongestSubstring("pwwkew");
        System.out.println(i);
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = 0;
        int result = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            int j = i + 1;
            char a = s.charAt(i);
            char b=' ';
            while(a!=b&&j<s.length()){
                b=s.charAt(j);
                j++;
            }
            length=j-i;
            if (length>result){
                result=length;
            }
        }
        return result;
    }
}