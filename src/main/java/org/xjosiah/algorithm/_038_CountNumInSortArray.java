package org.xjosiah.algorithm;

import java.util.List;
import java.util.SplittableRandom;
import java.util.stream.Collectors;

/**
 * 统计一个数字在排序数组中出现的次数。
 *
 * @author xjosiah
 * @since 2021/3/29
 */
public class _038_CountNumInSortArray {
    private static final int KEY = 3;
    private static final int SIZE = 16;

    public static void main(String[] args) {
        SplittableRandom random = new SplittableRandom();

        List<Integer> list = random.ints().parallel()
                .filter(i -> i > 0)
                .limit(SIZE * 3)
                .map(i -> i % SIZE)
                .sorted()
                .boxed().collect(Collectors.toList());
        System.out.println(list.toString());

        System.out.println(countNumInArray(KEY, list));
    }

    /**
     * 计算数字在排序数组中出现的次数，
     * 从二分法中找到下标，然后向前向后找该数字在第一次、最后一次出现的位置
     *
     * @param key  要找的数字
     * @param list 有序数组
     * @return 数字累计出现的次数
     */
    private static int countNumInArray(int key, List<Integer> list) {
        Integer index = findNumIndexInArray(key, list, list.size() / 2);
        if (index == null) return 0;

        int left = 0;   //  覆盖数组第一个数是key的情况
        for (int i = index; i >= 0; i--) {
            if (list.get(i) != key) {
                left = i + 1;
                break;
            }
        }
        int right = list.size() - 1;    //  覆盖数组最后一个数是key的情况
        for (int i = index + 1; i < list.size(); i++) {
            if (list.get(i) != key) {
                right = i - 1;
                break;
            }
        }
        return right == left ? 1 : right - left + 1;
    }

    /**
     * 二分法查找来查找对应的num在数组中的某一位置
     *
     * @param key  要查找的num
     * @param list 有序数组
     * @return 对应的num在数组中的位置
     */
    private static Integer findNumIndexInArray(int key, List<Integer> list, int index) {
        if (list.size() == 0) return null;

        int nowIndex = list.size() / 2;
        Integer value = list.get(nowIndex);
        if (value == key) return index;

        if (list.size() == 1) return null;

        if (key > value) {
            index = (index + list.size()) / 2;
            return findNumIndexInArray(key, list.subList(nowIndex + 1, list.size()), index);
        }
        index = index / 2;
        return findNumIndexInArray(key, list.subList(0, nowIndex), index);
    }


}
