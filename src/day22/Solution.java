package day22;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/4 16:16
 * @Version
 **/
public class Solution {

    public int findKthLargest(int[] nums, int k) {
        //重写比较器，使其变为大顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        //将每一个元素加入堆中
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }
        //去除前面k-1个元素，队头的元素就是需要的元素
        while (k - 1 > 0) {
            queue.poll();
            k--;
        }
        //返回队头元素
        return queue.poll();
    }
}
