package day28;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/15 15:51
 * @Version
 **/
public class Solution {
    public static void main(String[] args) {
        int[] arr = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        Solution s = new Solution();
        int i = s.maxSubArray(arr);
        System.out.println(i);
    }

    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}
