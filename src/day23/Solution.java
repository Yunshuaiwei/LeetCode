package day23;

import java.util.*;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/5 19:10
 * @Version
 **/
public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{1};
        Solution s = new Solution();
        int[] ints = s.topKFrequent(nums, 1);
        System.out.println(Arrays.toString(ints));
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        //将数组中的元素加入哈希表中，键为nums中的元素，值为该元素出现的次数
        for (int num : nums) {
            if (map.containsKey(num)) {
                Integer val = map.get(num) + 1;
                map.put(num, val);
            } else {
                map.put(num, 1);
            }
        }
        //将HashMap添加到堆中，按从大到小的顺序添加
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        //将HashMap加入到优先级队列中
        queue.addAll(map.entrySet());
        ArrayList<Integer> list = new ArrayList<>();
        int[] res = new int[k];
        //取前k个高频元素，并加入到数组中
        for (int i = 0; i < res.length; i++) {
            res[i] = Objects.requireNonNull(queue.poll()).getKey();
        }
        return res;
    }
}
