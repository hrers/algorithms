package common.util;


import common.base.node.Node;
import edu.princeton.cs.algs4.In;

import java.util.Random;

/**
 * @Author: zhangjianwu
 * @Date: 2021/6/17 14:42
 * @Desc:
 **/
public class LinkedListUtil {


    /**
     * print the linkedlist
     * @param root
     */
    @Deprecated
    public static void printListNode(ListNode root){
        while (root!=null){
            System.out.print(root.val+" ");
            root=root.next;
        }
    }

    /**
     * print the linkedlist
     * @param node
     */
    public static void printListNode(Node node){
        while (node!=null){
            System.out.print(node.item+" ");
            node=node.next;
        }
        System.out.println();
    }

    /**
     * generate the LinkedList for Integer Type
     * @return
     */
    public static Node generateLinkedListForInteger() {
        Node<Integer> root = new Node<>(0);
        Node<Integer> tmp = root;
        for (int i = 1; i <= 10; i++) {
            Node<Integer> node = new Node<>(i);
            tmp.next=node;
            tmp=tmp.next;
        }
        return root;
    }
    public static Node generateLinkedListForIntegerRandom() {
        Node<Integer> root = new Node<>(0);
        Random random = new Random();
        Node<Integer> tmp = root;
        for (int i = 1; i <= 10; i++) {
            Node<Integer> node = new Node<>(random.nextInt(100));
            tmp.next=node;
            tmp=tmp.next;
        }
        tmp.next=null;
        return root;
    }
    public static Node generateLinkedListForIntegerHasHeader() {
        Node<Integer> root = new Node<>(null);
        Node<Integer> tmp = root;
        for (int i = 0; i <= 10; i++) {
            Node<Integer> node = new Node<>(i);
            tmp.next=node;
            tmp=tmp.next;
        }
        return root;
    }
}
