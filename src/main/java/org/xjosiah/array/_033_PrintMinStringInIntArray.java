package org.xjosiah.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个
 *
 * @author xjosiah
 * @since 2021/3/28
 */
public class _033_PrintMinStringInIntArray {
    private static final Integer[] origin = {231, 132, 123, 23, 12, 13};

    /**
     * 用字符串避免Int类型溢出，拼接判断并依据结果来进行排序，把排序完成的数组拼接成字符串即可
     */
    public static void main(String[] args) {
        //  使用比较器
        Comparator<Integer> comparator = (a, b) -> {
            String ab = "" + a + b;
            String ba = "" + b + a;
            return Integer.parseInt(ab) - Integer.parseInt(ba);
        };
        Arrays.sort(origin, comparator);
        System.out.println(Arrays.stream(origin).map(String::valueOf).collect(Collectors.joining()));
    }
}
