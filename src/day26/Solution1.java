package day26;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/11 19:05
 * @Version
 **/
public class Solution1 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = null;
        for (int i = 0; i < lists.length; i++) {
            res = mergeTwoLists(res, lists[i]);
        }
        return res;
    }
    /**
     * @Param [l1, l2]
     * @return day26.ListNode
     * @Date 19:30 2020/7/11
     * @Description: 合并两个链表
     **/
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
