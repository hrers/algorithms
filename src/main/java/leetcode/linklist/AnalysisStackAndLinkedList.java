package leetcode.linklist;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author: zhangjianwu
 * @Date: 2021/4/19 23:47
 * @Desc:
 **/
public class AnalysisStackAndLinkedList {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(5);
        linkedList.add(3);
        linkedList.add(9);
        while (linkedList.size()!=0){
            System.out.print(linkedList.pop()+" ");
        }
        System.out.println(" ");
        linkedList.push(1);
        linkedList.push(2);
        linkedList.push(5);
        linkedList.push(3);
        linkedList.push(9);//在最前面插入     push+pop==》栈
        while (linkedList.size()!=0){
            System.out.print(linkedList.pop()+" ");
        }
    }
}
