package offer.day23;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/8/13 9:35
 * @Version
 **/
public class Solution1 {
    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[] arr = new int[]{0};
        int i = s.missingNumber(arr);
        System.out.println(i);
    }

    public int missingNumber(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int pivot = (i + j) / 2;
            if (nums[pivot] == pivot) {
                i = pivot + 1;
            } else {
                j = pivot - 1;
            }
        }
        return i;
    }
}
