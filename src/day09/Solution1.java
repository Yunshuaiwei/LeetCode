package day09;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/5/20 15:50
 * @Version
 **/
public class Solution1 {

    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            fast = fast.next;
            if (fast == null) {
                break;
            }
        }
        return slow;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
