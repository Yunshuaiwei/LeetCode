package day02;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/5/7 16:08
 * @Version
 **/
public class Main {
    public static void main(String[] args) {

    }
}

class Solution1 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        int length = 0;
        ListNode cur = head;
        ListNode newHead = null;
        ListNode pre = head;
        //遍历链表得到链表长度
        while (cur != null) {
            cur = cur.next;
            length++;
        }
        k = k % length;
        if (k == 0) {
            return head;
        }
        //得到新的头节点的下标，下标从0开始
        k = length - k;
        cur = head;
        //遍历，得到第k个节点
        while (k > 0) {
            pre = cur;
            cur = cur.next;
            k--;
        }
        newHead = cur;
        //得到最后一个节点
        while (cur.next != null) {
            cur = cur.next;
        }
        //将链表构成环
        cur.next = head;
        //pre为新链表的最后一个节点，所以将next域置null
        pre.next = null;
        return newHead;
    }
}