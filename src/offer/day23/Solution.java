package offer.day23;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/8/13 9:18
 * @Version
 **/
public class Solution {
    public static void main(String[] args) {
        int [] arr=new int[]{};
        Solution s = new Solution();
        int i = s.search(arr, 0);
        System.out.println(i);
    }
    public int search(int[] nums, int target) {
        if (nums==null||nums.length<1||target < nums[0]) {
            return 0;
        }
        int res = 0;
        boolean flag = false;
        for (int num : nums) {
            if (num == target) {
                res++;
                flag = true;
            } else {
                if (flag) {
                    return res;
                }
            }
        }
        return res;
    }
}
