package offer.day05;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/29 10:37
 * @Version
 **/
public class Solution {
    public int fib(int n) {
        int a = 0;
        int b = 1;
        int num = 0;
        while (n > 1) {
            num = (a + b) % 1000000007;
            a = b;
            b = num;
            n--;
        }
        return n == 1 ? b : num;
    }
    public int numWays(int n) {
        int a = 1;
        int b = 1;
        int num = 1;
        while (n > 1) {
            num = (a + b) % 1000000007;
            a = b;
            b = num;
            n--;
        }
        return num;
    }
}
