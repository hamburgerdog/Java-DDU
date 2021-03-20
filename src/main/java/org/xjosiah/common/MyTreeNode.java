package org.xjosiah.common;

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

    public void setLeftChild(MyTreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(MyTreeNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    public T getValue() {
        return value;
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

}
