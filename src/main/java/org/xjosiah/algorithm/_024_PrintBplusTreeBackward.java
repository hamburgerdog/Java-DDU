package org.xjosiah.algorithm;

import org.xjosiah.common.MyTreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 *
 * @author xjosiah
 * @since 2021/3/23
 */
public class _024_PrintBplusTreeBackward {
    private static final MyTreeNode<Integer> rootTreeNode = new MyTreeNode<>(12);
    private static final ArrayList<Integer> result = new ArrayList<>(Arrays.asList(2, 9, 5, 16, 17, 15, 19, 18, 12));

    static {
        rootTreeNode.setChildTreeNodeByValue(5, 18);
        rootTreeNode.getLeftChild().setChildTreeNodeByValue(2, 9);
        rootTreeNode.getRightChild().setChildTreeNodeByValue(15, 19);
        rootTreeNode.getRightChild().getLeftChild().setChildTreeNodeByValue(null, 17);
        rootTreeNode.getRightChild().getLeftChild().getRightChild().setChildTreeNodeByValue(16, null);
    }

    public static void main(String[] args) {
        System.out.println(WhetherIsResultList(rootTreeNode));
    }

    /**
     * 递归判断序列：
     * 根据后序遍历和B+树的特点（左右根）可知道，左子树中的值一定小于当前值，右子树则一定大于，
     * 等待测试是否符合后序遍历规则的数组中，可以根据左右子节点的值来进行区分左右子树。
     * 如从根节点12开始，左子节点为5，则[2, 9, 5]中的都应该小于12，而右子节点为18，则[16, 17, 15, 19, 18]都大于12。
     *
     * @param node 本次待比较的节点
     * @return 测试数组是否符合后序遍历规则
     */
    private static boolean WhetherIsResultList(MyTreeNode<Integer> node) {
        if (node == null) return true;

        Integer value = node.getValue();
        MyTreeNode<Integer> leftChild = node.getLeftChild();
        MyTreeNode<Integer> rightChild = node.getRightChild();
        List<Integer> leftChildList;
        List<Integer> rightChildList;
        try {
            if (leftChild != null) {
                leftChildList = result.subList(0, result.indexOf(leftChild.getValue()) + 1);
                //  最大都小于则说明全部小于
                if (leftChildList.stream().max(Integer::compareTo).get() >= value) return false;
                if (!WhetherIsResultList(leftChild)) return false;
            }
            if (rightChild != null) {
                rightChildList = result.subList(result.indexOf(rightChild.getValue()), result.indexOf(value));
                //  最小都大于则说明全部大于
                if (rightChildList.stream().min(Integer::compareTo).get() <= value) return false;
                if (!WhetherIsResultList(rightChild)) return false;
            }
        } catch (IllegalArgumentException e) {
            //  正常情况不会出错，划分子数组时出错说明不符合规则
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
}
