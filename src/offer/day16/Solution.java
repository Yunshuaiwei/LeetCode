package offer.day16;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/8/6 18:02
 * @Version
 **/
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(-2);
        TreeNode node2 = new TreeNode(3);


        root.left = node1;
        root.right = node2;

//        s.preorderTraversal(root);
        List<List<Integer>> lists = s.pathSum(root, 1);
        for (List<Integer> re : lists) {
            System.out.println(re);
        }

    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    /**
     * @return java.util.List<java.util.List < java.lang.Integer>>
     * @Param
     * @Date 21:00 2020/8/6
     * @Description: 二叉树中某一值的路径
     **/
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        preorderTraversal(root);
        for (int i = 0; i < res.size(); i++) {
            int num = 0;
            List<Integer> list1 = res.get(i);
            for (int integers : list1) {
                num += integers;
            }
            if (num == sum) {
                result.add(list1);
            }
        }
        return result;
    }

    /**
     * @return void
     * @Param
     * @Date 20:56 2020/8/6
     * @Description: 谦虚遍历，得到所有路径
     **/
    private void preorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.left == null && root.right == null) {
            res.add(new ArrayList<>(list));
        }
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        list.remove(list.size() - 1);
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
