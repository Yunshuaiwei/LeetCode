package day23;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/5 19:43
 * @Version
 **/
public class Solution {

    private ListNode res = null;
    private ListNode cur = res;

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        //利用两个临时变量node1和node2来遍历链表
        ListNode node1 = l1;
        ListNode node2 = l2;
        while (node1 != null && node2 != null) {
            //l1中val<l2中的val
            if (node1.val < node2.val) {
                //创建新的节点，并链接到res的next域
                if (res == null) {
                    res = new ListNode(node1.val);
                    cur = res;
                } else {
                    cur.next = new ListNode(node1.val);
                    cur = cur.next;
                }
                node1 = node1.next;
            } else {
                if (res == null) {
                    res = new ListNode(node2.val);
                    cur = res;
                } else {
                    cur.next = new ListNode(node2.val);
                    cur = cur.next;
                }
                node2 = node2.next;
            }
        }
        if (node1 == null) {
            cur.next = node2;
        } else {
            cur.next = node1;
        }
        return res;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
