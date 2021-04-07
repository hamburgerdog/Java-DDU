package org.xjosiah.algorithm;

import java.util.Stack;

/**
 * 使用两个堆栈来模仿队列的 pop 和 push 操作
 *
 * @author xjosiah
 * @since 2021/3/16
 */
public class _007_Stacks2ImitateQueue {
    private final Stack<Integer> storeStack = new Stack<>();
    private final Stack<Integer> flowStack = new Stack<>();

    /**
     * 模拟队列的push操作
     *
     * @param value 存入的值
     * @return 操作成功与否
     */
    boolean push(int value) {
        if (!flowStack.empty()) return false;

        storeStack.push(value);
        return true;
    }

    /**
     * 模拟队列弹出操作
     *
     * @return 弹出值
     */
    Integer pop() {
        if (!flowStack.empty() || storeStack.empty()) return null;

        while (!storeStack.empty()) {
            flowStack.push(storeStack.pop());
        }

        Integer value = flowStack.pop();

        while (!flowStack.empty()) {
            storeStack.push(flowStack.pop());
        }

        return value;
    }

}
