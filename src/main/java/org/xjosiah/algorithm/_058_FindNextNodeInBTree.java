package org.xjosiah.algorithm;

import org.xjosiah.common.MyTreeNode;

import java.util.stream.IntStream;

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 *
 * @author xjosiah
 * @since 2021/4/2
 */
public class _058_FindNextNodeInBTree {
    private static MyTreeNode<Integer> rootTreeNode = MyTreeNode.createTreeByArray(IntStream.range(1, 17).toArray());

    public static void main(String[] args) {
        System.out.println(findNextNodeByMid(rootTreeNode, 11));
    }

    /**
     * 中序遍历的时候为了标志当前已经返回使用了Integer.MIN_VALUE做特殊标志，可以用boolean但是需要全局标识
     * 另一种最简便的方法是中序入全局容器 用空间换时间
     * 算法核心为：
     * 1、如果当前结点有右子树, 那么其中序遍历的下一个结点就是其右子树的最左结点
     * 2、如果当前结点没有右子树, 而它是其父结点的左子结点那么其中序遍历的下一个结点就是他的父亲结点
     * 3、如果当前结点没有右子树，而它还是其父结点的右子结点，这种情况下其下一个结点应该是当前结点所在的左子树的根,
     * 因此我们可以顺着其父节点一直向上遍历, 直到找到一个是它父结点的左子结点的结点。
     *
     * @param rootNode 起始节点
     * @param key      要找的节点值
     * @return 下一个节点值，如果没有则为null
     */
    private static Integer findNextNodeByMid(MyTreeNode<Integer> rootNode, int key) {
        if (rootNode == null) return null;

        Integer result = findNextNodeByMid(rootNode.getLeftChild(), key);
        //  如果左子树返回了一个特殊值，说明当前节点的值是要找的下一个节点值
        if (result != null) return result == Integer.MIN_VALUE ? rootNode.getValue() : result;

        if (key == rootNode.getValue()) {
            //  有右子树返回右子树最左子节点的值
            if (rootNode.getRightChild() != null) {
                MyTreeNode<Integer> node = rootNode.getRightChild();
                while (node.getLeftChild() != null) {
                    node = node.getLeftChild();
                }
                return node.getValue();
            }
            //  返回特殊标记位
            return Integer.MIN_VALUE;
        }

        //  右节点返回即可
        return findNextNodeByMid(rootNode.getRightChild(), key);
    }
}
