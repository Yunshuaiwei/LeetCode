package day10;

import java.util.Arrays;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/5/23 17:19
 * @Version
 **/
public class Solution {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 1, 2, 1, 7};
        Solution s = new Solution();
        int i = s.minIncrementForUnique(arr);
        System.out.println(i);
    }

    public int minIncrementForUnique(int[] A) {
        if (A == null || A.length == 1 || A.length == 0) {
            return 0;
        }
        int num = 0;
        //对数组进行排序
        Arrays.sort(A);
        //用k记录当前序列的最大值
        int k = A[0];
        for (int i = 1; i < A.length; i++) {
            //当前值和最大值相等
            if (A[i] == k) {
                //最大值+1
                k++;
                //move次数+1
                num++;
            } else if (A[i] < k) {//当前值比最大值小
                //需要move最大值和当前值差值再+1次
                num += (k - A[i] + 1);
                //最大值+1
                k++;
            } else {
                //改变最大值为A[i]
                k = A[i];
            }
        }
        return num;
    }
}
