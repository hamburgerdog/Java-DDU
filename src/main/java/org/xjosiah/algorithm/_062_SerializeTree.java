package org.xjosiah.algorithm;

import org.xjosiah.common.MyTreeNode;

import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Base64;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 * 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，
 * 二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
 *
 * @author xjosiah
 * @since 2021/4/3
 */
public class _062_SerializeTree {
    private static final Base64.Decoder DECODER = Base64.getDecoder();
    private static final Base64.Encoder ENCODER = Base64.getEncoder();

    /**
     * 根据根节点先序遍历生成序列化后的树的字符串
     *
     * @param rootNode 根节点
     * @return 序列字符串串
     */
    static String serializeTree(MyTreeNode<Integer> rootNode) {
        StringBuilder result = new StringBuilder();

        MyTreeNode<Integer> leftChild = rootNode.getLeftChild();
        MyTreeNode<Integer> rightChild = rootNode.getRightChild();
        result.append(rootNode.getValue());
        result.append(" ");
        result.append(leftChild == null ? "#" : leftChild.getValue());
        result.append(" ");
        result.append(rightChild == null ? "#" : rightChild.getValue());
        result.append(",");

        if (leftChild != null) result.append(serializeTree(leftChild));
        if (rightChild != null) result.append(serializeTree(rightChild));

        return result.toString();
    }

    /**
     * 用Base64编码后的字符串，用于反序列化
     */
    static String serializeTreeReturnBase64(MyTreeNode<Integer> rootNode) {
        String result = serializeTree(rootNode);
        return ENCODER.encodeToString((result + ";").getBytes(StandardCharsets.UTF_8));
    }

    /**
     * 根据Base64编码后的序列化字符串来生成树
     *
     * @param serialize 序列化字符串
     * @return 根节点
     */
    static MyTreeNode<Integer> createTreeFromSerialize(String serialize) {
        serialize = new String(DECODER.decode(serialize), StandardCharsets.UTF_8);
        if (!serialize.endsWith(";")) {
            throw new IllegalArgumentException("输入字符串格式错误，无法解析");
        }
        String[] split = serialize.split(",");
        ArrayDeque<String> deque = new ArrayDeque<>();
        for (String s : split) {
            if (!";".equals(s)) deque.add(s);
        }
        return createTree(deque);
    }

    /**
     * 利用栈结构遍历先序遍历生成树
     *
     * @param deque 存放序列化字符组【节点 左节点 右节点】的栈
     * @return 当前子树的根节点
     */
    private static MyTreeNode<Integer> createTree(ArrayDeque<String> deque) {
        String treeNodeStr = deque.pollFirst();
        assert treeNodeStr != null;
        String[] nodes = treeNodeStr.split(" ");
        if (nodes.length != 3) throw new IllegalArgumentException(treeNodeStr + "输入错误，无法解析字符串");
        MyTreeNode<Integer> node = new MyTreeNode<>(Integer.valueOf(nodes[0]));
        if (!"#".equals(nodes[1])) {
            node.setLeftChild(createTree(deque));
        }
        if (!"#".equals(nodes[2])) {
            node.setRightChild(createTree(deque));
        }
        return node;
    }

}
