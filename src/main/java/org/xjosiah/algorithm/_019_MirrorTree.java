package org.xjosiah.algorithm;

import org.xjosiah.common.MyTreeNode;

import java.util.Optional;
import java.util.Stack;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 *
 * @author xjosiah
 * @since 2021/3/21
 */
public class _019_MirrorTree {
    private static final MyTreeNode<Integer> originTree = new MyTreeNode<>(8);
    private static final MyTreeNode<Integer> mirrorTree = new MyTreeNode<>();

    public static void main(String[] args) {
        initOriginTree();
        swapNode(originTree, mirrorTree);
        swapTreeUsePre(mirrorTree, originTree);
        System.out.println("-------请在源代码此处打上断点用debug查看结果------");
    }

    /**
     * 递归镜像方法 -> 逐个交换节点
     *
     * @param originNode 源节点
     * @param mirrorNode 镜像节点
     */
    private static void swapNode(MyTreeNode<Integer> originNode, MyTreeNode<Integer> mirrorNode) {
        if (originNode == null) return;
        mirrorNode.setValue(originNode.getValue());

        Optional<Integer> originRightValue = Optional.of(originNode).map(MyTreeNode::getLeftChild).map(MyTreeNode::getValue);
        Optional<Integer> originLeftValue = Optional.of(originNode).map(MyTreeNode::getRightChild).map(MyTreeNode::getValue);

        mirrorNode.setLeftChild(new MyTreeNode<>(originRightValue.orElse(null)));
        mirrorNode.setRightChild(new MyTreeNode<>(originLeftValue.orElse(null)));

        swapNode(originNode.getLeftChild(), mirrorNode.getRightChild());
        swapNode(originNode.getRightChild(), mirrorNode.getLeftChild());
    }

    /**
     * 非递归先序镜像方法 -> 逐个交换节点
     *
     * @param originNode 源节点
     * @param mirrorNode 镜像节点
     */
    private static void swapTreeUsePre(MyTreeNode<Integer> originNode, MyTreeNode<Integer> mirrorNode) {
        mirrorNode.setValue(originNode.getValue());

        Stack<MyTreeNode<Integer>> nodeStack = new Stack<>();
        nodeStack.push(mirrorNode);
        nodeStack.push(originNode);

        while (!nodeStack.empty()) {
            MyTreeNode<Integer> originNodeFromStack = nodeStack.pop();
            MyTreeNode<Integer> mirrorNodeFromStack = nodeStack.pop();

            while (originNodeFromStack.getLeftChild() != null) {
                mirrorNodeFromStack.setChildTreeNodeByValue(originNodeFromStack.getRightChild().getValue(), originNodeFromStack.getLeftChild().getValue());

                //  按先序方法（根左右）构建镜像树遍历，所以要先把镜像树中的右暂存起来（对应的是源树的左）
                nodeStack.push(mirrorNodeFromStack.getRightChild());
                nodeStack.push(originNodeFromStack.getLeftChild());
                //  注意这两处的顺序
                mirrorNodeFromStack = mirrorNodeFromStack.getLeftChild();
                originNodeFromStack = originNodeFromStack.getRightChild();
            }
        }

    }

    /*
        ################# 初始化链表过程 ######################
     */
    private static void initOriginTree() {
        originTree.setChildTreeNodeByValue(6, 10);
        originTree.getLeftChild().setChildTreeNodeByValue(5, 7);
        originTree.getRightChild().setChildTreeNodeByValue(9, 11);
    }
}
