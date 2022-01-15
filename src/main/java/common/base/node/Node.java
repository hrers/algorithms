package common.base.node;

/**
 * @Author: zhangjianwu
 * @Date: 2022/1/15 15:26
 * @Desc:
 **/
public class Node<T> {
   public T item;
   public Node next;

   public Node() {
   }

   public Node(T item) {
      this.item = item;
   }

   public Node(T item, Node node) {
      this.item = item;
      this.next = node;
   }
}
