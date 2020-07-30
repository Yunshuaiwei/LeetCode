package offer.day06;

import java.util.List;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/29 21:26
 * @Version
 **/
public class Solution {


    public int cuttingRope(int n) {


        return 0;
    }

    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        move(A.size(), A, B, C);
    }

    private void move(int n, List<Integer> A, List<Integer> B, List<Integer> C) {
        //将该盘子从A移动到C
        if (n == 1) {
            C.add(A.remove(A.size() - 1));
            return;
        }
        //将A的盘子移动到B，借助C
        move(n - 1, A, C, B);
        C.add(A.remove(A.size() - 1));
        //将B的盘子移动到C，借助A
        move(n - 1, B, A, C);
    }
}
