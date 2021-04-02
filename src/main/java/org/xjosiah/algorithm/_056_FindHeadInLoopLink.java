package org.xjosiah.algorithm;

import org.xjosiah.common.MyLinkedNode;

/**
 * 一个链表中包含环，请找出该链表的环的入口结点。
 *
 * @author xjosiah
 * @since 2021/4/2
 */
public class _056_FindHeadInLoopLink {
    static MyLinkedNode<Integer> rootNode = new MyLinkedNode<>();

    static {
        MyLinkedNode<Integer> loopLinkBegin = MyLinkedNode.createLink(rootNode, 1, 8);
        MyLinkedNode<Integer> lastNode = MyLinkedNode.createLink(loopLinkBegin, 9, 8);
        lastNode.setNext(loopLinkBegin);
    }

    public static void main(String[] args) {
        System.out.println(getValueFromLoopHeadNode(rootNode.getNext()));
        System.out.println(getLoopHeadNodeValueBySetNull(rootNode.getNext()));
    }

    /**
     * 通过双指针法获取循环起始节点，与_015_想法一致
     * 即找到环长度，让一个指针先走该长度后，两个指针同时步进，当两个指针指向同一对象时就是循环开始节点
     *
     * @param rootNode 起始节点
     * @return 循环开始节点的值
     */
    private static int getValueFromLoopHeadNode(MyLinkedNode<Integer> rootNode) {
        MyLinkedNode<Integer> slowNode = rootNode;
        MyLinkedNode<Integer> fastNode = rootNode;

        int loopLength = getLoopLength(rootNode);
        for (int i = 0; i < loopLength; i++) {
            fastNode = fastNode.getNext();
        }

        while (!slowNode.equals(fastNode)) {
            slowNode = slowNode.getNext();
            fastNode = fastNode.getNext();
        }

        return slowNode.getValue();
    }

    /**
     * 双指针法获取环的长度（节点的个数）
     * 快指针一次走两步，慢指针一次走一步，相遇时一定在环中
     *
     * @param rootNode 起始节点
     * @return 循环的长度
     */
    private static int getLoopLength(MyLinkedNode<Integer> rootNode) {
        MyLinkedNode<Integer> slowNode = rootNode;
        MyLinkedNode<Integer> fastNode = rootNode;

        do {
            slowNode = slowNode.getNext();
            fastNode = fastNode.getNext().getNext();
        } while (!fastNode.equals(slowNode));

        int loopLength = 0;
        do {
            fastNode = fastNode.getNext();
            loopLength++;
        } while (!fastNode.equals(slowNode));
        return loopLength;
    }

    /**
     * 断链法，会把链表结构破坏掉，如果不希望改动数据可以使用clone
     *
     * @param rootNode 起始节点
     * @return 循环开始节点的值
     */
    private static int getLoopHeadNodeValueBySetNull(MyLinkedNode<Integer> rootNode) {
        MyLinkedNode<Integer> node = rootNode;
        while (node.getNext() != null) {
            MyLinkedNode<Integer> temp = node.getNext();
            node.setNext(null);
            node = temp;
        }
        return node.getValue();
    }
}
