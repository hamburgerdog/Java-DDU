package org.xjosiah.algorithm;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * 输入一个『复杂链表』 : 每个节点中有节点值，以及两个指针，
 * 一个指向下一个节点，另一个特殊指针指向任意一个节点
 * <p>
 * 要求你编写函数复制这个复杂链表
 *
 * @author xjosiah
 * @since 2021/3/24
 */
public class _026_CopyComplexLink {
    public static void main(String[] args) {
        MyComplexLinkNode<Integer> node = new MyComplexLinkNode<>(1, null);
        MyComplexLinkNode.createIntegerLink(node, 16);
        node.makeLinkBeComplex();
        node.printLink();

        MyComplexLinkNode<Integer> copyNode = copyComplexLink(node);
        copyNode.printLink();
        System.out.println();
    }

    /**
     * 复制特殊链表，时间复杂度只有「 O(n) 」
     * 算法过程为：
     * 第一次遍历在源节点后插入一个复制节点；
     * 第二次遍历将复制节点的随机指针根据源节点的指向进行更新；
     * 第三次将偶数位置节点抽离出来就是复制完成的节点。
     *
     * @param originLinkRootNode 源链表的起始节点
     * @return 复制完成的新链表的起始节点
     */
    private static MyComplexLinkNode<Integer> copyComplexLink(MyComplexLinkNode<Integer> originLinkRootNode) {
        MyComplexLinkNode<Integer> node = originLinkRootNode;
        while (node != null) {
            MyComplexLinkNode<Integer> nextPointer = node.getNextPointer();
            MyComplexLinkNode<Integer> copyNode = new MyComplexLinkNode<>(node.getValue(), nextPointer);
            node.setNextPointer(copyNode);
            node = nextPointer;
        }

        node = originLinkRootNode;
        int linkLength = 0;         //  记录源链表长度
        while (node != null) {
            MyComplexLinkNode<Integer> randomNodePointer = node.getRandomNodePointer();
            MyComplexLinkNode<Integer> copyRandomNodePointer = randomNodePointer.getNextPointer();

            MyComplexLinkNode<Integer> copyNode = node.getNextPointer();
            copyNode.setRandomNodePointer(copyRandomNodePointer);

            node = copyNode.getNextPointer();
            linkLength++;
        }

        node = originLinkRootNode;
        MyComplexLinkNode<Integer> copyRootLinkNode = node.getNextPointer();
        MyComplexLinkNode<Integer> copyNode = node.getNextPointer();
        for (int i = 0; i < linkLength - 1; i++) {
            node.setNextPointer(copyNode.getNextPointer());
            node = node.getNextPointer();
            copyNode.setNextPointer(node.getNextPointer());
            copyNode = copyNode.getNextPointer();
        }
        return copyRootLinkNode;
    }
}

class MyComplexLinkNode<T> {
    T value;
    MyComplexLinkNode<T> nextPointer;
    MyComplexLinkNode<T> randomNodePointer;

    public MyComplexLinkNode(T value, MyComplexLinkNode<T> nextPointer) {
        this.value = value;
        this.nextPointer = nextPointer;
    }

    /**
     * 将已创建链表的各个节点的随机指针进行更新（可指向自己）
     */
    public void makeLinkBeComplex() {
        ArrayList<MyComplexLinkNode<T>> list = new ArrayList<>();
        MyComplexLinkNode<T> node = this;
        while (node != null) {
            list.add(node);
            node = node.getNextPointer();
        }

        for (int i = 0; i < list.size(); i++) {
            int randomIndex = (int) (Math.random() * list.size());
            list.get(i).setRandomNodePointer(list.get(randomIndex));
        }
    }

    /**
     * 创建一个递增的Integer链表
     * 主要用于练习链表算法时，快速构建一条链表以提供数据。
     *
     * @param rootNode 链表头节点
     * @param length   要创建的链表长度
     */
    public static void createIntegerLink(MyComplexLinkNode<Integer> rootNode, int length) {
        System.out.println("Created_Link`s length is : " + length);
        MyComplexLinkNode<Integer> tempNode = rootNode;
        for (int i = 1; i < length; i++) {
            MyComplexLinkNode<Integer> node = new MyComplexLinkNode<>(i + 1, null);
            tempNode.setNextPointer(node);
            tempNode = node;
        }
    }

    /**
     * 根据头节点输出某一条链表,以数组形式展示
     */
    public void printLink() {
        ArrayList<MyComplexLinkNode<T>> list = new ArrayList<>();
        MyComplexLinkNode<T> node = this;
        while (node != null) {
            list.add(node);
            node = node.nextPointer;
        }
        System.out.println("\n######## PRINTING_LINK ########");
        System.out.println(list.stream().map(t -> t.value).collect(Collectors.toList()));
    }

    public T getValue() {
        return value;
    }

    public MyComplexLinkNode<T> getNextPointer() {
        return nextPointer;
    }

    public void setNextPointer(MyComplexLinkNode<T> nextPointer) {
        this.nextPointer = nextPointer;
    }

    public MyComplexLinkNode<T> getRandomNodePointer() {
        return randomNodePointer;
    }

    public void setRandomNodePointer(MyComplexLinkNode<T> randomNodePointer) {
        this.randomNodePointer = randomNodePointer;
    }

}
