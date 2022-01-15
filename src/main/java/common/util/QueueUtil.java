package common.util;

import edu.princeton.cs.algs4.Queue;

/**
 * @Author: zhangjianwu
 * @Date: 2022/1/15 17:24
 * @Desc:
 **/
public class QueueUtil {
    public static Queue getQueueForInteger(){
        Queue<Integer> queue= new Queue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        return queue;
    }
    public static void printQueue(Queue queue){
        for (Object o : queue) {
            System.out.print(o+" ");
        }
        System.out.println();
    }
}
