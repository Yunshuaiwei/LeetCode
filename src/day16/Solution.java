package day16;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/6/25 16:45
 * @Version
 **/
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        boolean result = s.isPalindrome(2321);
        System.out.println(result);
    }

    public boolean isPalindrome(int x) {
        //排除负数
        if (x < 0) {
            return false;
        }
        //将int转为字符串
        String res = String.valueOf(x);
        //一位数则直接返回true
        if (res.length() == 1) {
            return true;
        }
        //右指针
        int r = res.length() - 1;
        //左右指针每次可取出左右两个字符并进行比较
        for (int l = 0; l < res.length() / 2; l++) {
            if (res.charAt(l) != res.charAt(r)) {
                return false;
            }
            r--;
        }
        return true;
    }
}
