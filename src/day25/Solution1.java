package day25;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/7 15:58
 * @Version
 **/
public class Solution1 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        //保存根节点的左子树
        TreeNode left = invertTree(root.left);
        //保存根节点的右子树
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
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
