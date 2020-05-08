package day03;

import java.util.ArrayList;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/5/8 21:12
 * @Version
 **/
public class Main {
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head.next;
        Node newHead = new Node(head.val);
        Node tmp=newHead;
        //遍历创建出新的链表
        while (cur != null) {
            tmp.next = new Node(cur.val);
            cur = cur.next;
            tmp=tmp.next;
        }
        cur = head;
        ArrayList<Integer> index = new ArrayList<>();
        //遍历得到cur的random域所指向的下标，存入ArrayList中
        while (cur != null) {
            Node r = cur.random;
            int i = 0;
            tmp = head;
            while (tmp != r) {
                i++;
                tmp = tmp.next;
            }
            index.add(i);
            cur = cur.next;
        }
        tmp = newHead;
        cur = newHead;
        //取出random所对应的下标,找到下标所对用的节点，将地址赋给tmp的random于
        for (Integer i : index) {
            while (i > 0) {
                tmp = tmp.next;
                i--;
            }
            cur.random = tmp;
            cur = cur.next;
            tmp = newHead;
        }
        return newHead;
    }
    public Node copyRandomList1(Node head) {
        if(head==null){
            return null;
        }
        Node cur=head;
        while(cur!=null){
//            Node node=new Node(cur.val,cur.next,null);
            Node tmp=cur.next;
//            cur.next=node;
            cur=tmp;
        }
        cur=head;
        while(cur!=null){
            if(cur.random!=null){
                cur.next.random=cur.random.next;
            }else{
                cur.next.random=null;
            }
            cur=cur.next.next;
        }
        cur=head;
        Node newHead=cur.next;
        while(cur.next!=null){
            Node tmp=cur.next;
            cur.next=tmp.next;
            cur=tmp;
        }
        return newHead;
    }
}