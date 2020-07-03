package day20;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/6/30 14:54
 * @Version
 **/
public class Solution {

    private List<Integer> arr = new ArrayList<>();

    /**
     * 递归实现
     *
     * @return java.util.List<java.lang.Integer>
     * @Param [root]
     **/
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return arr;
        }
        arr.add(root.val);
        //向左递归
        if (root.left != null) {
            preorderTraversal(root.left);
        }
        //向右递归
        if (root.right != null) {
            preorderTraversal(root.right);
        }
        return arr;
    }

    public List<Integer> preorderTraversal1(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return list;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            //取栈顶元素
            TreeNode node = stack.pop();
            list.add(node.val);
            //将右子树入栈
            if (node.right != null) {
                stack.push(node.right);
            }
            //将左子树入栈
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return list;
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        if(root==null){
            return arr;
        }
        arr.add(root.val);
        if (root.left!=null){
            preorderTraversal2(root.left);
        }
        if (root.right!=null){
            preorderTraversal2(root.right);
        }
        return arr;
    }

    public List<Integer> preorderTraversal3(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root==null){
            return list;
        }
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right!=null){
                stack.push(node.right);
            }
            if (node.left!=null){
                stack.push(node.left);
            }
        }
        return list;
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

