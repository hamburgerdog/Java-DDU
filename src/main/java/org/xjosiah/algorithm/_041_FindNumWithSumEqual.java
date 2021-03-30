package org.xjosiah.algorithm;

import java.util.ArrayList;
import java.util.stream.IntStream;

/**
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 *
 * @author xjosiah
 * @since 2021/3/30
 */
public class _041_FindNumWithSumEqual {
    private static final int KEY = 100;
    private static final int[] origin = IntStream.range(1, 100).toArray();

    public static void main(String[] args) {
        ArrayList<Integer> num = findNum(KEY, origin);
        System.out.println(num.toString());
    }

    /**
     * 缩进法：如果当前序列总和比KEY大，则缩小一位，如果比KEY小，则步长一位
     * 当序列只有一个元素时，说明已经等于KEY本身，直接退出即可，如果遍历了所有即序列已经步出源数组则说明没有符合的情况
     *
     * @param key   要找的相应答案
     * @param array 源数组
     * @return 按顺序存放序列的容器
     */
    private static ArrayList<Integer> findNum(int key, int[] array) {
        if (array.length < 2) throw new IllegalArgumentException("数组太小");
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0, j = 1;
        int sum = array[i] + array[j];
        while (j < array.length - 1) {
            if (sum < key) {
                j++;
                sum += array[j];
            } else if (sum > key) {
                sum -= array[i];
                i++;
            }

            if (i == j) break;

            if (sum == key) {
                for (int k = i; k <= j; k++) {
                    result.add(array[k]);
                }
                j++;
                if (j < array.length) sum += array[j];
            }
        }
        return result;
    }
}
