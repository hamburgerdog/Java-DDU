package org.xjosiah.algorithm;

import org.xjosiah.common.MyTreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 根据先序中序生成二叉树
 * 先序{1, 2, 4, 7, 3, 5, 6, 8}
 * 中序{4, 7, 2, 1, 5, 3, 8, 6}
 *
 * @author xjosiah
 * @since 2021/3/15
 */
public class _006_CreateBinaryTree {

    private final List<Integer> midList;
    private final List<Integer> preList;

    private final Iterator<Integer> preIterator;

    public _006_CreateBinaryTree(List<Integer> preList, List<Integer> midList) {
        this.preList = preList;
        this.midList = midList;
        this.preIterator = this.preList.iterator();
    }

    ArrayList<Integer> createBTreeAndCollectInListByBackward() {
        if (midList.size() == 0 || preList.size() == 0 || midList.size() != preList.size()) {
            System.err.println("输入数组错误，请重新输入并检查！");
            return new ArrayList<>();
        }

        if (!Arrays.equals(
                preList.stream().sorted().mapToInt(Integer::intValue).toArray(),
                midList.stream().sorted().mapToInt(Integer::intValue).toArray())
        ) {
            System.err.println("输入的数组含有的节点数据不一样，请重新检查");
            return new ArrayList<>();
        }

        MyTreeNode<Integer> rootTreeNode = findNodeInChildList(midList);

        ArrayList<Integer> ordList = new ArrayList<>();
        getNodeListByOrder(ordList, rootTreeNode);
        return ordList;
    }

    /**
     * 从给定的数组中找到根结点
     *
     * @param childList 左子树或者右子树：从midList中得到
     * @return 子树的根节点
     */
    private MyTreeNode<Integer> findNodeInChildList(List<Integer> childList) {
        Integer nodeValue = nextPreListValue();
        MyTreeNode<Integer> treeNode = new MyTreeNode<>(nodeValue);
        int nodeIndex = childList.indexOf(nodeValue);

        if (nodeIndex <= 0) {
            treeNode.setLeftChild(null);
        } else {
            treeNode.setLeftChild(findNodeInChildList(childList.subList(0, nodeIndex)));
        }

        if (nodeIndex >= childList.size() - 1) {
            treeNode.setRightChild(null);
        } else {
            treeNode.setRightChild(findNodeInChildList(childList.subList(nodeIndex + 1, childList.size())));
        }

        return treeNode;
    }

    /**
     * 操作迭代器从先序遍历得到节点
     *
     * @return 节点的值
     */
    private Integer nextPreListValue() {
        Integer result = null;
        if (preIterator.hasNext()) {
            result = preIterator.next();
            //  此处删除并没有太大作用，只是为了提醒容器应当使用迭代器进行数据操作
            //  preIterator.remove();
        }
        return result;
    }

    /**
     * 得到后序的二叉树数组
     *
     * @param node 根节点
     */
    private void getNodeListByOrder(ArrayList<Integer> ordList, MyTreeNode<Integer> node) {
        if (node.hasLeftChild()) getNodeListByOrder(ordList, node.getLeftChild());
        if (node.hasRightChild()) getNodeListByOrder(ordList, node.getRightChild());
        ordList.add(node.getValue());
    }

}
