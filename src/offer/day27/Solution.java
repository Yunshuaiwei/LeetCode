package offer.day27;

import java.util.Arrays;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/8/24 16:17
 * @Version
 **/
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int[] ints = s.maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(ints));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 1) {
            return new int[]{};
        }
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = max(nums, i, i + k - 1);

        }
        return res;
    }

    /**
     * @return int
     * @Param
     * @Date 10:22 2020/8/25
     * @Description: 得到每个子区间的最大值
     **/
    private int max(int[] nums, int l, int r) {
        int res = nums[l];
        for (int i = l; i <= r; i++) {
            if (nums[i] >= res) {
                res = nums[i];
            }
        }
        return res;
    }
}
