package org.xjosiah.array;

import java.util.Arrays;
import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 *
 * @author xjosiah
 * @since 2021/3/22
 */
public class _021_StackWithFunc_Min_ {
    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();
    private static final int RAND_NUM = 16;

    public static void main(String[] args) {
        _021_StackWithFunc_Min_ stackWithFuncMin = new _021_StackWithFunc_Min_();

        for (int i = 0; i < RAND_NUM; i++) {
            stackWithFuncMin.push((int) (Math.random() * RAND_NUM));
        }
        stackWithFuncMin.printStack();
        System.out.println("The min num in stack is : " + stackWithFuncMin.min() + "\n");
        for (int i = 0; i < RAND_NUM; i++) {
            System.out.print("pop [ " + stackWithFuncMin.pop() + " ] -> ");
            System.out.print("The min num in stack is : " + stackWithFuncMin.min() + "\n");
        }
    }

    public void push(int element) {
        dataStack.push(element);

        if (minStack.empty()) {
            minStack.push(element);
            return;
        }

        int min = minStack.pop();
        minStack.push(Math.min(min, element));
    }

    public int pop() {
        if (dataStack.empty()) throw new RuntimeException("数据栈已经空了，无法再弹出");

        //  提前返回有助于消除if嵌套
        int pop = dataStack.pop();
        if (minStack.peek() != pop) return pop;

        minStack.clear();   //  这步不能放在判数据栈空之后，否则min栈中最后一个数据不会被同步清除
        if (dataStack.empty()) return pop;

        Integer[] temp = dataStack.toArray(new Integer[0]);
        minStack.push(Arrays.stream(temp).min(Integer::compareTo).get());
        return pop;
    }

    public int min() {
        if (minStack.empty()) throw new RuntimeException("栈中已经没有数据了，无法查找最小值");
        return minStack.peek();
    }

    public void printStack() {
        String resultStr = Arrays.toString(dataStack.toArray(new Integer[0]));
        System.out.println(resultStr);
    }
}
