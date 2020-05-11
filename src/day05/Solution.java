package day05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/5/11 20:07
 * @Version
 **/
public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{0,-4,-1,-4,-2,-3,2};
        Solution s = new Solution();
        List<List<Integer>> lists = s.threeSum(nums);
        for (List<Integer> list : lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            for (int j = i + 1; j < nums.length; j++) {
                int a = -(nums[i] + nums[j]);
                if (a > nums[nums.length - 1]) {
                    break;
                }
                for (int k = nums.length - 1; k > j; k--) {
                    if (nums[k] == a) {
                        list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        result.add(list);
                        break;
                    }
                }
            }


        }
        List<List<Integer>> res =
                new ArrayList<List<Integer>>(new HashSet<List<Integer>>(result));
        return res;
    }
}
