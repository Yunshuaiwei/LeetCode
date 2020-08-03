package offer.day10;

import java.util.Arrays;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/8/2 22:12
 * @Version
 **/
public class Solution1 {
    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[] e = s.exchange(new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(e));
    }

    public int[] exchange(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            while (low < high && nums[low] % 2 != 0) {
                low++;
            }
            while (low < high && nums[high] % 2 == 0) {
                high--;
            }
            int tmp = nums[low];
            nums[low] = nums[high];
            nums[high] = tmp;
        }
        return nums;
    }
}
