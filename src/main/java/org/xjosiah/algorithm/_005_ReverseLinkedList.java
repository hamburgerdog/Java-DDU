package org.xjosiah.algorithm;

import org.xjosiah.common.MyLinkedNode;

/**
 * @author xjosiah
 * @since 2021/3/3
 */
public class _005_ReverseLinkedList {
    /**
     * 递归方式输出反转后的单链表
     * （另一种可采用的方式为：使用栈来存放顺序读取的数据再输出）
     * PS： LinkedList 是 双端链表
     *
     * @param node 起始节点
     */
    static void reverse(StringBuilder sb, MyLinkedNode<Character> node) {
        if (sb == null) {
            System.err.println("StringBuilder为空 请检查输入！");
            return;
        }
        if (node.getNext() != null) {
            reverse(sb, node.getNext());
        }
        System.out.println(node);
        sb.append(node.getValue()).append(" ");
    }
}
