package day24;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/6 15:22
 * @Version
 **/
public class Solution1 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return check(root.left, root.right);
    }

    public boolean check(TreeNode left, TreeNode right) {
        //当左右子树都为null时返回true
        if (left == null && right == null) {
            return true;
        }
        //当左右有一个为null时返回false
        if (left == null || right == null) {
            return false;
        }
        //当左右值不相等时返回false
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
