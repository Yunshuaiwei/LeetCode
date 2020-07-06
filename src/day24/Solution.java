package day24;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/6 16:39
 * @Version
 **/
public class Solution {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
