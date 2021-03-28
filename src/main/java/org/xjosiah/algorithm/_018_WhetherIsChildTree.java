package org.xjosiah.algorithm;

import org.xjosiah.common.MyTreeNode;

/**
 * 输入两颗二叉树A，B，判断B是不是A的子结构。
 *
 * @author xjosiah
 * @since 2021/3/21
 */
public class _018_WhetherIsChildTree {
    private static final MyTreeNode<Integer> bigTreeRootNode = new MyTreeNode<>(0);
    private static final MyTreeNode<Integer> testTreeRootNode = new MyTreeNode<>(2);

    public static void main(String[] args) {
        initBigTree();
        initTestTree();

        System.out.println(isSameTree(findBeginNodeInBigTree(bigTreeRootNode), testTreeRootNode));
    }

    /**
     * 从父树中寻找是否有要测试的子树的根节点，找到可以开始判断两颗树是否完全一致
     *
     * @param node 递归过程中当前的节点
     * @return 返回父树中与子树根节点值相同的一个节点
     */
    private static MyTreeNode<Integer> findBeginNodeInBigTree(MyTreeNode<Integer> node) {
        if (node == null) return null;

        if (node.getValue().equals(testTreeRootNode.getValue())) return node;

        MyTreeNode<Integer> resultNode;
        if ((resultNode = findBeginNodeInBigTree(node.getLeftChild())) != null) {
            return resultNode;
        }
        if ((resultNode = findBeginNodeInBigTree(node.getRightChild())) != null) {
            return resultNode;
        }
        return null;
    }

    /**
     * 用递归方式判断两颗树是否相同
     *
     * @param bigTreeNode  父树中的节点
     * @param testTreeNode 用于判断的目的树的节点
     * @return 两颗树是否相同
     */
    private static boolean isSameTree(MyTreeNode<Integer> bigTreeNode, MyTreeNode<Integer> testTreeNode) {
        if (bigTreeNode == null && testTreeNode == null) {
            return true;
        }
        if (bigTreeNode == null || testTreeNode == null) {
            return false;
        }

        if (!bigTreeNode.getValue().equals(testTreeNode.getValue())) {
            return false;
        }

        if (!isSameTree(bigTreeNode.getLeftChild(), testTreeNode.getLeftChild())) return false;
        return isSameTree(bigTreeNode.getRightChild(), testTreeNode.getRightChild());
    }

    /*
        ###################  以下为初始化数据操作  #######################
     */
    private static void initBigTree() {
        bigTreeRootNode.setChildTreeNodeByValue(1, 2);
        bigTreeRootNode.getLeftChild().setChildTreeNodeByValue(3, null);
        bigTreeRootNode.getLeftChild().getLeftChild().setChildTreeNodeByValue(7, null);
        bigTreeRootNode.getRightChild().setChildTreeNodeByValue(5, null);
        bigTreeRootNode.getRightChild().getRightChild().setChildTreeNodeByValue(9, 8);
    }

    private static void initTestTree() {
        testTreeRootNode.setChildTreeNodeByValue(5, null);
        testTreeRootNode.getRightChild().setChildTreeNodeByValue(9, 8);
    }
}
