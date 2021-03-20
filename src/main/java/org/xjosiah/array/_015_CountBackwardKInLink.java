package org.xjosiah.array;

import org.xjosiah.common.MyLinkedNode;

import java.util.Scanner;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 *
 * @author xjosiah
 * @since 2021/3/20
 */
public class _015_CountBackwardKInLink {

    private static final int RANDOM_NUM = 128;
    private static MyLinkedNode<Integer> rootNode = new MyLinkedNode<>(1, null);

    public static void main(String[] args) {
        int randomLength = (int) (Math.random() * RANDOM_NUM);
        createLink(rootNode, randomLength);
        System.out.println("random length is : " + randomLength);

        System.out.print("plz input The K u want to find backwardly in Link : ");
        int K = new Scanner(System.in).nextInt();

        System.out.println("\n--------------searching-----------------");
        System.out.println("The Link[_BACKWARD_K_]`s value is : "
                + findBackward_K_InLink(rootNode, K));
    }

    /**
     * 创建链表
     *
     * @param rootNode 链表头节点
     * @param length   要创建的链表长度
     */
    private static void createLink(MyLinkedNode<Integer> rootNode, int length) {
        MyLinkedNode<Integer> tempNode = rootNode;
        for (int i = 1; i <= length; i++) {
            MyLinkedNode<Integer> node = new MyLinkedNode<>(i + 1, null);
            tempNode.setNext(node);
            tempNode = node;
        }
    }

    /**
     * 从头节点开始找倒数K位的节点
     * 核心：两个指针间隔长度K，当右指针抵达末尾，则左指针为倒数第K位
     *
     * @param rootNode 根节点
     * @param k        倒数第K位
     * @return 倒数第K位节点的值
     */
    private static int findBackward_K_InLink(MyLinkedNode<Integer> rootNode, int k) {
        //
        MyLinkedNode<Integer> rightNodePointer = rootNode;
        MyLinkedNode<Integer> leftNodePointer = rootNode;

        for (int i = 0; i < k; i++) {
            if (rightNodePointer.hasNext())
                rightNodePointer = rightNodePointer.getNext();
            else throw new RuntimeException("K超过了链表的长度");
        }

        while (rightNodePointer.hasNext()) {
            rightNodePointer = rightNodePointer.getNext();
            leftNodePointer = leftNodePointer.getNext();
        }

        return leftNodePointer.getValue();
    }

}

