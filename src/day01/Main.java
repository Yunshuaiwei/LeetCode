package day01;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/5/6 15:22
 * @Version
 **/
public class Main {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(8);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        ListNode node4 = new ListNode(1);
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
        //用于遍历两个链表
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        //用于保存结果
        ListNode res = new ListNode(0);
        //用于向res后添加元素
        ListNode r = res;
        //用于标记进位
        int flag = 0;
        while (cur1 != null || cur2 != null) {
            //保存每一次循环的计算结果
            int i = 0;
            //此处分三种情况，cur1==null、cur1!=null(即cur2==null)、cur1和cur2都不等于null
            //即两个链表的长度不相等(三种情况)
            if (cur1 != null && cur2 != null) {
                //计算两个链表val+flag的值
                i = cur1.val + cur2.val + flag;
                cur1 = cur1.next;
                cur2 = cur2.next;
            } else if (cur1 != null) {
                //此时cur2已经遍历结束，即cur1比cur2长的情况
                i = cur1.val + flag;
                cur1 = cur1.next;
            } else {
                //此时cur1已经遍历结束，即cur2比cur1长的情况
                i = cur2.val + flag;
                cur2 = cur2.next;
            }
            //每次都将flag置为0，因为在程序结束有if (flag != 0)条件，为了处理两个链表长度相等的情况;
            //但是计算结束后有进位，则需要在最后加上进位。例如cur1.val=5,cur2.val=5，即加起来的值为0 1
            //若cur1=[5,7],cur2=[5],当第一轮循环结束后flag等于1,第二轮循环flag和7相加，然后退出循环,
            //但是在if (flag != 0)条件下此时flag=1，则会进入此条件,则结果会多加了一个1
            flag = 0;
            if (i < 10) {
                r.next = new ListNode(i);
                r = r.next;
            } else {
                flag = i / 10;
                r.next = new ListNode(i % 10);
                r = r.next;
            }

        }
        if (flag != 0) {
            r.next = new ListNode(flag);
        }
        return res.next;
    }
}