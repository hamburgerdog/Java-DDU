package org.xjosiah.array;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 *
 * @author xjosiah
 * @since 2021/3/22
 */
public class _022_WhetherIsPopArrayInStack {
    //  注意stack不能存放Integer.MIN_VALUE，否则算法会产生错误
    private static Stack<Integer> stack = new Stack<>();
    private static int[] popList = {4, 5, 6, 3, 2, 1};

    static {
        for (int i = 1; i <= 6; i++) {
            stack.push(i);
        }
    }

    public static void main(String[] args) {
        System.out.println(isOutputList(stack, popList));
    }

    /**
     * 和辅助栈不同的一种特殊比较方式：
     * 判断方法为：
     * 依次遍历需要判断的序列，获取该序列的当前值在栈插入顺序的位数（第几个插入），
     * 序列下一个值必定会出现在当前值在栈插入位置的前后某一位，
     * 成立 则把当前值从栈中弹出，继续判断序列下一位，
     * 否则 直接返回判断错误结果
     *
     * @param originStack 目的栈
     * @param testPopList 用于测试的输出序列
     * @return 该序列是否满足该栈的出栈顺序
     */
    public static boolean isOutputList(Stack<Integer> originStack, int[] testPopList) {
        if (originStack.size() != testPopList.length) return false;

        for (int i = 0; i < testPopList.length - 1; i++) {
            Integer beforeValue = Integer.MIN_VALUE;
            Integer behindValue = Integer.MIN_VALUE;
            int nowIndexInStack = originStack.indexOf(testPopList[i]);
            if (nowIndexInStack - 1 >= 0) {
                beforeValue = originStack.get(nowIndexInStack - 1);
            }
            if (nowIndexInStack + 1 < originStack.size()) {
                behindValue = originStack.get(nowIndexInStack + 1);
            }

            if (testPopList[i + 1] == behindValue || testPopList[i + 1] == beforeValue) {
                stack.remove(Integer.valueOf(testPopList[i]));
            } else
                return false;
        }
        return true;
    }
}
