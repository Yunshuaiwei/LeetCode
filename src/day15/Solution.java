package day15;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/6/24 17:05
 * @Version
 **/
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int num = s.reverse(1534236469);
        System.out.println(num);
    }

    public int reverse(int x) {
        long result = 0;
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        while (x != 0) {
            result = (result + x % 10) * 10;
            x = x / 10;
        }
        result = result / 10;
        if (result >= max || result <= min) {
            return 0;
        }
        return (int) result;
    }
}
