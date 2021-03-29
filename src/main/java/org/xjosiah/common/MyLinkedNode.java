package org.xjosiah.common;

import java.util.ArrayList;
import java.util.stream.Collectors;

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
     * 创建一个从1开始递增的Integer链表
     * 主要用于练习链表算法时，快速构建一条链表以提供数据。
     *
     * @param rootNode 链表头节点
     * @param length   要创建的链表长度
     */
    public static void createLink(MyLinkedNode<Integer> rootNode, int length) {
        createLink(rootNode, 1, length);
    }

    /**
     * 创建一个从某整数开始递增的Integer链表
     *
     * @param rootNode 头节点
     * @param begin    起始数
     * @param length   要创建的链表的长度
     * @return 返回末尾节点
     */
    public static MyLinkedNode<Integer> createLink(MyLinkedNode<Integer> rootNode, int begin, int length) {
        System.out.println("Created_Link`s length is : " + length);
        MyLinkedNode<Integer> tempNode = rootNode;
        for (int i = begin; i < begin + length; i++) {
            MyLinkedNode<Integer> node = new MyLinkedNode<>(i, null);
            tempNode.setNext(node);
            tempNode = node;
        }
        return tempNode;
    }

    /**
     * 根据头节点输出某一条链表,以数组形式展示
     *
     * @param rootNode 链表的头节点
     */
    public static void printLink(MyLinkedNode rootNode) {
        ArrayList<MyLinkedNode> list = new ArrayList<>();
        while (rootNode != null) {
            list.add(rootNode);
            rootNode = rootNode.next;
        }
        System.out.println("\n######## PRINTING_LINK ########");
        System.out.println(list.stream().map(t -> t.value).collect(Collectors.toList()));
    }
}
