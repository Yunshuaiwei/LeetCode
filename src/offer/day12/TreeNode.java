package offer.day12;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/8/3 16:06
 * @Version
 **/
class Solution {
    /**
     * @return boolean
     * @Param
     * @Date 17:22 2020/8/3
     * @Description: 判断A树结构中是否包含B树
     **/
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    /**
     * @return boolean
     * @Param
     * @Date 17:19 2020/8/3
     * @Description: 判断A和B两颗树结构是否相同
     **/
    boolean recur(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return recur(A.left, B.left) && recur(A.right, B.right);
    }

    /**
     * @return offer.day12.TreeNode
     * @Param
     * @Date 17:22 2020/8/3
     * @Description: 返回树的镜像
     **/
    public TreeNode mirrorTree(TreeNode root) {
        if (root != null) {
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            mirrorTree(root.left);
            mirrorTree(root.right);
        }
        return root;
    }
}

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

