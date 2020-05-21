package day09;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/5/21 15:12
 * @Version
 **/
public class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        //用于存储结果
        ArrayList<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int i = matrix.length;
        int j = matrix[0].length;
        //a表示列的左边界，b表示列的右边界，c表示层的上边界，d表示层的下边界
        int a = 0, b = j - 1, c = 0, d = i - 1;
        //当result中的元素个数等于matrix中的元素个数时退出循环
        while (result.size() < i * j) {
            //遍历第c层，从a列起始到b列结束(向右遍历)
            for (int k = a; k <= b && result.size() < i * j; k++) {
                result.add(matrix[c][k]);
            }
            //上边界下移
            c++;
            //循环遍历第b列，从c层起始到d层结束(向下遍历)
            for (int k = c; k <= d && result.size() < i * j; k++) {
                result.add(matrix[k][b]);
            }
            //右边界左移
            b--;
            //循环遍历第d层，从第b列起始到第a列结束(向左遍历)
            for (int k = b; k >= a && result.size() < i * j; k--) {
                result.add(matrix[d][k]);
            }
            //下边界上移
            d--;
            //循环遍历第a列，从第d层起始到第c层结束(向上遍历)
            for (int k = d; k >= c && result.size() < i * j; k--) {
                result.add(matrix[k][a]);
            }
            //左边界右移
            a++;
        }
        return result;
    }
}
