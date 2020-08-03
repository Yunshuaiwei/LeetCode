package offer.day08;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/8/1 13:28
 * @Version
 **/
public class Solution1 {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        solution.printNumbers(2);
    }

    public int[] printNumbers(int n) {
        int num = (int) Math.pow(10, n - 1) * 9;
        int res = num;
        int x = 9;
        //拼出n位最大数
        while (res / 10 != 0) {
            num += x;
            x *= 10;
            res /= 10;
        }
        int[] arr = new int[num];
        for (int i = 1; i <= num; i++) {
            arr[i - 1] = i;
        }
        return arr;
    }
}
