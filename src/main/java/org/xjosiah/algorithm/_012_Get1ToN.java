package org.xjosiah.algorithm;

import java.util.ArrayList;

/**
 * 给定一个数字N，打印从1到最大的N位数。
 * 如 n=1 则 1,2,3,4,5,6,7,8,9
 *
 * @author xjosiah
 * @since 2021/3/19
 */
public class _012_Get1ToN {
    /**
     * 字符串递归来解决大数据溢出的问题（全排列算法）
     * 参考文章：https://blog.csdn.net/qq_34980601/article/details/89918187
     *
     * @param N 要从1输出的最大的位数
     * @return 1到N位的所有数据
     */
    static ArrayList<Integer> print1ToN(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException("参数错误 N比1小");
        }
        int[] arr = new int[N];
        ArrayList<Integer> result = new ArrayList<>();
        set0To9ToArray_index_(result, arr, 0);
        return result;
    }

    /**
     * 递归算法的核心
     *
     * @param numInArray 存放当前排序的数字
     * @param index      具体指向arr中某一位
     */
    private static void set0To9ToArray_index_(ArrayList<Integer> list, int[] numInArray, int index) {
        if (index == numInArray.length) {
            Integer result = printIntArray(numInArray);
            if (result != null)
                list.add(result);
            return;
        }

        for (int i = 0; i < 10; i++) {
            numInArray[index] = i;
            set0To9ToArray_index_(list, numInArray, index + 1);
        }
    }

    /**
     * 输出arr
     *
     * @param arr 用于转化成当前数字的数组可看成char[] -> String
     * @return 当前遍历出的数值
     */
    private static Integer printIntArray(int[] arr) {
        boolean isRead = false;
        StringBuilder sb = new StringBuilder();
        for (int value : arr) {
            //  用于跳过最高为数是不是以0开始的位
            if (value != 0)
                isRead = true;
            if (isRead)
                sb.append(value);
        }
        if (sb.length() == 0) return null;
        return Integer.valueOf(sb.toString());
    }
}
