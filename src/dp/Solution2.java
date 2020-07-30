package dp;

import java.util.Arrays;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/30 14:29
 * @Version
 **/
public class Solution2 {
    public static void main(String[] args) {
//        int[] arr = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        Solution s = new Solution();
//        int i = s.maxSubArray(arr);
//        System.out.println(i);

        int[] wt = new int[]{2, 1, 3};
        int[] val = new int[]{4, 2, 3};
        Solution2 s = new Solution2();
        int i = s.knapsack(4, 3, wt, val);
        System.out.println(i);
    }

    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int dp0 = nums[0];
        int dp1;
        int res = dp0;
        for (int i = 1; i < nums.length; i++) {
            dp1 = Math.max(nums[i], nums[i] + dp0);
            dp0 = dp1;
            res = Math.max(dp1, res);
        }
        return res;
    }

    public int knapsack(int W, int n, int[] wt, int[] val) {
        int[][] dp = new int[n + 1][W + 1];
        for (int[] ints : dp) {
            Arrays.fill(ints, 0);
        }
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {
                if (w - wt[i - 1] < 0) {
                    //当前背包容量不足，只能不装入
                    dp[i][w] = dp[i - 1][w];
                } else {
                    dp[i][w] = Math.max(dp[i - 1][w - wt[i - 1]] + val[i - 1],
                            dp[i - 1][w]);
                }
            }
        }
        return dp[n][W];
    }

}
