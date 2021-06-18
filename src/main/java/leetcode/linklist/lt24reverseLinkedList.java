package leetcode.linklist;


/**
 * @Author: zhangjianwu
 * @Date: 2021/4/19 16:24
 * @Desc:
 **/
public class lt24reverseLinkedList {
    public static void main(String[] args) {
    }

    public ListNode reverseList(ListNode head) {
        ListNode root = new ListNode(1);
        root.next=null;
        ListNode p=head;
        ListNode q;
        while (p!=null){
            q=p.next;
            p.next=root.next;
            root.next=p;
            p=q;
        }
        return root.next;
    }



}
