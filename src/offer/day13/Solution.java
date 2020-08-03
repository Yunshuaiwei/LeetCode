package offer.day13;


/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/8/3 20:14
 * @Version
 **/
public class Solution {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        //当左右节点不相等时返回false
        if (left.val != right.val) {
            return false;
        }
        return check(left.right, right.left) && check(left.left, right.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
