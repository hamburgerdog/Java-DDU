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

    /**
     * 根据值来设置子树
     * @param leftValue 左子树的值 | 使用时可以为null，即根据泛型限制应该使用包装类
     * @param rightValue 右子树的值 | 同上
     * @return  返回设置完子树的当前节点
     */
    public MyTreeNode<T> setChildTreeNodeByValue(T leftValue, T rightValue) {
        this.setLeftChild(new MyTreeNode<>(leftValue));
        this.setRightChild(new MyTreeNode<>(rightValue));
        return this;
    }
}
