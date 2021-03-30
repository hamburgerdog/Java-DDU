package org.xjosiah.algorithm;

import org.xjosiah.common.MyLinkedNode;

/**
 * 有n个小朋友围成一个圈，编号从「0~n-1」排序后进行游戏，报数『0~m-1』
 * 每次报到m-1的同学就淘汰，求最后一位获胜者是几号？
 *
 * @author xjosiah
 * @since 2021/3/30
 */
public class _045_LastRemainChildren {
    /**
     * 这里的链表头节点是空节点！！！谨记
     */
    private static final MyLinkedNode<Integer> rootNode = new MyLinkedNode<>();
    private static final MyLinkedNode<Integer> lastNode;

    private static final int N = 10;
    private static final int M = 3;

    //  构造环形队列
    static {
        lastNode = MyLinkedNode.createLink(rootNode, 0, N);
    }

    public static void main(String[] args) {
        System.out.println(loopInLoopedLinked(M, rootNode.getNext(), lastNode));
//        System.out.println(findNumByJosephus(N, M));
    }

    /*
        f[i] = (f[i - 1] + m) mod i;
        据说这个公式可以快速求出对应的i，但真看不懂。。。。也按公式也无法有效求解。。。
     */
//    private static int findNumByJosephus(int n, int m) {
//        if (n < 1 || m < 1) throw new IllegalArgumentException("参数错误");
//
//        int result = 0;
//        for (int i = 2; i <= n; i++) {
//            result = (result + m) % i;
//        }
//        return result;
//    }

    /**
     * 构建循环队列法：每次在m-2时把m-1移出即可，主要关注每次循环中要步进的步数
     *
     * @param m        第M号
     * @param rootNode 根节点
     * @param lastNode 尾节点
     * @return 获胜节点的值
     */
    private static int loopInLoopedLinked(int m, MyLinkedNode<Integer> rootNode, MyLinkedNode<Integer> lastNode) {
        //  形成环形队列
        lastNode.setNext(rootNode);
        MyLinkedNode<Integer> node = rootNode;
        while (node.getNext() != null) {
            for (int i = 0; i < m - 2; i++) {
                node = node.getNext();
            }
            removeNextNodeInLoopLink(node);
        }
        return node.getValue();
    }

    /**
     * 根据当前节点移出循环队列中的下一个节点
     *
     * @param node 当前节点「m-2号节点」
     */
    private static void removeNextNodeInLoopLink(MyLinkedNode<Integer> node) {
        MyLinkedNode<Integer> nextNode = node.getNext();
        node.setNext(node.equals(nextNode.getNext()) ? null : nextNode.getNext());
    }
}
