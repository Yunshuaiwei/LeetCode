package offer.day22;

import java.util.HashSet;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/8/13 8:37
 * @Version
 **/
public class Solution1 {
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode res = null;
        ListNode cur = headA;
        HashSet<ListNode> set = new HashSet<>();
        while (cur != null) {
            set.add(cur);
            cur = cur.next;
        }
        cur = headB;
        while (cur != null) {
            if (set.contains(cur)) {
                res = cur;
                break;
            }
            cur = cur.next;
        }
        return res;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode cur1 = headA;
        ListNode cur2 = headB;
        while (cur1 != cur2) {
            //当cur1等于null时让cur1指向B
            cur1 = (cur1 == null ? headB : cur1.next);
            cur2 = (cur2 == null ? headA : cur2.next);
        }
        return cur1;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
