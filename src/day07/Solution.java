package day07;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/5/18 15:39
 * @Version
 **/
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{1, 1};
        int i = s.minSubArrayLen(3, nums);
        System.out.println(i);
    }

    public int minSubArrayLen(int s, int[] nums) {
        //排除null和数组等于0
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //数组只有一个元素，可以直接判断返回
        if (nums.length == 1) {
            if (nums[0] >= s) {
                return 1;
            } else {
                return 0;
            }
        }
        //初始假设length为数组长度
        int length = nums.length;
        int index = 0;
        int sum = 0;
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            //假设取到的元素大于等于s则可以直接返回1
            if (nums[i] >= s) {
                return 1;
            }
            //求取到的元素之和
            sum += nums[i];
            //当sum>=s时
            while (sum >= s) {
                flag = true;
                //截取index和i位置的差值，和length进行比较，将较小的复制给length
                //即更新length
                length = Math.min((i + 1 - index), length);
                //减去index位置的元素
                sum -= nums[index];
                //index后移
                index++;
            }
        }
        //假设flag为true则说明存在sum>=s的情况，则返回length
        if (flag) {
            return length;
        } else {//flag为假则说明整个数列不存在sum>=s的情况，则返回0
            return 0;
        }
    }
}
