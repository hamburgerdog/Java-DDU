package org.xjosiah.array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * wiki: https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle
 * 作用：对数组内的数据进行随机排序
 *
 * @author xjosiah
 * @since 2021/3/17
 */
public class FisherYatesShuffle {

    private static int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    private static int[] simpleArray2Analyze = {1, 2, 3};

    public static void main(String[] args) {
        System.out.println("---------对数据进行随机排序展示------------");
        Arrays.stream(array).forEach(i -> System.out.print(i + " "));
        System.out.println();
        shuffle(array);
        Arrays.stream(array).forEach(i -> System.out.print(i + " "));

        System.out.println("\n\n---------对算法随机排序后结果的统计--------");
        HashMap<String, Integer> analyzedResultMap = new HashMap<>();
        int analyzeTime = 100000;
        int i = 0;
        while (i < analyzeTime) {
            int[] anlyzeItem = Arrays.copyOf(simpleArray2Analyze, simpleArray2Analyze.length);
            shuffle(anlyzeItem);
            putInMap(Arrays.toString(anlyzeItem), analyzedResultMap);
            i++;
        }
        System.out.println(analyzedResultMap);
    }

    /**
     * 算法过程：
     * 数组倒序遍历，把 当前下标i的数据 和 随机生成下标j(0 <= j <= i)的数据 进行对换
     * 优点：速度快，数据分布均匀且不会造成性能危机
     *
     * @param list
     */
    private static void shuffle(int[] list) {
        int tmpUsedInListForr;

        //  postfix completion -> list.forr
        for (int i = list.length - 1; i >= 0; i--) {
            int exchangedIndex = (int) Math.floor(Math.random() * (i + 1));
            tmpUsedInListForr = list[exchangedIndex];
            list[exchangedIndex] = list[i];
            list[i] = tmpUsedInListForr;
        }
    }

    /**
     * 注意要把key设置为String类型
     * 原先bug记录：用int[]类型做key，结果由于万物皆对象导致key统统唯一
     *
     * @param key
     * @param map
     */
    private static void putInMap(String key, HashMap<String, Integer> map) {
        Integer value = map.get(key);
        map.put(key, value != null ? value + 1 : 1);
    }
}


