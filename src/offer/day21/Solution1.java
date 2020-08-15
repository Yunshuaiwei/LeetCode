package offer.day21;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/8/12 8:53
 * @Version
 **/
public class Solution1 {
    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int i = s.findNthDigit(3);
        System.out.println(i);
    }

    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) {
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit;
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }

}
