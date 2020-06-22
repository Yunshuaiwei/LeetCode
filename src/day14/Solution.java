package day14;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/6/22 15:05
 * @Version
 **/
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] strs = new String[]{"", ""};
        String res = s.longestCommonPrefix(strs);
        System.out.println(res);
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String result = strs[0];
        //左指针永远指向0
        int l = 0;
        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];
            //右指针用于记录最长匹配到的字符个数
            int r = 0;
            //排除取到的为空字符的情况，建议不要放在while循环中，这样会影响效率
            if (result.length() != 0 && str.length() != 0) {
                while (result.charAt(r) == str.charAt(r)) {
                    r++;
                    if (r == result.length() || r == str.length()) {
                        break;
                    }
                }
            }
            //当r为0说明没有匹配到字符，则可以直接返回
            if (r == 0) {
                return "";
            }
            //每次截取所匹配到的字符
            result = result.substring(l, r);
        }
        return result;
    }
}
