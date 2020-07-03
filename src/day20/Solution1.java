package day20;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/6/30 15:51
 * @Version
 **/
public class Solution1 {

    private List<Integer> arr = new ArrayList<>();

    /**
     * 递归实现
     *
     * @return java.util.List<java.lang.Integer>
     * @Param [root]
     **/
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return arr;
        }
        //向左递归
        if (root.left != null) {
            postorderTraversal(root.left);
        }
        //向右递归
        if (root.right != null) {
            postorderTraversal(root.right);
        }
        //输出当前节点
        arr.add(root.val);
        return arr;
    }

    /**
     * 迭代实现
     *
     * @return java.util.List<java.lang.Integer>
     * @Param [root]
     **/
    public List<Integer> postorderTraversal1(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty()) {
            TreeNode node = s1.pop();
            s2.push(node);
            if (node.left != null) {
                s1.push(node.left);
            }
            if (node.right != null) {
                s1.push(node.right);
            }
        }
        while (!s2.isEmpty()) {
            list.add(s2.pop().val);
        }
        return list;
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty()) {
            TreeNode pop = s1.pop();
            s2.push(pop);
            if (pop.left != null) {
                s1.push(pop.left);
            }
            if (pop.right != null) {
                s1.push(pop.right);
            }
        }
        while (!s2.isEmpty()) {
            list.add(s2.pop().val);
        }
        return list;
    }
}
