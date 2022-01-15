package algorithems4;

import cn.hutool.core.util.ObjectUtil;
import com.sun.deploy.net.proxy.UserDefinedProxyConfig;
import common.base.node.Node;
import common.util.LinkedListUtil;
import org.junit.Test;

/**
 * @Author: zhangjianwu
 * @Date: 2022/1/15 15:29
 * @Desc:
 **/
public class Algo4LinkedListTest {
    /**
     * source root
     */
    private Node root = LinkedListUtil.generateLinkedListForInteger();
    static Node randomStaticNode = LinkedListUtil.generateLinkedListForIntegerRandom();
    /**
     * ops root
     */
    private Node ops = root;

    /**
     * 接受一个int参数k，删除链表的第k个元素(如果它存在的话)
     */
    @Test
    public void testDeleteK() {
        int i = 1;
        int k = 80;
        while (i <= k && ObjectUtil.isNotNull(ops.next)) {
            ops = ops.next;
            i++;
        }
        if (i < k)
            System.out.println("element is not exist !");
        else
            System.out.println("the elememt " + k + " is " + ops.item);
    }

    @Test
    public void testFind(){
        int k=8;
        int key=18;
        while (k>0){
            ops=ops.next;
            k--;
        }
        if(k!=0){
            System.out.println(" key "+key+" is not exist !");
        }else {
            if(ops.item.equals(key)){
                System.out.println(" key " + key +" is "+ops.item);
            }else {
                System.out.println(" key "+key+" is not exist !");
            }
        }
    }
    /**
     * 编写一个方法，删除链表中所有item 等于key的节点
     */
    @Test
    public void testDeleteItemIsKey(){
        root=LinkedListUtil.generateLinkedListForIntegerHasHeader();
        ops=root;
        Integer key = 8;
        ops.next.next.item=key;
        ops.next.next.next.next.item=key;
        LinkedListUtil.printListNode(root);
        Node pre=ops;
        ops=ops.next;
        while (ops.next!=null){
            if(ops.item.equals(key)){
               pre.next=ops.next;
            }
            pre=ops;
            ops=ops.next;
        }
        LinkedListUtil.printListNode(root);
    }

    /**
     * 用递归的方式获取链表中的的最大值
     */
    public static Integer testGetMaxUseRecursive(Node<Integer> node,Integer max){
        if(ObjectUtil.isNull(node)){
            return Integer.MIN_VALUE;
        }
        Integer item = testGetMaxUseRecursive(node.next, max);
        return node.item>item?node.item:item;
    }

    public static void main(String[] args) {
        Integer integer = testGetMaxUseRecursive(randomStaticNode, -999);
        LinkedListUtil.printListNode(randomStaticNode);
        System.out.println("max is "+integer);
    }

    /**
     * 链表翻转
     * Head-->A-->B-->C-->D
     */
    @Test
    public void testReverseListUseHeader(){
        Node head= LinkedListUtil.generateLinkedListForIntegerHasHeader();
        LinkedListUtil.printListNode(head.next);
        Node first=head.next;
        Node go=first.next;
        first.next=null;
        while (go!=null){
            head.next=go;
            go=go.next;
            head.next.next=first;
            first=head.next;
        }
        LinkedListUtil.printListNode(head.next);
    }
    /**
     * 不使用头结点的链表翻转
     * A-->B-->C--D
     * A-->null B-->C-->D
     */
    @Test
    public void testReverseListNoHeaderAnswer() {
        Node node = LinkedListUtil.generateLinkedListForIntegerRandom();
        LinkedListUtil.printListNode(node);
        if (node.next == null) {
            System.out.println(node.item);
        }
        Node reverse = null;
        Node first = node;
        while (first != null) {
            Node second = first.next;
            first.next = reverse;
            reverse = first;
            first = second;
        }
        LinkedListUtil.printListNode(reverse);
    }

    /**
     * 不使用头结点的链表翻转
     * A-->B-->C--D
     * A-->null B-->C-->D
     * 关键在于第一步将链表断陈两段，第一段只有一个，第二段一个个往第一段合并
     * 第二段往第一段合并的过程主要要保证指针推进过程不能遗失指针,second相当于是保存第二段链表的移动位置
     */
    @Test
    public void testReverseListNoHeader() {
        Node node = LinkedListUtil.generateLinkedListForIntegerRandom();
        LinkedListUtil.printListNode(node);
        if (node.next == null) {
            System.out.println(node.item);
        }
        Node head = node;
        Node first = head.next;
        head.next = null;
        while (first != null) {
            Node second=first.next;
            first.next=head;
            head=first;
            first=second;
        }
        LinkedListUtil.printListNode(head);
    }







}
