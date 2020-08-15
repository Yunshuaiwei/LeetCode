package offer.day25;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/8/13 15:17
 * @Version
 **/
public class Solution {

    public boolean isBalanced(TreeNode root) {
        return dfs(root)!=-1;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        if (left == -1) {
            return -1;
        }
        int right = dfs(root.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}
