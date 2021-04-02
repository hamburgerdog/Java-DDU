package org.xjosiah.algorithm;

import org.xjosiah.common.MyTreeNode;

import java.util.*;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行（与23题一致）
 * {8,6,10,5,7,9,11}
 * [[8],[6,10],[5,7,9,11]]
 *
 * @author xjosiah
 * @since 2021/4/2
 */
public class _060_PrintBTreeByLevel {
    private static ArrayDeque<MyTreeNode<Integer>> treeNodeDeque = new ArrayDeque<>();
    private static final ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();

    private static MyTreeNode<Integer> rootTreeNode = new MyTreeNode<>(1);

    /*
        初始化二叉树：     1
                        / \
                       2   3
                      / \   \
                     4   5   8
                        / \   \
                       6   7   9
                              / \
                             10  11
       output:  [[1], [2, 3], [4, 5, 8], [6, 7, 9], [10, 11]]
     */
    static {
        rootTreeNode.setChildTreeNodeByValue(2, 3);
        rootTreeNode.getLeftChild().setChildTreeNodeByValue(4, 5);
        rootTreeNode.getRightChild().setChildTreeNodeByValue(null, 8);
        rootTreeNode.getLeftChild().getRightChild().setChildTreeNodeByValue(6, 7);
        rootTreeNode.getRightChild().getRightChild().setChildTreeNodeByValue(null, 9);
        rootTreeNode.getRightChild().getRightChild().getRightChild().setChildTreeNodeByValue(10, 11);
    }

    public static void main(String[] args) {
        printfTreeByLevel(rootTreeNode);
        System.out.println(Arrays.deepToString(resultList.toArray()));
    }

    /**
     * 使用一个队列按层级逐层遍历二叉树
     *
     * @param rootNode 二叉树的根节点（起始节点）
     */
    private static void printfTreeByLevel(MyTreeNode<Integer> rootNode) {
        treeNodeDeque.push(rootNode);
        int level = 0;
        while (treeNodeDeque.size() != 0) {
            printLevel(treeNodeDeque.size(), level++);
        }
    }

    /**
     * 遍历当前层级，并将子节点从左到右存入到队列中，在for循环初始化时队列长度就是该层的节点总数
     * 遍历完毕即把所有本层节点都排空时，队列长度就是下层节点的节点总数，用ArrayList保存输出的结果
     *
     * @param nodeCountInThislevel 本层的节点总数
     * @param level 当前层级
     */
    private static void printLevel(int nodeCountInThislevel, int level) {
        ArrayList<Integer> resultArrayInThisLevel = new ArrayList<>();
        if (resultList.size() == level) {
            resultList.add(resultArrayInThisLevel);
        } else resultArrayInThisLevel = resultList.get(level);

        for (int i = 0; i < nodeCountInThislevel; i++) {
            MyTreeNode<Integer> node = treeNodeDeque.pollFirst();

            Optional.ofNullable(node).map(MyTreeNode::getValue).ifPresent(resultArrayInThisLevel::add);

            assert node != null;
            if (node.getLeftChild() != null) treeNodeDeque.addLast(node.getLeftChild());
            if (node.getRightChild() != null) treeNodeDeque.addLast(node.getRightChild());
        }
    }
}
