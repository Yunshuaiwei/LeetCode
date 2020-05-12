package day05;

import java.util.*;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/5/11 20:07
 * @Version
 **/
public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, -2, -1};
        Solution s = new Solution();
        List<List<Integer>> lists = s.threeSum2(nums);
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

    public List<List<Integer>> threeSum2(int[] nums) {
        //排序
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        //排除全是0的情况
        if (nums.length > 3 && nums[0] == 0 && nums[nums.length - 1] == 0) {
            List<Integer> list = Arrays.asList(0, 0, 0);
            result.add(list);
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            int target = -nums[i];
            HashMap<Integer, Integer> map = new HashMap<>(nums
                    .length - 1);
            for (int j = i + 1; j < nums.length; j++) {
                int t = target - nums[j];
                if (map.containsKey(t)) {
                    List<Integer> list = Arrays.asList(nums[i], nums[j], t);
                    //排序,因为可能存在重复数据,以便于后面去重
                    list.sort(new Comparator<Integer>() {
                        @Override
                        public int compare(Integer o1, Integer o2) {
                            return o1 - o2;
                        }
                    });
                    result.add(list);
                } else {
                    map.put(nums[j], j);
                }
            }
        }
        //去重
        List<List<Integer>> res =
                new ArrayList<List<Integer>>(new HashSet<List<Integer>>(result));
        return res;
    }
}
