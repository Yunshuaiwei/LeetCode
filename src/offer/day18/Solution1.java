package offer.day18;

import java.util.HashMap;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/8/10 16:12
 * @Version
 **/
public class Solution1 {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int flag = nums.length / 2;
        int res = nums[0];
        for (int num : nums) {
            if (map.containsKey(num)) {
                Integer val = map.get(num);
                if (val + 1 > flag) {
                    res = num;
                }
                map.put(num, val + 1);
            } else {
                map.put(num, 1);
            }
        }
        return res;
    }
}
