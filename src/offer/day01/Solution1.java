package offer.day01;

import java.util.HashSet;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/16 17:08
 * @Version
 **/
public class Solution1 {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 0, 2, 5, 3};
        Solution1 s = new Solution1();
        int num = s.findRepeatNumber(arr);
        System.out.println(num);
    }

    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            boolean b = set.add(num);
            if (!b) {
                return num;
            }
        }
        return -1;
    }
}
