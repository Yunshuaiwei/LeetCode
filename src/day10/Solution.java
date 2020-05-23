package day10;

import java.util.ArrayList;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/5/23 13:58
 * @Version
 **/
public class Solution {
    public static void main(String[] args) {

    }

    public void setZeroes(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        boolean flag = true;
        //保存值为0的行号
        ArrayList<Integer> row = new ArrayList<>();
        //保存值为0的列号
        ArrayList<Integer> col = new ArrayList<>();
        //循环遍历二维数组，若某个值为0，则将行列好分别保存到对用的ArrayList中
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    flag = false;
                    row.add(i);
                    col.add(j);
                }
            }
        }
        //若flag为true则说明二维数组中没有0，则直接返回
        if (flag) {
            return;
        }
        //将所对应行的值改为0
        for (Integer i : row) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = 0;
            }
        }
        //将所对应列的值改为0
        for (Integer i : col) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][i] = 0;
            }
        }
    }
}
