package day04;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/5/11 14:07
 * @Version
 **/
public class Solution1 {
    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int i = s.maxArea(height);
        System.out.println(i);
    }

    public int maxArea(int[] height) {
        //定义两个指针l和r，起始位置为0和height.length-1
        int l = 0;
        int r = height.length - 1;
        //用于保存结果
        int result = 0;
        while (l <= r) {
            //取下标所对应值中较小的
            int min = Math.min(height[l], height[r]);
            //计算面积
            int tmp = min * (r - l);
            //保存计算结果
            if (tmp > result) {
                result = tmp;
            }
            //移动值较小的所对应下标
            if (min == height[l]) {
                l++;
            } else {
                r--;
            }
        }
        return result;
    }
}
