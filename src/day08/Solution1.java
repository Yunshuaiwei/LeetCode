package day08;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/5/19 15:24
 * @Version
 **/
public class Solution1 {
    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null) {
            fast = fast.next;
            if (fast == null) {
                return false;
            } else {
                fast = fast.next;
            }
            if (fast == null) {
                return false;
            }
            if (fast == slow) {
                return true;
            }
            slow = slow.next;
        }
        return false;
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

