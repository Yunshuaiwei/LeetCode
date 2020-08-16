package offer.day26;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/8/15 15:46
 * @Version
 **/
public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int num = nums[i] + nums[j];
            if (num > target) {
                j--;
            } else if (num < target) {
                i++;
            } else {
                return new int[]{nums[i], nums[j]};
            }
        }
        return new int[0];
    }

    public int[][] findContinuousSequence(int target) {
        // 滑动窗口的左边界
        int i = 1;
        // 滑动窗口的右边界
        int j = 1;
        // 滑动窗口中数字的和
        int sum = 0;
        List<int[]> res = new ArrayList<>();

        while (i <= target / 2) {
            if (sum < target) {
                // 右边界向右移动
                sum += j;
                j++;
            } else if (sum > target) {
                // 左边界向右移动
                sum -= i;
                i++;
            } else {
                // 记录结果
                int[] arr = new int[j - i];
                for (int k = i; k < j; k++) {
                    arr[k - i] = k;
                }
                res.add(arr);
                // 左边界向右移动
                sum -= i;
                i++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }


}
