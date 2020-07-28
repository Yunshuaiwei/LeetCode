package offer.day04;

import java.util.Stack;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/28 16:29
 * @Version
 **/
public class Solution {

    public int[] reversePrint(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        Stack<ListNode> s = new Stack<>();
        while (cur != null) {
            s.push(cur);
            cur = cur.next;
        }
        int[] res = new int[s.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = s.pop().val;
        }
        return res;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
