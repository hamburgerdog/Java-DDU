package org.xjosiah.algorithm;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符的位置。若为空串，返回-1。
 * 位置索引从0开始
 *
 * @author xjosiah
 * @since 2021/3/28
 */
public class _035_FindCharNorepeatInString {
    private static final String originString = "abcdlqwelkoiasdyioqwelkjjcasdlkqwerrppboasdffuulqeyz";
    private static final String testString = "uncopyrightable";

    public static void main(String[] args) {
        System.out.println(findChar(originString));
        System.out.println(findChar(testString));
    }

    /**
     * 查找源字符串中只出现一次的字符
     *
     * @param origin 源字符串
     * @return 只出现一次的字符的位置，找不得则返回的是 -1
     */
    private static int findChar(String origin) {
        HashMap<String, Integer> resultMap = new HashMap<>();
        String[] split = origin.split("");
        for (int i = 0; i < split.length; i++) {
            putInMap(resultMap, split[i], i);
        }
        //  用于lambda中设值
        AtomicInteger resultIndex = new AtomicInteger(-1);
        //  因为要找出第一个出现的字符，且map中存放的value为下标即找出最小value
        resultMap.values().stream().filter(e -> e != -1).min(Integer::compareTo).ifPresent(resultIndex::set);
        return resultIndex.get();
    }

    /**
     * 维持Map中存放的数据为只在字符串中出现一次的字符和其下标
     *
     * @param map     用于存放的表
     * @param charKey 字符
     * @param index   字符对应的下标
     */
    private static void putInMap(HashMap<String, Integer> map, String charKey, int index) {
        Integer i = map.get(charKey);
        if (i == null) {
            map.put(charKey, index);
            return;
        }
        if (i != -1) map.put(charKey, -1);
    }
}
