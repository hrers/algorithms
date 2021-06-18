package leetcode.linklist;

import leetcode.linklist.ListNode;

import java.util.Stack;

/**
 * @Author: zhangjianwu
 * @Date: 2021/4/19 22:56
 * @Desc:
 **/
public class lt234 {
    public static void main(String[] args) {
        ListNode root= new ListNode(1);
        root.next=new ListNode(0);
        root.next.next=new ListNode(1);
        boolean palindromeo= isPalindrome(root);
        System.out.println(palindromeo);
    }
    public static boolean isPalindrome(ListNode head) {
        if(head.next==null||head==null){
            return true;
        }
        int length=0;
        ListNode p=head;
        Stack<ListNode> stack= new Stack<>();
        while(p!=null){
            length++;
            p=p.next;
        }
        p=head;
        //若是奇数，读到length/2,否则，读到length/2-1
        for(int i=0;i<length/2;i++){
            stack.push(p);
            p=p.next;
        }
        if(length%2!=0){
            stack.push(p);
        }
        for(int i=length/2;i<length;i++){
            if(stack.peek().val==p.val){
                stack.pop();
            }else{
                return false;
            }
            p=p.next;
        }
        return true;
    }

}
