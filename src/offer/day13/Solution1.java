package offer.day13;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/8/3 17:48
 * @Version
 **/
public class Solution1 {

    /**
     * @return int[]
     * @Param
     * @Date 17:48 2020/8/3
     * @Description: 顺时针打印矩阵
     **/
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[]{};
        }
        int[] arr = new int[matrix.length * matrix[0].length];
        int index = 0;
        int i = matrix.length;
        int j = matrix[0].length;
        //a和b表示列，c和d表示行
        int a = 0, b = j - 1, c = 0, d = i - 1;
        while (index < arr.length) {
            //读取第c行，从第a列开始到第b列结束
            for (int k = a; k <= b && index < arr.length; k++) {
                arr[index++] = matrix[c][k];
            }
            //第c行读取结束，则c移动到下一行
            c++;
            //从第c行的第b列向下读取第b列的元素
            for (int k = c; k <= d && index < arr.length; k++) {
                arr[index++] = matrix[k][b];
            }
            //第b列读取结束，则b移动到前一列
            b--;
            //从第d行的第b列开始向左读取元素
            for (int k = b; k >= a && index < arr.length; k--) {
                arr[index++] = matrix[d][k];
            }
            //第d行读取结束，则d向前移动一行
            d--;
            //从第d行向上读取第a列的元素
            for (int k = d; k >= c && index < arr.length; k--) {
                arr[index++] = matrix[k][a];
            }
            a++;
        }
        return arr;
    }
}
