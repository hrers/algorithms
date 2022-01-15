package recent;

import common.util.ArrayUtil;
import common.util.ListNode;
import java.util.LinkedList;

/**
 * @Author: zhangjianwu
 * @Date: 2021/6/20 14:22
 * @Desc:
 * 方法1：使用栈的方式逆序输出链表，链表依次入栈,再出栈就逆序了
 * 方法2：第一次遍历链表得到数组长度，第二次遍历链表从数组最后一个元素开始赋值，一次递减
 *
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 **/
public class jzoffer06 {
    public static void main(String[] args) {
        ListNode root= new ListNode(5);
        root.next=new ListNode(8);
        //int[] ints = reversePrint(root);
        int[] ints = reversePrint2(root);
        ArrayUtil.print(ints);
    }
    public static int[] reversePrint(ListNode head) {
        LinkedList<Integer> stack= new LinkedList<>();
        while (head!=null){
            stack.push(head.val);
            head=head.next;
        }
        int[] res=new int[stack.size()];
        int i=0;
        while (stack.peek()!=null){
            res[i++]=stack.pop();
        }
        return res;
    }
    public static int[] reversePrint2(ListNode head){
        int count=0;
        ListNode p=head;
        while (p!=null){
            count++;
            p=p.next;
        }
        int[] arr=new int[count];
        for (int i = count-1; i >=0 ; i--) {
            arr[i]=head.val;
            head=head.next;
        }
        return arr;
    }
}
