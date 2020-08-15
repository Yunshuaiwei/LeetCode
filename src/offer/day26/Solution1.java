package offer.day26;

import java.util.ArrayList;

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
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();



        return null;
    }
}
