package day27;

import java.util.Arrays;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/12 15:01
 * @Version
 **/
public class Solution1 {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        Solution1 s = new Solution1();
        int[] ints = s.searchRange(nums, 8);
        System.out.println(Arrays.toString(ints));
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums == null) {
            return res;
        }
        res[0] = left_bound(nums, target);
        res[1] = right_bound(nums, target);
        return res;
    }

    /**
     * @return int
     * @Param [nums, target]
     * @Date 16:17 2020/7/12
     * @Description: 找左边界
     **/
    public int left_bound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {//向左收缩
                right = mid - 1;
            }
        }
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    public int right_bound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {//向右收缩
                left = mid + 1;
            }
        }
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }
}
