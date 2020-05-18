package day07;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/5/18 15:03
 * @Version
 **/
public class Solution1 {
    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        int i = s.maxProfit(prices);
        System.out.println(i);
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 1 || prices.length == 0) {
            return 0;
        }
        //假设0号下标处是最小值
        int min = prices[0];
        //用于保存结果
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            //假设第i处的是最大值
            int max = prices[i];
            //若max-min小于0，则说明max比min小，则将max赋值给min
            if (max - min < 0) {
                min = max;
            } else {//判断max和min差距最大的数，保存到result
                if (max - min > result) {
                    result = max - min;
                }
            }
        }
        return result;
    }
}
