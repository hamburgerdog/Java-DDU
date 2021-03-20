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
}
