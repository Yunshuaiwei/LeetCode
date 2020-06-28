package day17;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/6/28 14:55
 * @Version
 **/
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int i = s.trailingZeroes(1808548329);
        System.out.println(i);
    }

    /**
     * 解法一
     *
     * @return int
     * @Param [n]
     **/
    public int trailingZeroes1(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int num = i;
            while (num > 0) {
                if (num % 5 == 0) {
                    //统计一个数包含5的个数
                    count++;
                    //举例，当25/5之后，得到5，即原本可写成5x5，第一次取模count++，
                    //当除去5后，再去判断，count会再次加1，从而得到25可拆为两个5
                    num = num / 5;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    /**
     * 解法二
     *
     * @return int
     * @Param [n]
     **/
    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n = n / 5;
        }
        return count;
    }
}
