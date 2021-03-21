package org.xjosiah.array;

import org.xjosiah.common.MyLinkedNode;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 *
 * @author xjosiah
 * @since 2021/3/21
 */
public class _017_MergeLink {
    private static final int LINK_LENGTH = 5;
    private static MyLinkedNode<Integer> firstLinkRootNode = new MyLinkedNode<>(1, null);
    private static MyLinkedNode<Integer> secondLinkRootNode = new MyLinkedNode<>(2, null);

    public static void main(String[] args) {
        createLinkByStep(firstLinkRootNode, 2);
        MyLinkedNode.printLink(firstLinkRootNode);
        createLinkByStep(secondLinkRootNode, 3);
        MyLinkedNode.printLink(secondLinkRootNode);

        MyLinkedNode<Integer> rootNode = new MyLinkedNode<>();
        mergeNode(rootNode, secondLinkRootNode, firstLinkRootNode);
        MyLinkedNode.printLink(rootNode.getNext());     //  注意跳过空节点头
    }

    /**
     * 递归合并两个链表
     *
     * @param node              合并链表的节点
     * @param firstLinkPointer  第一个链表的指针
     * @param secondLinkPointer 第二个链表的指针
     */
    private static void mergeNode(MyLinkedNode<Integer> node, MyLinkedNode<Integer> firstLinkPointer, MyLinkedNode<Integer> secondLinkPointer) {
        /*
            结束条件：哪一方先到，直接把另一方后续插入即可
            因为双方都满足递增原则，先到一方的最后一个节点一定不大于另一方的当前节点
         */
        if (firstLinkPointer == null) {
            node.setNext(secondLinkPointer);
            return;
        } else if (secondLinkPointer == null) {
            node.setNext(firstLinkPointer);
            return;
        }

        if (firstLinkPointer.getValue() <= secondLinkPointer.getValue()) {
            node.setNext(firstLinkPointer);
            mergeNode(node.getNext(), firstLinkPointer.getNext(), secondLinkPointer);
        } else {
            node.setNext(secondLinkPointer);
            mergeNode(node.getNext(), firstLinkPointer, secondLinkPointer.getNext());
        }
    }

    /**
     * 逐级创建链表
     *
     * @param rootNode 等待创建的链表的头节点
     * @param step     节点值递增的数值
     */
    public static void createLinkByStep(MyLinkedNode<Integer> rootNode, int step) {
        MyLinkedNode<Integer> tempNode = rootNode;
        int value = rootNode.getValue();
        for (int i = 0; i < LINK_LENGTH; i++) {
            value += step;
            tempNode.setNext(new MyLinkedNode<>(value, null));
            tempNode = tempNode.getNext();
        }
    }


}
