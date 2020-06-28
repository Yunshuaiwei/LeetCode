package day17;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/6/26 20:20
 * @Version
 **/
public class Solution1 {
    public static void main(String[] args) {
        Solution1 s = new Solution1();
        String m = s.multiply("999", "999");
        System.out.println(m);
    }

    public String multiply(String num1, String num2) {
        //若有一个字符串为0则直接返回
        if (num1.charAt(0) == '0' || num2.charAt(0) == '0') {
            return String.valueOf(0);
        }
        //若num1的长度小于num2则交换，用num1做被乘数，num2做乘数
        if (num1.length() < num2.length()) {
            String a = num1;
            num1 = num2;
            num2 = a;
        }
        //保存乘数num2的下标
        int index2 = num2.length() - 1;
        //保存进位
        int flag = 0;
        //保存结果
        String result = "";
        while (index2 != -1) {
            //从乘数中取一个数字
            int c = num2.charAt(index2--) - 48;
            //保存计算过程中的临时值
            StringBuilder tmp = new StringBuilder();
            for (int i = num1.length() - 1; i >= 0; i--) {
                //从被乘数中取一个数
                int b = num1.charAt(i) - 48;
                //乘数和被乘数中两个数字相乘并加上进位
                int num = b * c + flag;
                flag = 0;
                if (num < 10) {
                    //插入临时结果中
                    tmp.insert(0, num);
                } else {
                    //改变进位
                    flag = num / 10;
                    tmp.insert(0, num % 10);
                }
            }
            //若有多余的进位则插入tmp首位
            if (flag != 0) {
                tmp.insert(0, flag);
                flag = 0;
            }
            //在临时结果集末尾插入0
            for (int i = 0; i < num2.length() - (index2 + 2); i++) {
                tmp.append(0);
            }
            //中间的临时结果求和并返回
            result = sum(result, tmp.toString());
        }
        return result;
    }

    /**
     * 字符串求和
     * @Param [num1, num2]
     * @return java.lang.String
     **/
    private String sum(String num1, String num2) {
        int indexA = num1.length() - 1;
        int indexB = num2.length() - 1;
        int flag = 0;
        StringBuilder result = new StringBuilder();
        while (indexA > -1 && indexB > -1) {
            int c1 = num1.charAt(indexA--) - 48;
            int c2 = num2.charAt(indexB--) - 48;
            int sum = c1 + c2 + flag;
            flag = 0;
            if (sum < 10) {
                result.insert(0, String.valueOf(sum));
            } else {
                flag = sum / 10;
                result.insert(0, String.valueOf(sum % 10));
            }
        }
        if (indexA == -1 && indexB == -1) {
            if (flag != 0) {
                result.insert(0, String.valueOf(flag));
                return result.toString();
            }
        } else if (indexA != -1) {
            while (indexA != -1) {
                int c = num1.charAt(indexA--) - 48;
                int sum = c + flag;
                flag = 0;
                if (sum < 10) {
                    result.insert(0, String.valueOf(sum));
                } else {
                    flag = sum / 10;
                    result.insert(0, String.valueOf(sum % 10));
                }
            }
            if (flag != 0) {
                result.insert(0, String.valueOf(flag));
                return result.toString();
            }
        } else {
            while (indexB != -1) {
                int c = num2.charAt(indexB--) - 48;
                int sum = c + flag;
                flag = 0;
                if (sum < 10) {
                    result.insert(0, String.valueOf(sum));
                } else {
                    flag = sum / 10;
                    result.insert(0, String.valueOf(sum % 10));
                }
            }
            if (flag != 0) {
                result.insert(0, String.valueOf(flag));
                return result.toString();
            }
        }
        return result.toString();
    }
}
