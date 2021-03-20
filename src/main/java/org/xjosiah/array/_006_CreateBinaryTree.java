package org.xjosiah.array;

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

    private static List<Integer> preList = new ArrayList<>(Arrays.asList(1, 2, 4, 7, 3, 5, 6, 8));
    private static List<Integer> midList = new ArrayList<>(Arrays.asList(4, 7, 2, 1, 5, 3, 8, 6));
    private static List<Integer> ordList = new ArrayList<>();

    private static Iterator<Integer> preIterator = preList.iterator();

    private static MyTreeNode<Integer> rootTreeNode;        //  根节点

    public static void main(String[] args) {
        Integer rootNodeValue = nextPreListValue();

        rootTreeNode = new MyTreeNode<>(rootNodeValue);
        int rootIndexInMidList = midList.indexOf(rootNodeValue);

        rootTreeNode.setLeftChild(findNodeInChildList(midList.subList(0, rootIndexInMidList)));
        rootTreeNode.setRightChild(findNodeInChildList(midList.subList(rootIndexInMidList + 1, midList.size())));

        getNodeListByOrder(rootTreeNode);
        System.out.println(ordList);
    }

    /**
     * 从给定的数组中找到根结点
     *
     * @param childList 左子树或者右子树：从midList中得到
     * @return 子树的根节点
     */
    private static MyTreeNode<Integer> findNodeInChildList(List<Integer> childList) {
        Integer nodeValue = nextPreListValue();
        MyTreeNode<Integer> treeNode = new MyTreeNode<>(nodeValue);
        int nodeIndex = childList.indexOf(nodeValue);

        if (nodeIndex == 0) {
            treeNode.setLeftChild(null);
        } else {
            treeNode.setLeftChild(findNodeInChildList(childList.subList(0, nodeIndex)));
        }

        if (nodeIndex == childList.size() - 1) {
            treeNode.setRightChild(null);
        } else {
            treeNode.setRightChild(findNodeInChildList(childList.subList(nodeIndex + 1, childList.size())));
        }

        return treeNode;
    }

    /**
     * 操作迭代器从先序遍历得到节点
     *
     * @return  节点的值
     */
    private static Integer nextPreListValue() {
        Integer result = null;
        if (preIterator.hasNext()) {
            result = preIterator.next();
            preIterator.remove();           //  此处删除并没有太大作用，只是为了提醒容器应当使用迭代器进行数据操作
        }
        return result;
    }

    /**
     * 得到倒序的二叉树数组
     * @param node  根节点
     */
    private static void getNodeListByOrder(MyTreeNode<Integer> node) {
        if (node.hasLeftChild()) getNodeListByOrder(node.getLeftChild());
        if (node.hasRightChild()) getNodeListByOrder(node.getRightChild());
        ordList.add(node.getValue());
    }

}
