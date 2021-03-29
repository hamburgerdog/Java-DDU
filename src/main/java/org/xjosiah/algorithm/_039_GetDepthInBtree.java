package org.xjosiah.algorithm;

import org.xjosiah.common.MyTreeNode;

import java.util.stream.IntStream;

/**
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * @author xjosiah
 * @since 2021/3/29
 */
public class _039_GetDepthInBtree {
    private static final int TREE_SIZE = 64;
    private static final MyTreeNode<Integer> rootNode =
            MyTreeNode.createTreeByArray(IntStream.range(0, TREE_SIZE).toArray());

    public static void main(String[] args) {
        System.out.println(findBTreeDepth(rootNode, 0));
    }

    /**
     * 递归求树深度
     *
     * @param node  树节点
     * @param depth 当前深度
     * @return 返回左右子树中最长的那一个
     */
    private static int findBTreeDepth(MyTreeNode<Integer> node, int depth) {
        if (node == null) return depth;
        int leftDepth = findBTreeDepth(node.getLeftChild(), depth + 1);
        int rigthDepth = findBTreeDepth(node.getRightChild(), depth + 1);
        return Math.max(leftDepth, rigthDepth);
    }
}
