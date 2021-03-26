package org.xjosiah.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
 * 超过数组长度的一半，因此输出2。如果不存在则输出0
 *
 * @author xjosiah
 * @since 2021/3/26
 */
public class _029_MoreThanHalfNum {
    //    private static int[] origin = {5, 5, 1, 2};
    private static int[] origin = {1, 2, 3, 2, 2, 2, 5, 4, 2};

    public static void main(String[] args) {
        System.out.println(findNumInSortedArray(origin));
        System.out.println(findTheNumMoreThanHalfInArray(origin));
        System.out.println(findTheNumByMap(origin));
    }

    /**
     * 先将待查找的数组进行排序 这样可以缩短查找的时间
     *
     * @param array 源数组
     * @return 查找结果，失败返回 Integer.MIN_VALUE
     */
    private static int findNumInSortedArray(int[] array) {
        List<Integer> list = Arrays.stream(array).boxed().sorted().collect(Collectors.toList());
        int count = 0;
        int value = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (value != list.get(i)) {
                value = list.get(i);
                count = 1;
                continue;
            }
            count++;
            if (count > list.size() / 2) return list.get(i);
            //  剩余长度不足以让当前元素出现的次数超过数组一半则直接返回以减少循环次数
            if (count + (list.size() - i - 1) <= list.size() / 2) return Integer.MIN_VALUE;
        }
        return Integer.MIN_VALUE;
    }

    /**
     * 哨兵法：第一次循环 先找出数组中出现次数可能大于一半的数
     * 第二次循环 把记录数组中该数出现的频率，大于一半说明已经找到。
     *
     * @param array 源数组
     * @return 查找结果，失败返回 Integer.MIN_VALUE
     */
    private static int findTheNumMoreThanHalfInArray(int[] array) {
        int soldier = Integer.MIN_VALUE;
        int count = 0;
        for (int value : array) {
            if (soldier == Integer.MIN_VALUE) soldier = value;
            if (soldier == value) {
                count++;
                continue;
            }
            count--;
            if (count == 0) {
                soldier = value;
                count++;
            }
        }

        count = 0;
        for (int value : array) {
            if (value == soldier) count++;
            if (count > array.length / 2) {
                return soldier;
            }
        }
        return Integer.MIN_VALUE;
    }

    /**
     * 利用HashMap来记录数组中每个数字出现的次数
     * 最后比较HashMap中出现次数最多的数字的长度是否大于数组的一半。
     *
     * @param array 待查找的数组
     * @return 查询结果，查询失败返回Integer.MIN_VALUE
     */
    private static int findTheNumByMap(int[] array) {
        HashMap<Integer, Integer> resultMap = new HashMap<>();
        for (int value : array) {
            putNumInMap(resultMap, value);
        }

        Integer resultKey = resultMap.keySet().stream()
                .max(Comparator.comparingInt(resultMap::get)).get();

        return resultMap.get(resultKey) > (array.length / 2) ? resultKey : Integer.MIN_VALUE;
    }

    /**
     * 把当前值放入HashMap中进行值累计操作
     *
     * @param resultMap 结果表
     * @param key       表中键
     */
    private static void putNumInMap(HashMap<Integer, Integer> resultMap, int key) {
        Integer value = resultMap.get(key);
        if (value == null) value = 0;
        resultMap.put(key, value + 1);
    }
}
