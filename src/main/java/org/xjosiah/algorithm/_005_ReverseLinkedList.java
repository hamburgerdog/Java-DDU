package org.xjosiah.algorithm;

import org.xjosiah.common.MyLinkedNode;

/**
 * @author  xjosiah
 * @since   2021/3/3
 */
public class _005_ReverseLinkedList {
    private static final MyLinkedNode<Character> linkedNode8;

    static {
        MyLinkedNode<Character> linkedNode1 = new MyLinkedNode<>('h', null);
        MyLinkedNode<Character> linkedNode2 = new MyLinkedNode<>('g', linkedNode1);
        MyLinkedNode<Character> linkedNode3 = new MyLinkedNode<>('f', linkedNode2);
        MyLinkedNode<Character> linkedNode4 = new MyLinkedNode<>('e', linkedNode3);
        MyLinkedNode<Character> linkedNode5 = new MyLinkedNode<>('d', linkedNode4);
        MyLinkedNode<Character> linkedNode6 = new MyLinkedNode<>('c', linkedNode5);
        MyLinkedNode<Character> linkedNode7 = new MyLinkedNode<>('b', linkedNode6);
        linkedNode8 = new MyLinkedNode<>('a', linkedNode7);
    }

    /**
     * 递归方式输出反转后的单链表
     * （另一种可采用的方式为：使用栈来存放顺序读取的数据再输出）
     * PS： LinkedList 是 双端链表
     * @param node  起始节点
     */
    private static void reverse(MyLinkedNode<Character> node){
        if (node.getNext()!=null){
            reverse(node.getNext());
        }
        System.out.println(node);
    }

    public static void main(String[] args) {
        reverse(linkedNode8);
    }
}
