package org.xjosiah.array;

import org.xjosiah.common.MyLinkedNode;

/**
 * 输入一个链表，反转链表后，输出链表的所有元素。
 *
 * @author xjosiah
 * @since 2021/3/20
 */
public class _016_ReverseList {
    private static MyLinkedNode<Integer> rootNode = new MyLinkedNode<>(1, null);
    private static final int LINK_LENGTH = 32;

    public static void main(String[] args) {
        MyLinkedNode.createLink(rootNode, LINK_LENGTH);
        MyLinkedNode.printLink(rootNode);
        rootNode = reverseLinkByPointer(rootNode);
        MyLinkedNode.printLink(rootNode);
        MyLinkedNode.printLink(rootNode = reverseLinkByOtherLink(rootNode));
    }

    /**
     * 三指针交换法 - 前继节点、当前节点、后继节点
     * 交换当前后继指针指向前继节点
     *
     * @param rootNode 链表头节点
     * @return 翻转链表后的头节点
     */
    private static MyLinkedNode<Integer> reverseLinkByPointer(MyLinkedNode<Integer> rootNode) {
        MyLinkedNode<Integer> prevNodePointer = rootNode;
        MyLinkedNode<Integer> nodePointer = prevNodePointer.getNext();
        MyLinkedNode<Integer> nextNodePointer = nodePointer != null ?
                nodePointer.getNext() : null;

        rootNode.setNext(null);

        while (nodePointer != null) {
            nodePointer.setNext(prevNodePointer);
            prevNodePointer = nodePointer;
            nodePointer = nextNodePointer;
            if (nodePointer != null)
                nextNodePointer = nodePointer.getNext();
        }
        return prevNodePointer;
    }

    /**
     * 创建另一个链表，即使用前插法，将逐个插入该链表就相当于是倒序链表了
     *
     * @param rootNode 用于倒序的链表的头节点
     * @return 倒序后链表的头节点
     */
    private static MyLinkedNode<Integer> reverseLinkByOtherLink(MyLinkedNode<Integer> rootNode) {
        //  空表头用于插入
        MyLinkedNode<Integer> resultLinkRootNode = new MyLinkedNode<>();
        MyLinkedNode<Integer> tempNode;
        while (rootNode != null) {
            tempNode = rootNode.getNext();
            rootNode.setNext(resultLinkRootNode.getNext());
            resultLinkRootNode.setNext(rootNode);
            rootNode = tempNode;
        }
        //  切记是访问表的第一个有效节点是空表头的后继
        return resultLinkRootNode.getNext();
    }
}
