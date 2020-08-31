package offer.day28;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/8/25 10:31
 * @Version
 **/
public class MaxQueue {

    Queue<Integer> queue;
    LinkedList<Integer> max;

    public MaxQueue() {
        queue = new LinkedList<>();
        max = new LinkedList<>();
    }

    public int max_value() {
        return max.size() == 0 ? -1 : max.getFirst();
    }

    public void push_back(int value) {
        queue.add(value);
        while (max.size() != 0 && max.getLast() < value) {
            max.removeLast();
        }
        max.add(value);
    }

    public int pop_front() {
        if (max.size() != 0 && queue.peek().equals(max.getFirst())) {
            max.removeFirst();
        }
        return queue.size() == 0 ? -1 : queue.poll();
    }
}
