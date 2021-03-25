package org.xjosiah.array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列
 * 例如输入字符串abc,则打印出由字符a,b,c,所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 结果请按字母顺序输出。
 * 注意 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母
 *
 * @author xjosiah
 * @since 2021/3/25
 */
public class _028_StringSplitAndSort {
    private static final String RESULT_SRTING = "abcd";
    private static ArrayList<String> resultList = new ArrayList<>();

    public static void main(String[] args) {
        sortedString(RESULT_SRTING, 0);
        System.out.println(Arrays.toString(resultList.stream().distinct().sorted().toArray(String[]::new)));
    }

    /**
     * 递归全排序法，会有重复需要在使用过滤。
     * 对abb，第一个数a与第二个数b交换得到bab，然后考虑第一个数与第三个数交换，
     * 此时由于第三个数等于第二个数，所以第一个数就不再用与第三个数交换了。
     * 再考虑bab，它的第二个数与第三个数交换可以解决bba。此时全排列生成完毕！
     *
     * @param s     当前需要操作的字符串
     * @param index 当前操作在字符串中的层次
     */
    private static void sortedString(String s, int index) {
        for (int i = index; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                String[] split = s.split("");
                String temp = split[i];
                split[i] = split[j];
                split[j] = temp;
                String result = String.join("", split);
                resultList.add(result);
                sortedString(result, index + 1);
            }
        }
    }

}
