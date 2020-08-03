package offer.day11;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/8/2 23:29
 * @Version
 **/
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        ListNode curNext;
        while (cur != null) {
            //保存cur的next域
            curNext = cur.next;
            //将cur的next域置为他的前驱节点
            cur.next = pre;
            //前驱节点后移
            pre = cur;
            //cur后移
            cur = curNext;
        }
        return pre;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        //创建一个新链表，该节点为新链表的头节点
        ListNode newNode = null;
        //用于遍历整个链表
        ListNode cur = null;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                if (newNode == null) {
                    //当新节点为空时，则将l1赋值给新节点
                    newNode = l1;
                    cur = newNode;
                } else {
                    //创建新的节点，并加入到newNode链表中
                    cur.next = new ListNode(l1.val);
                    cur = cur.next;
                }
                l1 = l1.next;
            } else {
                if (newNode == null) {
                    newNode = l2;
                    cur = newNode;
                } else {
                    cur.next = new ListNode(l2.val);
                    cur = cur.next;
                }
                l2 = l2.next;
            }
        }
        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }
        return newNode;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
