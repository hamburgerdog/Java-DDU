package org.xjosiah.algorithm;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * @author xjosiah
 * @since 2021/3/19
 */
public class _014_ReOrderArray {
    /**
     * 冒泡算法排序
     *
     * @param list 需要排序的数组
     */
    static int[] reOrderArrayByPop(int[] list) {
        if (list == null) throw new IllegalArgumentException("请勿传入空对象");
        boolean isOrderly = false;

        int tempUsed2ExchangeInWhile;
        while (!isOrderly) {
            //  只要不需要交换则说明有序
            isOrderly = true;

            for (int i = 0; i < list.length - 1; i++) {
                if (isEven(list[i]) && !isEven(list[i + 1])) {
                    tempUsed2ExchangeInWhile = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = tempUsed2ExchangeInWhile;
                    isOrderly = false;
                }
            }
        }
        return list;
    }

    /**
     * 用两个数组存放的比较浪费空间的方法
     *
     * @param list 待排序的数组
     * @return 排序完成的结果
     */
    static int[] reOrderArrayQuicklyButCostly(int[] list) {
        if (list == null) throw new IllegalArgumentException("请勿传入空对象");
        ArrayList<Integer> evenList = new ArrayList<>();
        ArrayList<Integer> primeList = new ArrayList<>();

        for (int value : list) {
            if (isEven(value)) evenList.add(value);
            else primeList.add(value);
        }

        primeList.addAll(evenList);

        //  int[] -> List 的方法
        //      Arrays.stream(list).boxed().collect(Collectors.toList());
        //  转化ArrayList -> int[] 的方法
        return primeList.stream().mapToInt(e -> e).toArray();
    }

    /**
     * 判断参数是否为偶数
     *
     * @param i 参数
     * @return 参数是否为偶数
     */
    private static boolean isEven(int i) {
        return i % 2 == 0;
    }
}
