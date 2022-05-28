package leetcode.sort;

import common.util.LinkedListUtil;
import common.util.ListNode;

/**
 * @Author: zhangjianwu
 * @Date: 2022/5/28 11:33
 * @Desc:
 **/
public class lt147_Insertion_Sort_List {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(1);
        listNode.next = listNode1;
        ListNode listNode2 = new ListNode(1);
//        listNode1.next=listNode2;
        ListNode listNode3 = new ListNode(3);
//        listNode2.next=listNode3;
        ListNode listNode4 = insertionSortList(listNode);
        LinkedListUtil.printListNode(listNode4);
    }

    public static ListNode insertionSortList(ListNode head) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = null;
        ListNode curr = head;
        ListNode p;
        ListNode q;
        while (curr != null) {
            q = fakeHead;
            p = fakeHead.next;
            while (p != null && p.val < curr.val) {
                q = p;
                p = p.next;
            }
            ListNode next = curr.next;
            q.next = curr;
            curr.next = p;
            curr = next;
        }
        return fakeHead.next;
    }
}
