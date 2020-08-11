package offer.day19;

import java.util.PriorityQueue;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/8/11 18:28
 * @Version
 **/
public class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (Integer integer : arr) {
            queue.add(integer);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }
}
