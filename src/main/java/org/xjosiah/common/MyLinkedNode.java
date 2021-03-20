package org.xjosiah.common;

/**
 * 通用的链表节点，用于构建某一类型的链表
 *
 * @author xjosiah
 * @since 2021/3/20
 */
public class MyLinkedNode<T> {
    private T value;
    private MyLinkedNode<T> next;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setNext(MyLinkedNode<T> next) {
        this.next = next;
    }

    public MyLinkedNode<T> getNext() {
        return next;
    }

    public MyLinkedNode() {
    }

    public MyLinkedNode(T c, MyLinkedNode<T> next) {
        this.value = c;
        this.next = next;
    }

    @Override
    public String toString() {
        return "MyLinkedNode{" +
                "c=" + value +
                '}';
    }

    public boolean hasNext() {
        return getNext() != null;
    }

    /**
     * 创建一个递增的Integer链表
     * 主要用于练习链表算法时，快速构建一条链表以提供数据。
     *
     * @param rootNode 链表头节点
     * @param length   要创建的链表长度
     */
    public static void createLink(MyLinkedNode<Integer> rootNode, int length) {
        MyLinkedNode<Integer> tempNode = rootNode;
        for (int i = 1; i <= length; i++) {
            MyLinkedNode<Integer> node = new MyLinkedNode<>(i + 1, null);
            tempNode.setNext(node);
            tempNode = node;
        }
    }
}
