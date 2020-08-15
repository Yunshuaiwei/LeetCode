package offer.day26;

import java.util.Arrays;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/8/13 15:50
 * @Version
 **/
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[]{4, 1, 4, 6};
        int[] ints = s.singleNumbers(arr);
        System.out.println(Arrays.toString(ints));
    }

    public int[] singleNumbers(int[] nums) {
        int k = 0;
        for (int num : nums) {
            k ^= num;
        }
        int mask = 1;
        while ((k & mask) == 0) {
            mask <<= 1;
        }
        int a = 0;
        int b = 0;
        for (int num : nums) {
            if ((num & mask) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }
}

