package day21;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/7/1 16:34
 * @Version
 **/
public class Solution1 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        } else {
            //查找要删除的节点
            TreeNode targetNode = searchNodeOfKey(root, key);
            //如果没有找到要删除的节点则直接返回
            if (targetNode == null) {
                return root;
            }
            //当前二叉树只有一个节点，且为要删除的节点
            if (root.left == null && root.right == null) {
                return null;
            }
            //查找targetNode的父节点
            TreeNode parentTargetNode = parentNode(root, key);
            if (targetNode.left == null && targetNode.right == null) {//若删除的节点为叶子节点
                //判断要删除的节点是父节点的左子节点还是右子节点
                if (parentTargetNode.left != null && parentTargetNode.left.val == key) {
                    parentTargetNode.left = null;
                } else if (parentTargetNode.right != null && parentTargetNode.right.val == key) {
                    parentTargetNode.right = null;
                }
            } else if (targetNode.left != null && targetNode.right != null) {//删除有两颗子树的节点
                //从右子树找最小值
                int min = delRightTreeMin(targetNode.right);
                targetNode.val = min;
            } else {//删除只有一颗子树的节点
                //如果要删除的节点有左子节点
                if (targetNode.left != null) {
                    //如果targetNode是parent的左子节点
                    if (parentTargetNode.left.val == key) {
                        parentTargetNode.left = targetNode.left;
                    } else {
                        parentTargetNode.right = targetNode.left;
                    }
                } else {//要删除的节点有右子节点
                    //targetNode是parent的左子节点
                    if (parentTargetNode.left.val == key) {
                        parentTargetNode.left = targetNode.right;
                    } else {//targetNode是parent的右子节点
                        parentTargetNode.right = targetNode.right;
                    }
                }
            }
        }
        return root;
    }

    /**
     * @return int
     * @Param
     * @Date 13:38 2020/8/7
     * @Description: 返回以node为根节点的二叉排序树的最小节点
     **/
    private int delRightTreeMin(TreeNode node) {
        TreeNode target = node;
        while (target.left != null) {
            target = target.left;
        }
        //删除该节点
        deleteNode(node, target.val);
        return target.val;
    }

    /**
     * @return day21.TreeNode
     * @Param
     * @Date 12:33 2020/8/7
     * @Description: 查找该节点
     **/
    private TreeNode searchNodeOfKey(TreeNode node, int key) {
        if (node == null) {
            return null;
        }
        if (node.val == key) {
            return node;
        }
        if (node.val > key) {
            if (node.left != null) {
                return searchNodeOfKey(node.left, key);
            } else {
                return null;
            }
        }
        if (node.right != null) {
            return searchNodeOfKey(node.right, key);
        } else {
            return null;
        }
    }

    /**
     * @return day21.TreeNode
     * @Param
     * @Date 12:35 2020/8/7
     * @Description: 查找父节点
     **/
    private TreeNode parentNode(TreeNode root, int key) {
        if ((root.left != null && root.left.val == key) ||
                (root.right != null && root.right.val == key)) {
            return root;
        } else {
            if (root.val < key && root.right != null) {
                return parentNode(root.right, key);
            } else if (root.val > key && root.left != null) {
                return parentNode(root.left, key);
            } else {
                //没有父节点
                return null;
            }
        }
    }
}
class Solution3 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        //当前节点值比key小，则需要删除当前节点的左子树中key对应的值，并保证二叉搜索树的性质不变
        if(key < root.val){
            root.left = deleteNode(root.left,key);
        }
        //当前节点值比key大，则需要删除当前节点的右子树中key对应的值，并保证二叉搜索树的性质不变
        else if(key > root.val){
            root.right = deleteNode(root.right,key);
        }
        //当前节点等于key，则需要删除当前节点，并保证二叉搜索树的性质不变
        else{
            //当前节点没有左子树
            if(root.left == null){
                return root.right;
            }
            //当前节点没有右子树
            else if(root.right == null){
                return root.left;
            }
            //当前节点既有左子树又有右子树
            else{
                TreeNode node = root.right;
                //找到当前节点右子树最左边的叶子结点
                while(node.left != null){
                    node = node.left;
                }
                //将root的左子树放到root的右子树的最下面的左叶子节点的左子树上
                node.left = root.left;
                return root.right;
            }
        }
        return root;
    }
}


