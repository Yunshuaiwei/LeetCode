package offer.day04;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/28 16:53
 * @Version
 **/
public class Solution {

    int m, n, k;
    boolean[][] vis;

    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        this.vis=new boolean[m][n];
        return dfs(0,0, 0,0);
    }

    private int dfs(int i, int j, int si, int sj) {
        if (i >= m || j >= n || si + sj > k || vis[i][j]) {
            return 0;
        }
        vis[i][j] = true;
        return 1+dfs(i+1,j,sum(i+1),sum(j))+dfs(i,j+1,sum(i),sum(j+1));
    }

    /**
     * @return int
     * @Param [i]
     * @Date 18:15 2020/7/28
     * @Description: 计算数字i每一位数字之和
     **/
    private int sum(int i) {
        int s = 0;
        while (i != 0) {
            s += i % 10;
            i = i / 10;
        }
        return s;
    }
}
