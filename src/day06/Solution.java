package day06;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/5/15 19:03
 * @Version
 **/
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{1, 1};
        int i = s.removeDuplicates(nums);
        System.out.println(i);
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int index = 1;
        //记录0号下标元素
        int num = nums[0];
        //从1号下标开始遍历
        for (int i = 1; i < nums.length; i++) {
            //循环查找不等于num的元素
            while (nums[i] == num) {
                i++;
                //整个数组遍历结束，直接返回
                if (i == nums.length) {
                    return index;
                }
            }
            //将找到的不等于num的元素覆盖掉index处的元素
            nums[index++] = nums[i];
            //改变num的值，开始下一轮循环
            num = nums[i];
        }
        return index;
    }
}
