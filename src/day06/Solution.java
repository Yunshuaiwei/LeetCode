package day06;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/5/17 16:12
 * @Version
 **/
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] height = new int[]{4,2,3};
        int trap = s.trap(height);
        System.out.println(trap);
    }

    public int trap(int[] height) {
        if (height==null||height.length<=2){
            return 0;
        }
        if (height.length==3){
            int min = Math.min(height[0], height[2]);
            return Math.max(min - height[1], 0);
        }
        int result = 0;
        int next = 0;
        int i = 0;
        while (height[i] == 0) {
            i++;
            if (i==height.length){
                return result;
            }
        }
        while (i < height.length - 1) {
            next = i + 1;
            if (height[i] <= height[next]) {
                while (height[i] <= height[next]) {
                    next++;
                    i++;
                    if (next == height.length) {
                        break;
                    }
                }
            } else {
                while (height[i] > height[next]) {
                    next++;
                    if (next == height.length) {
                        i = i + 1;
                        break;
                    }
                }
                if (next != height.length) {
                    int min = Math.min(height[i], height[next]);
                    int tmp = min * (Math.abs(i - next) - 1);
                    for (int j = i + 1; j < next; j++) {
                        tmp -= height[j];
                    }
                    result += tmp;
                    i = next;
                }
            }
        }
        return result;
    }
}
