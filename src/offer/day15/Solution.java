package offer.day15;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/8/5 17:00
 * @Version
 **/
public class Solution {
    public int[] levelOrder1(TreeNode root) {
        //当根节点为空时，则直接返回空数据
        if (root == null) {
            return new int[]{};
        }
        //用于保存遍历的结果集
        ArrayList<Integer> list = new ArrayList<>();
        //作为中间的存储容器，利用队列的特性进行遍历
        Queue<TreeNode> queue = new LinkedList<>();
        //首先将队头元素加入到队列中
        queue.add(root);
        //当队列为空时，则说明遍历结束，则可对出循环
        while (!queue.isEmpty()) {
            //弹出对头元素
            TreeNode node = queue.poll();
            //将该节点的val加入到结果集合中
            list.add(node.val);
            //分别将该节点的左右节点加入到队列中，先加左节点，因为每一层是左到右进行遍历
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        //创建数组，将ArrayList转为数组
        int[] arr = new int[list.size()];
        int i = 0;
        for (Integer num : list) {
            arr[i++] = num;
        }
        return arr;
    }

    /**
     * @return java.util.List<java.util.List < java.lang.Integer>>
     * @Param
     * @Date 17:30 2020/8/5
     * @Description: 从上到下按层打印二叉树
     **/
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            while (size > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                size--;
            }
            res.add(list);
        }
        return res;
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
