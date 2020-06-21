package day14;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/6/21 16:33
 * @Version
 **/
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        String s1 = s.convert("ABC", 4);
        System.out.println("ABC".equals(s1));
    }

    public String convert(String s, int numRows) {
        if (s == null || numRows < 2 || s.length() < 3) {
            return s;
        }
        String[] arr = new String[numRows];
        int index = 0;
        //用于记录字符串s的索引
        int sIndex = 0;
        while (true) {
            for (int i = index; i < numRows && sIndex < s.length(); i++) {
                arr[i] += s.charAt(sIndex++);
                index++;
            }
            if (sIndex >= s.length()) {
                break;
            }
            index--;
            for (int i = index - 1; i > 0 && sIndex < s.length(); i--) {
                arr[i] += s.charAt(sIndex++);
                index--;
            }
            index--;
            if (sIndex >= s.length()) {
                break;
            }
        }
        String result = "";
        for (int i = 0; i < numRows; i++) {
            if (arr[i] != null) {
                //截取字符串，去掉前面索引0-4：null
                result += arr[i].substring(4, arr[i].length());
            }
        }
        return result;
    }
}
