package org.xjosiah.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 使用两个堆栈来模仿队列的 pop 和 push 操作
 *
 * @author xjosiah
 * @since 2021/3/16
 */
public class _007_Stacks2ImitateQueue {
    private static Stack<Integer> storeStack = new Stack<>();
    private static Stack<Integer> flowStack = new Stack<>();
    private static List<Integer> values = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

    public static void main(String[] args) {
        for (Integer value :
                values) {
            if (push(value) == false) {
                System.out.println(value + "插入错误！！");
                return;
            }
        }

        ArrayList<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < values.size(); i++) {
            resultList.add(pop());
        }

        if(resultList.contains(null))
            System.out.println("堆栈操作存在错误！！");
        else
            System.out.println(resultList);
    }

    /**
     * 模拟队列的push操作
     * @param value 存入的值
     * @return  操作成功与否
     */
    private static boolean push(int value) {
        if (!flowStack.empty()) return false;

        storeStack.push(value);
        return true;
    }

    /**
     * 模拟队列弹出操作
     * @return  弹出值
     */
    private static Integer pop() {
        if (!flowStack.empty()) return null;

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
