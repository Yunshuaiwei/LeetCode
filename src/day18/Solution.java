package day18;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/6/29 14:43
 * @Version
 **/
public class Solution {

    private List<Integer> list = new ArrayList<Integer>();

    /**
     * 递归实现
     *
     * @return java.util.List<java.lang.Integer>
     * @Param [root]
     **/
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        //当左子树不为空则向左递归
        if (root.left != null) {
            inorderTraversal(root.left);
        }
        //当前节点值加入list中
        list.add(root.val);
        //当由子树不为空则向右递归
        if (root.right != null) {
            inorderTraversal(root.right);
        }
        return list;
    }

    /**
     * 循环实现
     *
     * @return java.util.List<java.lang.Integer>
     * @Param [root]
     **/
    public List<Integer> inorderTraversal1(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            //当前节点不为空时则入栈，并且向左循环
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x) {
        val = x;
    }
}
