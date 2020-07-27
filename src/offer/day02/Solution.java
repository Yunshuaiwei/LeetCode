package offer.day02;

import java.util.Arrays;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/27 17:45
 * @Version
 **/
public class Solution {
    public int minArray(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[0];
    }
}