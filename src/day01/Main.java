package day01;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/5/6 15:22
 * @Version
 **/
public class Main {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(4);
        node4.next = node5;
        node5.next = node6;
        Solution s = new Solution();
        ListNode listNode = s.addTwoNumbers(node1, node4);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
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

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode res = null;
        ListNode r = null;
        int flag = 0;
        while (cur1 != null || cur2 != null) {
            int i = 0;
            if (cur1 != null && cur2 != null) {
                i = cur1.val + cur2.val + flag;
                cur1 = cur1.next;
                cur2 = cur2.next;
            } else if (cur1 != null) {
                i = cur1.val + flag;
                cur1 = cur1.next;
            } else {
                i = cur2.val + flag;
                cur2 = cur2.next;
            }
            if (i < 10) {
                if (res == null) {
                    res = new ListNode(i);
                    r = res;
                } else {
                    r.next = new ListNode(i);
                    r = r.next;
                }
            } else {
                flag = i / 10;
                if (res == null) {
                    res = new ListNode(i % 10);
                    r = res;
                } else {
                    r.next = new ListNode(i % 10);
                    r = r.next;
                }
            }

        }
        if (flag!=0){
            r.next=new ListNode(flag);
        }
        return res;
    }
}