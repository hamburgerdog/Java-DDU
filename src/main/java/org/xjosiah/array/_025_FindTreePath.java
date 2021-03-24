package org.xjosiah.array;

import org.xjosiah.common.MyTreeNode;

/**
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径
 *
 * @author xjosiah
 * @since 2021/3/24
 */
public class _025_FindTreePath {
    private static MyTreeNode<Integer> rootNode = new MyTreeNode<>(1);

    public static void main(String[] args) {
        if (!findInTree(rootNode, null, 9)) {
            System.out.println("搜索完毕，没有对应的路径");
        }
    }

    /*
                1
               / \
              3   2
             / \ / \
            4  5 6  7
           /         \
          8           9
     */
    static {
        rootNode.setChildTreeNodeByValue(3, 2);

        rootNode.getLeftChild().setChildTreeNodeByValue(4, 5);
        rootNode.getRightChild().setChildTreeNodeByValue(6, 7);

        rootNode.getLeftChild().getLeftChild().setChildTreeNodeByValue(8, null);
        rootNode.getRightChild().getRightChild().setChildTreeNodeByValue(null, 9);
    }

    /**
     * 递归解法：数值递增，每次满足时就回退逐层输出当前值
     *
     * @param node   当前节点
     * @param sum    当前节点与父爷节点们的值的总和
     * @param answer 待求的值
     * @return 在当前这条路径中是否满足节点和与带求值相等
     */
    private static boolean findInTree(MyTreeNode<Integer> node, Integer sum, int answer) {
        if (node == null) return false;

        if (sum == null) sum = node.getValue();
        else sum += node.getValue();

        if (answer == sum) {
            System.out.print("  " + node.getValue());
            return true;
        }

        //  保存结果不返回，如果在这里返回，只会求出一条满足情况的路径
        boolean leftResult;
        if (leftResult = findInTree(node.getLeftChild(), sum, answer)) {
            System.out.print("  " + node.getValue());
        }

        //  二叉树中每个节点可以从左右节点分成两条「大路径」 在其中一条满足的情况下不应该对另一条产生影响。
        boolean rightResult;
        if (rightResult = findInTree(node.getRightChild(), sum, answer)) {
            System.out.print("  " + node.getValue());
        }

        //  位操作显然更快
        return leftResult | rightResult;
    }

}
