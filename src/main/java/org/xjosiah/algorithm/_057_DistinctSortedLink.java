package org.xjosiah.algorithm;

import org.xjosiah.common.MyLinkedNode;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 *
 * @author xjosiah
 * @since 2021/4/2
 */
public class _057_DistinctSortedLink {
    private static MyLinkedNode<Integer> rootNode = new MyLinkedNode<>();

    static {
        MyLinkedNode.createLink(rootNode, 1, 16);
        MyLinkedNode<Integer> node = rootNode.getNext();
        while (node != null) {
            MyLinkedNode<Integer> next = node.getNext();
            //  值为偶数则复制一个节点
            if (node.getValue() % 2 == 0) {
                MyLinkedNode<Integer> newNode = new MyLinkedNode<>(node.getValue(), next);
                node.setNext(newNode);
            }
            node = next;
        }
    }

    public static void main(String[] args) {
        MyLinkedNode.printLink(rootNode.getNext());
        MyLinkedNode.printLink(distinctSortedLink(rootNode.getNext()));
    }

    /**
     * 遍历判断法，因为以排序所有无需多余操作
     * 无序队列可以HashMap（有序队列也可以用TreeSet按自然排序）等容器辅助操作，重写equal和hashCode
     *
     * @param rootNode 源节点
     * @return 去除重复后的链表的头节点
     */
    private static MyLinkedNode<Integer> distinctSortedLink(MyLinkedNode<Integer> rootNode) {
        MyLinkedNode<Integer> distinctLinkRootNode = new MyLinkedNode<>(rootNode.getValue(), null);
        MyLinkedNode<Integer> distinctLinkNode = distinctLinkRootNode;
        MyLinkedNode<Integer> node = rootNode;
        while (node.getNext() != null) {
            if (!distinctLinkNode.getValue().equals(node.getValue())) {
                distinctLinkNode.setNext(new MyLinkedNode<>(node.getValue(), null));
                distinctLinkNode = distinctLinkNode.getNext();
            }
            node = node.getNext();
        }

        return distinctLinkRootNode;
    }

}
