package offer.day02;

import java.util.Stack;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/27 17:29
 * @Version
 **/
public class CQueue {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();


    public CQueue() { }

    /**
     * @Param [value]
     * @return void
     * @Date 17:39 2020/7/27
     * @Description: 尾部添加元素
     **/
    public void appendTail(int value) {
        s1.add(value);
    }

    /**
     * @Param []
     * @return int
     * @Date 17:39 2020/7/27
     * @Description: 头部删除元素
     **/
    public int deleteHead() {
        while (!s1.isEmpty()) {
            s2.add(s1.pop());
        }
        if (s2.isEmpty()) {
            return -1;
        } else {
            int n = s2.pop();
            while (!s2.isEmpty()) {
                s1.add(s2.pop());
            }
            return n;
        }
    }
}
