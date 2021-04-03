package org.xjosiah.algorithm;

import java.text.DecimalFormat;
import java.util.PriorityQueue;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 *
 * @author xjosiah
 * @since 2021/4/3
 */
public class _064_FindMidNumInIntStream {
    /**
     * 求中位数，利用最小堆（优先队列）即始终维护一个最小堆
     *
     * @param array 源数组
     * @return 字符串表示的精确到两位小数的数
     */
    static String getMidNumByMinHeap(int[] array) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i : array) {
            minHeap.add(i);
        }
        Integer[] resultArray = minHeap.toArray(new Integer[0]);

        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        int halfIndex = array.length / 2;
        if (array.length % 2 == 1) return decimalFormat.format(resultArray[halfIndex]);
        return decimalFormat.format((double) (resultArray[halfIndex] + resultArray[halfIndex - 1]) / 2);
    }
}
