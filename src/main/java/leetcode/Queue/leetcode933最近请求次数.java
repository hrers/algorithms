package leetcode.Queue;

import java.util.LinkedList;
import java.util.Queue;
/**
 * 没怎么明白题目的意思........
 *大概意思是将队列中距离最近入队时间大于3000毫秒的出队·
 *
 */
class RecentCounter {

    static Queue<Integer> queue;
    public  RecentCounter() {
        queue = new LinkedList<Integer>();
    }

    public int ping(int t) {
        queue.add(t);
        while (queue.peek() < t - 3000)
            queue.poll();
        return queue.size();
    }

}
