package offer.day20;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/8/11 19:09
 * @Version
 **/
public class Solution1 {
    public int maxSubArray(int[] nums) {
        int dp0 = nums[0];
        int dp1;
        //保存最终结果
        int res = dp0;
        for (int i = 1; i < nums.length; i++) {
            dp1 = Math.max(nums[i], nums[i] + dp0);
            dp0 = dp1;
            res = Math.max(res, dp1);
        }
        return res;
    }
}
