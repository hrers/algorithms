package algorithems4.chapter.fundamental;

import common.util.QueueUtil;
import edu.princeton.cs.algs4.Queue;
import org.junit.Test;

import java.util.Stack;

/**
 * @Author: zhangjianwu
 * @Date: 2022/1/15 13:34
 * @Desc:
 **/
public class secondChapterDemo {

    @Test
    public void test02(){
        Integer N=50;
        Stack<Integer> stack= new Stack<>();
        while (N>0){
            stack.push(N%2);
            N=N/2;
        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

   @Test
   public void test03(){
       Queue<Integer> queue= QueueUtil.getQueueForInteger();
       Stack<Integer> stack = new Stack<>();
       QueueUtil.printQueue(queue);
       while (!queue.isEmpty()){
           stack.push(queue.dequeue());
       }
       while (!stack.isEmpty()){
           queue.enqueue(stack.pop());
       }
       QueueUtil.printQueue(queue);
   }


}
