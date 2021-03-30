package org.xjosiah.algorithm;

import java.util.Arrays;

/**
 * 一副扑克牌，大小王(特殊情况：总共有4张)可以当成任意的数字大小，JQK为11,12,13
 * 抽五张牌，判断这五张牌是否是顺子
 *
 * @author xjosiah
 * @since 2021/3/30
 */
public class _044_WhetherSortedPoke {
    private static final String TRUE_MESSAGE = "So Lucky!";
    private static final String FALSE_MESSAGE = "Oh My God!";

    private static final int[] poke1 = {2, 1, 5, 0, 0};
    private static final int[] poke2 = {3, 0, 4, 6, 7};
    private static final int[] poke3 = {3, 5, 7, 4, 8};

    public static void main(String[] args) {
        showAnswer(whetherSortedPokeBySort(poke1));
        showAnswer(whetherSortedPokeBySort(poke2));
        showAnswer(whetherSortedPokeBySort(poke3));
        System.out.println("-----------------------------");
        showAnswer(whetherSortedPokeByRange(poke1));
        showAnswer(whetherSortedPokeByRange(poke2));
        showAnswer(whetherSortedPokeByRange(poke3));
    }

    /**
     * 通过排序来帮助进行顺子计算，核心：先统计0的个数，然后统计排序完的数组中有多少个间隔
     * 如果间隔不大于0的数量说明0可进行填补，大于说明一定不是顺子。
     *
     * @param array 源数组
     * @return 是否是顺子
     */
    private static boolean whetherSortedPokeBySort(int[] array) {
        int[] sortedArray = Arrays.stream(array).sorted().toArray();
        long count0 = Arrays.stream(sortedArray).filter(i -> i == 0).count();
        int countSplit = 0;
        for (int i = (int) count0; i < array.length - 1; i++) {
            if (sortedArray[i + 1] == sortedArray[i]) return false;
            if (sortedArray[i + 1] - sortedArray[i] != 1) {
                countSplit += sortedArray[i + 1] - sortedArray[i] - 1;
            }
        }
        return count0 >= countSplit;
    }

    /**
     * 极差计算法：在不考虑0时，只有当数组中的极差是不大于4的才是有顺序的
     * 如「1,2,3,4,5」极差为4  「0,0,0,2,6」极差也是不大于4的
     *
     * @param array 源数组
     * @return 是否满足条件
     */
    private static boolean whetherSortedPokeByRange(int[] array) {
        int[] sortedArrayWith0 = Arrays.stream(array).filter(i -> i > 0).sorted().toArray();
        return sortedArrayWith0[sortedArrayWith0.length - 1] - sortedArrayWith0[0] < 5;
    }

    /**
     * 无情展示答案的函数
     */
    private static void showAnswer(boolean b) {
        System.out.println(b ? TRUE_MESSAGE : FALSE_MESSAGE);
    }
}
