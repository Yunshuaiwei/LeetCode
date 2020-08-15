package offer.day25;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/8/13 15:11
 * @Version
 **/
public class Solution1 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
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
