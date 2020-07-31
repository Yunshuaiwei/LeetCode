package offer.day07;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/31 20:19
 * @Version
 **/
public class Solution1 {
    public static void main(String[] args) {
        Solution1 s = new Solution1();
        double v = s.myPow(2.0000, -2);
        System.out.println(v);
    }

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n >= 1) {
            if ((n % 2) == 0) {
                // 分治思想：分
                double square = myPow(x, n / 2);
                // 分治思想：合，下面同理
                return square * square;
            } else {
                // 是奇数的时候
                double square = myPow(x, (n - 1) / 2);
                return square * square * x;
            }
        }
        return 1 / x * myPow(1 / x, -n - 1);
    }
}
