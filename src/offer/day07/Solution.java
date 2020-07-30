package offer.day07;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/30 21:59
 * @Version
 **/
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int i = s.hammingWeight(128);
        System.out.println(i);
    }

    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 1; i <= 32; i++) {
            res += n & 1;
            n = n >> 1;
        }
        return res;
    }
}
