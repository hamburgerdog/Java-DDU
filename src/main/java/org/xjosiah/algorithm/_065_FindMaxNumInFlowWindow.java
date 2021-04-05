package org.xjosiah.algorithm;

import java.util.*;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3,那么一共存在6个滑动窗口, 他们的最大值分别为{4,4,6,6,6,5}；
 * <p>
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个
 * {[2,3,4],2,6,2,5,1}，最大值4 {2,[3,4,2],6,2,5,1}，最大值4
 * {2,3,[4,2,6],2,5,1}，最大值6 {2,3,4,[2,6,2],5,1}，最大值6
 * {2,3,4,2,[6,2,5],1}，最大值6 {2,3,4,2,6,[2,5,1]}，最大值5
 *
 * @author xjosiah
 * @since 2021/4/5
 */
public class _065_FindMaxNumInFlowWindow {
    /**
     * 利用最大堆维护数据
     *
     * @param input 源数组
     * @return 所有滑动窗口里数值的最大值的数组
     */
    static ArrayList<Integer> collectNumsByMaxHeap(int[] input) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            if (maxHeap.size() < 2) {
                maxHeap.add(input[i]);
                continue;
            }
            maxHeap.add(input[i]);
            if (maxHeap.size() > 3) maxHeap.remove(input[i - 3]);
            result.add(maxHeap.peek());
        }
        return result;
    }

    /**
     * 利用双端队列维护数据
     *
     * @param input 源数组
     * @return 所有滑动窗口里数值的最大值的数组
     */
    static ArrayList<Integer> collectNumsByDeque(int[] input) {
        ArrayList<Integer> indexArray = new ArrayList<>();  //  存放下标
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < input.length; i++) {
            if (!deque.isEmpty()) {
                Iterator<Integer> iterator = deque.iterator();
                while (iterator.hasNext()) {
                    Integer index = iterator.next();
                    if (input[index] < input[i]) iterator.remove();
                    else {
                        if (index < (i - 2)) {
                            iterator.remove();
                        }
                    }
                }
            }
            deque.add(i);
            if (i >= 2) indexArray.add(deque.peekFirst());
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (Integer index : indexArray) {
            result.add(input[index]);
        }
        return result;
    }

}
