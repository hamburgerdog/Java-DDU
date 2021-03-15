package org.xjosiah.array;

/**
 * @author  xjosiah
 * @since   2021/3/3
 */
public class _005_ReverseLinkedList {
    private static MyLinkedNode linkedNode8;

    static {
        MyLinkedNode linkedNode1 = new MyLinkedNode('h', null);
        MyLinkedNode linkedNode2 = new MyLinkedNode('g', linkedNode1);
        MyLinkedNode linkedNode3 = new MyLinkedNode('f', linkedNode2);
        MyLinkedNode linkedNode4 = new MyLinkedNode('e', linkedNode3);
        MyLinkedNode linkedNode5 = new MyLinkedNode('d', linkedNode4);
        MyLinkedNode linkedNode6 = new MyLinkedNode('c', linkedNode5);
        MyLinkedNode linkedNode7 = new MyLinkedNode('b', linkedNode6);
        linkedNode8 = new MyLinkedNode('a', linkedNode7);
    }

    /**
     * 递归方式输出反转后的单链表
     * （另一种可采用的方式为：使用栈来存放顺序读取的数据再输出）
     * PS： LinkedList 是 双端链表
     * @param node  起始节点
     */
    private static void reverse(MyLinkedNode node){
        if (node.getNext()!=null){
            reverse(node.getNext());
        }
        System.out.println(node);
    }

    public static void main(String[] args) {
        reverse(linkedNode8);
    }
}

/**
 * 单链表节点 【character类型】
 */
class MyLinkedNode{
    private Character c;
    private MyLinkedNode next;

    public MyLinkedNode(Character c, MyLinkedNode next) {
        this.c = c;
        this.next = next;
    }

    public MyLinkedNode getNext() {
        return next;
    }

    @Override
    public String toString() {
        return "MyLinkedNode{" +
                "c=" + c +
                '}';
    }
}
