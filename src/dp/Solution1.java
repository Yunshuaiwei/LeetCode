package dp;

import java.util.Arrays;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/29 22:55
 * @Version
 **/
public class Solution1 {
    public int lengthOfLIS(int[] nums) {
        int[] arr = new int[nums.length];
        int res = 0;
        Arrays.fill(arr, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    arr[i] = Math.max(arr[j] + 1, arr[i]);
                }
            }
            res = Math.max(arr[i], res);
        }
        return res;
    }
}
