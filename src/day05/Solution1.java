package day05;

import java.util.Arrays;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/5/14 14:25
 * @Version
 **/
public class Solution1 {
    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[] nums = new int[]{1, 1, 1, 0};
        int i = s.threeSumClosest(nums, -100);
        System.out.println(i);
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int start = 0;
        int tmp = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            start = i + 1;
            int end = nums.length - 1;
            int a = nums[i];
            while (start < end) {
                int b = nums[start];
                int c = nums[end];
                int sum = a + b + c;
                tmp=(Math.abs(target - sum) < Math.abs(target - tmp))?tmp=sum:tmp;
                if (sum > target) {
                    end--;
                } else if (sum < target) {
                    start++;
                } else {
                    return sum;
                }
            }
        }
        return tmp;
    }
}
