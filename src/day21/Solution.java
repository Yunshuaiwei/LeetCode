package day21;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/7/1 16:32
 * @Version
 **/

public class Solution {
    Long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        //判断左子树
        if (!isValidBST(root.left)) {
            return false;
        }
        //当前节点值和前驱节点值比较
        if (root.val <= pre) {
            return false;
        }
        pre = (long) root.val;
        return isValidBST(root.right);
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
