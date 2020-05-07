package day02;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/5/7 14:32
 * @Version
 **/
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //若头节点为空则直接返回
        if (head == null) {
            return null;
        }
        //定义快慢指针
        ListNode slow = head;
        ListNode fast = head;
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        //当fast==null则表示n等于链表长度，则将头节点指向第二个节点返回
        if (fast == null) {
            return head.next;
        }
        //快慢指针各走一步，若fast的next等于null，则此时fast指向最后一个节点
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //删除节点
        if (slow != null) {
            slow.next = slow.next.next;
        }
        return head;
    }
}
