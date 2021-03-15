package org.xjosiah.array;

import java.util.Set;
import java.util.TreeSet;


/**
 * @author xjosiah
 * @since 2021/3/3
 */
public class _001_FindMultInArray {
    private static int[] array = {2, 3, 1, 0, 2, 5, 3, 1, 3, 6, 8, 8, 9, 10, 11, 12, 11, 10, 0, 19, 6, 20};

    /**
     * 找出题目中重复的数字：
     * 在一个长度为n的数组中所有数字都在0-n-1的范围，数组中某几个数字重复了，请找出任意一个重复的数字。
     */
    private static Set<Integer> findMult() {
        int tmp;
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < array.length; i++) {
            while (array[i] != i) {
                if (array[array[i]] != array[i]) {
                    tmp = array[i];
                    array[i] = array[tmp];
                    array[tmp] = tmp;
                } else {
                    set.add(array[i]);
                    break;
                }
            }
        }
        return set;
    }

    public static void main(String[] args) {
        Set<Integer> mult = findMult();
        mult.forEach(System.out::println);
    }
}
