package leetcode.common;


/**
 * @Author: zhangjianwu
 * @Date: 2021/6/17 14:42
 * @Desc:
 **/
public class LinkedListUtil {


    //打印链表
    public static void print(ListNode root){
        while (root!=null){
            System.out.print(root.val+" ");
            root=root.next;
        }
    }
}
