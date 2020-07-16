package offer.day01;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/16 17:18
 * @Version
 **/
public class Solution {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        Solution s = new Solution();
        System.out.println(s.findNumber(arr, 7));
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }
        for (int[] ints : matrix) {
            if (target >= ints[0] && target <= ints[ints.length - 1]) {
                if (findNumber(ints, target)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @return boolean
     * @Param [arr, target]
     * @Date 17:26 2020/7/16
     * @Description: 二分查找
     **/
    public boolean findNumber(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }
}
