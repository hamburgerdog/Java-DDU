package org.xjosiah.algorithm;

import java.util.Set;
import java.util.TreeSet;


/**
 * @author xjosiah
 * @since 2021/3/3
 */
public class _001_FindMultInArray {
    /**
     * 找出题目中重复的数字：
     * 在一个长度为n的数组中所有数字都在0-n-1的范围，数组中某几个数字重复了，请找出任意一个重复的数字。
     */
    static Set<Integer> findMult(int[] array) {
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
}
