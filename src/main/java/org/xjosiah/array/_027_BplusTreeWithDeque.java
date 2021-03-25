package org.xjosiah.array;

import org.xjosiah.common.MyTreeNode;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 * @author xjosiah
 * @since 2021/3/25
 */
public class _027_BplusTreeWithDeque {
    /*
        在转换成Deque后 leftChild -> beforeNode | rightChild -> behindNode
     */
    private static MyTreeNode<Integer> rootTreeNode = new MyTreeNode<>(12);

    /*
                    12
                   /  \
                  5   18
                 / \  / \
                2  9 15  19
                      \
                      17
                      /
                     16
     */
    static {
        rootTreeNode.setChildTreeNodeByValue(5, 18);
        rootTreeNode.getLeftChild().setChildTreeNodeByValue(2, 9);
        rootTreeNode.getRightChild().setChildTreeNodeByValue(15, 19);
        rootTreeNode.getRightChild().getLeftChild().setChildTreeNodeByValue(null, 17);
        rootTreeNode.getRightChild().getLeftChild().getRightChild().setChildTreeNodeByValue(16, null);
    }

    public static void main(String[] args) {
        MyTreeNode<Integer> dequeNode = changeTree2Deque(rootTreeNode, null);
        while (dequeNode!=null){
            System.out.print(dequeNode.getValue()+" ");
            dequeNode = dequeNode.getLeftChild();
        }
    }

    /**
     * 中序遍历，左子树前插，右子树后插就可完成
     *
     * @param treeNode 当前节点
     * @param lastNode 当前排序链表的尾节点
     * @return lastNode
     */
    private static MyTreeNode<Integer> changeTree2Deque(MyTreeNode<Integer> treeNode, MyTreeNode<Integer> lastNode) {
        if (treeNode == null) return lastNode;

        lastNode = changeTree2Deque(treeNode.getLeftChild(), lastNode);
        treeNode.setLeftChild(lastNode);
        if (lastNode == null) {
            lastNode = treeNode;
        } else {
            lastNode.setRightChild(treeNode);
            lastNode = treeNode;
        }

        return changeTree2Deque(treeNode.getRightChild(), lastNode);
    }
}

