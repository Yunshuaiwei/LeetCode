package day19;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/6/30 14:51
 * @Version
 **/
public class Solution1 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int hl = height(root.left);
        int hr = height(root.right);
        //判断当前节点是否是平衡二叉树，并且需要判断其左右子树是否也时平衡二叉树
        return Math.abs(hl - hr) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    /**
     * 求树的高度
     *
     * @return int
     * @Param [node]
     **/
    private int height(TreeNode node) {
        if (node == null) {
            return -1;
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }
}