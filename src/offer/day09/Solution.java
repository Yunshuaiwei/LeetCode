package offer.day09;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/8/1 14:16
 * @Version
 **/
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        boolean number = s.isNumber("1");
        System.out.println(number);
    }

    public boolean isNumber(String s) {
        if (s.length() < 1) {
            return false;
        }
        //去掉字符串前后的空格
        s = s.trim();
        boolean isNum = false, isDot = false, is_eOrE = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //判断当前字符是否为数字
            if (c >= '0' && c <= '9') {
                isNum = true;
                //判断当前字符是否为小数点
            } else if (c == '.') {
                //小数点若已经存在或小数点前有e或E则返回false
                if (isDot || is_eOrE) {
                    return false;
                }
                isDot = true;
            } else if (c == 'e' || c == 'E') {
                //e和E不能重复出现，切前面必须使数字
                if (!isNum || is_eOrE) {
                    return false;
                }
                is_eOrE = true;
                //e和E后也必须是数字
                isNum = false;
            } else if (c == '-' || c == '+') {
                //正负号只能在第一个位置或e和E后的一个位置
                if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return isNum;
    }
}
