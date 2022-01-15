package recent;


import common.util.LinkedListUtil;
import common.util.ListNode;


/**
 * @Author: zhangjianwu
 * @Date: 2021/6/20 10:17
 * @Desc:
 **/
public class lt21_MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode l1= new ListNode(1);
        l1.next=new ListNode(3);
        l1.next.next=new ListNode(5);
        ListNode l2= new ListNode(2);
        l2.next=new ListNode(4);
        l2.next.next=new ListNode(6);

        LinkedListUtil.printListNode(mergeTwoLists(l1,l2));
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        else if(l2==null) return l1;
        ListNode res = null;
        if(l1.val>l2.val){
            res=l2;
            l2=l2.next;
        }else {
            res=l1;
            l1=l1.next;
        }
        ListNode index=res;//注意要使用临时的节点来操作结果链表,res只能只想返回链表的第一个节点
        while (l1!=null&&l2!=null){
            if(l1.val>l2.val){
                index.next=l2;
                l2=l2.next;
            }else {
                index.next=l1;
                l1=l1.next;
            }
            index=index.next;
        }
        if(l1==null){
            index.next=l2;
        }else {
            index.next=l1;
        }
        return res;
    }
}
