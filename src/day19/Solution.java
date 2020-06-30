package day19;

import java.util.*;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/6/30 14:24
 * @Version
 **/
public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        //先将根节点入队列
        queue.add(root);
        while (!queue.isEmpty()) {
            //保存当前队列的长度，此长度的含义为当前节点所在层的节点数
            int size = queue.size();
            //用于保存当前该层的所有节点的值
            ArrayList<Integer> list = new ArrayList<>();
            while (size > 0) {
                //取队首元素
                TreeNode node = queue.poll();
                list.add(node.val);
                //将当前节点的左节点加入队列
                if (node.left != null) {
                    queue.add(node.left);
                }
                //将当前节点的右节点加入队列
                if (node.right != null) {
                    queue.add(node.right);
                }
                //当前层节点数减一
                size--;
            }
            lists.add(list);
        }
        return lists;
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
