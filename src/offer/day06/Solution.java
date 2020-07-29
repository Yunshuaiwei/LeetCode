package offer.day06;


import java.util.HashMap;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/29 14:13
 * @Version
 **/
public class Solution {
    public static void main(String[] args) {
        int[] arr1 = new int[]{3, 9, 20, 15, 7};
        int[] arr2 = new int[]{9, 3, 15, 20, 7};
        Solution s = new Solution();
        TreeNode treeNode = s.buildTree(arr1, arr2);

    }

    HashMap<Integer, Integer> dic = new HashMap<>();
    int[] po;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        po = preorder;
        for (int i = 0; i < inorder.length; i++) {
            dic.put(inorder[i], i);
        }

        return recur(0, 0, inorder.length - 1);
    }

    private TreeNode recur(int pre_root, int in_left, int in_right) {
        if (in_left > in_right) {
            return null;
        }
        TreeNode root = new TreeNode(po[pre_root]);
        int i = dic.get(po[pre_root]);
        root.left = recur(pre_root + 1, in_left, i - 1);
        root.right = recur(pre_root + i - in_left + 1, i + 1, in_right);
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
