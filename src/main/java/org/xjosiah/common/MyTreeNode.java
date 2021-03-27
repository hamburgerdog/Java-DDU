package org.xjosiah.common;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 通用的二叉树节点，用于构建某一类型的二叉树
 *
 * @author xjosiah
 * @since 2021/3/20
 */
public class MyTreeNode<T> {
    private MyTreeNode<T> leftChild;
    private MyTreeNode<T> rightChild;
    private T value;

    public MyTreeNode() {
    }

    public void setLeftChild(MyTreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(MyTreeNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public MyTreeNode<T> getLeftChild() {
        return leftChild;
    }

    public MyTreeNode<T> getRightChild() {
        return rightChild;
    }

    public boolean hasLeftChild() {
        return leftChild != null;
    }

    public boolean hasRightChild() {
        return rightChild != null;
    }

    public MyTreeNode(T value) {
        this.value = value;
    }

    /**
     * 根据值来设置子树
     *
     * @param leftValue  左子树的值 | 使用时可以为null，即根据泛型限制应该使用包装类
     * @param rightValue 右子树的值 | 同上
     * @return 返回设置完子树的当前节点
     */
    public MyTreeNode<T> setChildTreeNodeByValue(T leftValue, T rightValue) {
        if (leftValue != null) this.setLeftChild(new MyTreeNode<>(leftValue));
        if (rightValue != null) this.setRightChild(new MyTreeNode<>(rightValue));
        return this;
    }

    /**
     * 根据整型数组创建Integer类型的二叉树
     *
     * @param array 源数组
     * @return 创建完成的二叉树的头节点
     */
    public static MyTreeNode<Integer> createTreeByArray(int[] array) {
        Queue<MyTreeNode<Integer>> queue = new LinkedList<>();
        MyTreeNode<Integer> node = new MyTreeNode<>(array[0]);
        for (int i = 0; i < array.length; i++) {
            if (queue.isEmpty()) {
                queue.add(node);
                continue;
            }
            MyTreeNode<Integer> pollNode = queue.poll();

            MyTreeNode<Integer> leftChild = new MyTreeNode<>(array[i]);
            pollNode.setLeftChild(leftChild);
            queue.add(leftChild);

            if (++i < array.length) {
                MyTreeNode<Integer> rightChild = new MyTreeNode<>(array[i]);
                pollNode.setRightChild(rightChild);
                queue.add(rightChild);
            }
        }
        return node;
    }
}
