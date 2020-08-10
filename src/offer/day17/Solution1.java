package offer.day17;

import java.util.HashMap;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/8/10 14:18
 * @Version
 **/
public class Solution1 {
    public Node1 copyRandomList(Node1 head) {
        if (head == null) {
            return null;
        }
        //用于遍历原链表
        Node1 cur = head;
        //保存原链表中节点地址和索引的映射关系
        HashMap<Node1, Integer> map = new HashMap<>();
        //保存新节点的索引和地址的映射关系
        HashMap<Integer, Node1> newNodeMap = new HashMap<>();
        //保存原链表的索引和random指向的节点索引的映射关系
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int num = 0;
        //遍历原链表，将原链表节点地址和索引映射关系加入到map中
        while (cur != null) {
            map.put(cur, num++);
            cur = cur.next;
        }
        cur = head;
        //新链表的头节点
        Node1 newNode = null;
        //用于遍历新链表
        Node1 newCur = null;
        num = 0;
        int num1 = 0;
        //遍历原链表并完成复制操作
        while (cur != null) {
            if (newNode == null) {
                newNode = new Node1(cur.val);
                newNodeMap.put(num++, newNode);
                newCur = newNode;
            } else {
                newCur.next = new Node1(cur.val);
                newNodeMap.put(num++, newCur.next);
                newCur = newCur.next;
            }
            //将链表的索引和它random域指向的索引映射关系保存到链表中
            hashMap.put(num1++, map.get(cur.random));
            cur = cur.next;
        }
        newCur = newNode;
        num = 0;
        //改变新链表的random域，将random指向对应的节点中
        while (newCur != null) {
            newCur.random = newNodeMap.get(hashMap.get(num++));
            newCur = newCur.next;
        }
        //返回新链表的头节点
        return newNode;
    }
}

class Node1 {
    int val;
    Node1 next;
    Node1 random;

    public Node1(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
