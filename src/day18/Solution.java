package day18;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/6/28 16:04
 * @Version
 **/
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int i = s.addDigits(38);
        System.out.println(i);
    }

    /**
     * 递归实现
     *
     * @return int
     * @Param [num]
     **/
    public int addDigits(int num) {
        //小于10则直接返回
        if (num < 10) {
            return num;
        }
        int n = 0;
        while (num != 0) {
            //每次从个位取数字
            n += num % 10;
            //去掉一位数
            num = num / 10;
        }
        //递归求下一个数
        return addDigits(n);
    }

    /**
     * 循环实现
     *
     * @return int
     * @Param [num]
     **/
    public int addDigits2(int num) {
        while (true) {
            int n = 0;
            while (num != 0) {
                //每次从个位取数字
                n += num % 10;
                //去掉一位数
                num = num / 10;
            }
            num = n;
            if (num < 10) {
                return num;
            }
        }
    }
}
