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
        int [] nums=new int[]{2,3,1,2,4,3};
        int i = s.minSubArrayLen(7, nums);
        System.out.println(i);
    }

    public int minSubArrayLen(int s, int[] nums) {
        if (nums==null||nums.length==0){
            return 0;
        }
        int length=nums.length-1;
        int j=0;
        int num=nums[j];
        if (num>=s){
            return 1;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]>=s){
                return 1;
            }
            num+=nums[i];
            if (num>=s){
                if (i-j<length){
                    length=i-j;
                }
                j++;
                num=nums[j];
                i=j;
            }
        }


        return length;
    }
}
