package day03;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/5/8 22:33
 * @Version
 **/
public class Main1 {
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution2 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        //用于遍历链表
        ListNode cur = head;
        //保存cur的前驱
        ListNode pre = null;
        //保存cur的next
        ListNode curNext = null;
        while (cur != null) {
            //首先保存cur的next
            curNext = cur.next;
            //将cur的next置为它的前驱pre
            cur.next = pre;
            //pre后移，即让pre指向当前的cur
            pre = cur;
            //cur后移
            cur = curNext;
        }
        //当遍历结束cur为null，则它的前驱节点就是链表的最后一个节点，
        // 即为反转后链表的头节点
        return pre;
    }
}