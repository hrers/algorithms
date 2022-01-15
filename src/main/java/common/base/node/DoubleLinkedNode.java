package common.base.node;

/**
 * @Author: zhangjianwu
 * @Date: 2022/1/15 20:03
 * @Desc:
 **/
public class DoubleLinkedNode<T> extends Node{
    private Node prev;

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public DoubleLinkedNode() {

    }

    public DoubleLinkedNode(Node prev) {
        this.prev = prev;
    }

    public DoubleLinkedNode(Object item, Node node, Node prev) {
        super(item, node);
        this.prev = prev;
    }

}
