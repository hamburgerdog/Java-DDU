package org.xjosiah.algorithm;

import org.xjosiah.common.MyTreeNode;

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的
 *
 * @author xjosiah
 * @since 2021/4/2
 */
public class _059_WhetherSymmetricBTree {
    private static MyTreeNode<Integer> rootNode = new MyTreeNode<>(1);

    static {
        initTree(rootNode);
    }

    /*        #########二叉树的结构########
                            1
                           / \
                          2   2
                         / \ / \
                        3  4 4  3
                       / \     / \
                      5  6    6   5
                  9 ................. 9
     */
    private static void initTree(MyTreeNode<Integer> rootNode) {
        rootNode.setLeftChild(new MyTreeNode<>(2));
        rootNode.setRightChild(new MyTreeNode<>(2));

        MyTreeNode<Integer> leftNode = rootNode.getLeftChild();
        MyTreeNode<Integer> rightNode = rootNode.getRightChild();
        for (int i = leftNode.getValue() + 1; i < rootNode.getValue() + 10; i++) {
            if (leftNode.getLeftChild() == null) {
                leftNode.setLeftChild(new MyTreeNode<>(i));
                rightNode.setRightChild(new MyTreeNode<>(i));
            } else if (leftNode.getRightChild() == null) {
                leftNode.setRightChild(new MyTreeNode<>(i));
                rightNode.setLeftChild(new MyTreeNode<>(i));
            } else {
                leftNode = leftNode.getLeftChild();
                rightNode = rightNode.getRightChild();
                i--;
            }
        }
//        rightNode.getRightChild().setValue(11);
    }

    public static void main(String[] args) {
        System.out.println(isEqualStepByStep(rootNode.getLeftChild(), rootNode.getRightChild()));
    }

    /**
     * 递归判断，从左子树判断到右子树递归判断
     *
     * @param lNode 左子树起始节点
     * @param rNode 右子树起始节点
     * @return 相等与否
     */
    private static boolean isEqualStepByStep(MyTreeNode<Integer> lNode, MyTreeNode<Integer> rNode) {
        if (lNode == null && rNode == null) return true;
        else if (lNode == null || rNode == null) return false;

        if (!isEqualStepByStep(lNode.getLeftChild(), rNode.getRightChild())) return false;

        if (!isEqualStepByStep(lNode.getRightChild(), rNode.getLeftChild())) return false;

        return lNode.getValue().equals(rNode.getValue());
    }
}
