package offer.day08;


/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/8/1 13:55
 * @Version
 **/
public class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            return head.next;
        }
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.val == val) {
                //跳过val值与目标值相等的节点
                cur.next = cur.next.next;
                break;
            }
            cur = cur.next;
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
