package org.xjosiah.algorithm;

import org.xjosiah.common.MyLinkedNode;

import java.util.HashSet;
import java.util.Stack;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 * 算法核心就是要将链表对齐：右对齐最佳！
 *
 * @author xjosiah
 * @since 2021/3/29
 */
public class _037_FindFirstCommonNode {
    private static final MyLinkedNode<Integer> firstLinkRootNode = new MyLinkedNode<>(1, null);
    private static final MyLinkedNode<Integer> secondLinkRootNode = new MyLinkedNode<>(101, null);

    static {
        MyLinkedNode<Integer> commonNode = new MyLinkedNode<>(18, null);
        MyLinkedNode.createLink(commonNode, 19, 4);
        MyLinkedNode.createLink(firstLinkRootNode, 2, 8).setNext(commonNode);
        MyLinkedNode.createLink(secondLinkRootNode, 102, 6).setNext(commonNode);
    }

    public static void main(String[] args) {
        MyLinkedNode.printLink(firstLinkRootNode);
        MyLinkedNode.printLink(secondLinkRootNode);

        MyLinkedNode<Integer> commonNodeBySet = findCommonNodeBySet(firstLinkRootNode, secondLinkRootNode);
        String resultBySet = commonNodeBySet != null ? String.valueOf(commonNodeBySet.getValue()) : "null";
        System.out.println("\ncommon node is : " + resultBySet);

        MyLinkedNode<Integer> commonNodeByStack = findCommonNodeByStack(firstLinkRootNode, secondLinkRootNode);
        String resultByStack = commonNodeByStack != null ? String.valueOf(commonNodeByStack.getValue()) : "null";
        System.out.println("\ncommon node is : " + resultByStack);
    }

    /**
     * 借助高性能的数据结构进行存储操作
     *
     * @param firstLink  第一个链表
     * @param secondLink 第二个链表
     * @return 相同节点-无则返回null
     */
    private static MyLinkedNode<Integer> findCommonNodeBySet(MyLinkedNode<Integer> firstLink,
                                                             MyLinkedNode<Integer> secondLink) {
        HashSet<MyLinkedNode<Integer>> linkSet = new HashSet<>();

        MyLinkedNode<Integer> node = firstLink;
        while (node != null) {
            linkSet.add(node);
            node = node.getNext();
        }

        MyLinkedNode<Integer> nodeUsed2Find = secondLink;
        while (nodeUsed2Find != null) {
            if (linkSet.contains(nodeUsed2Find)) {
                return nodeUsed2Find;
            }
            nodeUsed2Find = nodeUsed2Find.getNext();
        }

        return null;
    }

    /**
     * 通过两个栈结构实现右对齐
     *
     * @param firstLink  第一个链表
     * @param secondLink 第二个链表
     * @return 相同节点
     */
    private static MyLinkedNode<Integer> findCommonNodeByStack(MyLinkedNode<Integer> firstLink,
                                                               MyLinkedNode<Integer> secondLink) {
        Stack<MyLinkedNode<Integer>> firstStack = new Stack<>();
        Stack<MyLinkedNode<Integer>> secondStack = new Stack<>();

        MyLinkedNode<Integer> node = firstLink;
        while (node != null) {
            firstStack.push(node);
            node = node.getNext();
        }

        node = secondLink;
        while (node != null) {
            secondStack.push(node);
            node = node.getNext();
        }

        MyLinkedNode<Integer> temp = null;
        while (firstStack.size() != 0 || secondStack.size() != 0) {
            MyLinkedNode<Integer> firstNode = firstStack.pop();
            MyLinkedNode<Integer> secondNode = secondStack.pop();
            if (firstNode != secondNode) break;
            temp = firstNode;
        }
        return temp;
    }
}
