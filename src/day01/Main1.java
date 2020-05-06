package day01;

import java.util.HashMap;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/5/6 14:42
 * @Version
 **/
public class Main1 {
    public static void main(String[] args) {
    }
    public int[] twoSum(int[] nums, int target) {
        int [] result=new int [2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]+nums[j]==target){
                    result[0]=i;
                    result[1]=j;
                }
            }
        }
        return result;
    }
    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int j=target-nums[i];
            if(map.containsKey(j)){
                return new int[]{map.get(j),i};
            }else{
                map.put(nums[i],i);
            }
        }
        return null;
    }
}
