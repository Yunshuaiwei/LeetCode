package day13;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/6/20 15:07
 * @Version
 **/
public class Solution {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 3},
                {2, 6},
                {15, 18},
                {8, 10}
        };
        Solution s = new Solution();
        int[][] merge = s.merge(arr);
        for (int[] ints : merge) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public int[][] merge1(int[][] intervals) {
        if (intervals == null) {
            return null;
        }
        int[] tmp = null;
        boolean flag = false;
        //使用冒泡排序，根据二维数组中每个元素索引为0的元素进行排序(由小到大)
        for (int i = 1; i < intervals.length; i++) {
            for (int j = 0; j < intervals.length - i; j++) {
                if (intervals[j][0] > intervals[j + 1][0]) {
                    flag = true;
                    tmp = intervals[j];
                    intervals[j] = intervals[j + 1];
                    intervals[j + 1] = tmp;
                }
            }
            if (flag) {
                flag = false;
            } else {
                break;
            }
        }
        //用该数组标记，被合并过的数组
        boolean[] label = new boolean[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (label[j]) {
                    continue;
                }
                //当intervals[i][1] >= intervals[j][0]说明，这两个以为数组有交集
                if (intervals[i][1] >= intervals[j][0]) {
                    intervals[i][1] = Math.max(intervals[i][1], intervals[j][1]);
                    label[j] = true;
                } else {
                    break;
                }
            }
        }
        int num = 0;
        //统计被合并后二维数组中还有多少元素
        for (int i = 0; i < label.length; i++) {
            if (!label[i]) {
                num++;
            }
        }
        int[][] result = new int[num][2];
        int index = 0;
        //将合并后的数组搬移到结果集中
        for (int i = 0; i < label.length; i++) {
            if (!label[i]) {
                result[index] = intervals[i];
                index++;
            }
        }
        return result;
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals;
        }
        //        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int[] tmp;
        boolean flag = false;
        for (int i = 1; i < intervals.length; i++) {
            for (int j = 0; j < intervals.length - i; j++) {
                if (intervals[j][0] > intervals[j + 1][0]) {
                    flag = true;
                    tmp = intervals[j];
                    intervals[j] = intervals[j + 1];
                    intervals[j + 1] = tmp;
                }
            }
            if (flag) {
                flag = false;
            } else {
                break;
            }
        }
        ArrayList<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= result.get(result.size() - 1)[1]) {
                result.get(result.size() - 1)[1] =
                        Math.max(intervals[i][1], result.get(result.size() - 1)[1]);
            } else {
                result.add(intervals[i]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
