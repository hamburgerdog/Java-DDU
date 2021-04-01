package org.xjosiah.algorithm;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 *
 * @author xjosiah
 * @since 2021/4/1
 */
public class _055_FindSingleAndHeadCharInStr {
    static ArrayList<String> list = new ArrayList<>();
    static ArrayList<String> disableStrings = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder s = new StringBuilder();
        while (s.length() < 100) {
            String temp = sc.nextLine();
            s.append(temp);
            System.out.println("String : " + s);
            System.out.println(findCharInString(temp));
        }
    }

    /**
     * 用两个数组保存数据，一个是已丢弃的，一个是按序存放当前仅出现一次的
     *
     * @param input 输入的字符串
     * @return 当前最早出现且不重复的字符
     */
    private static String findCharInString(String input) {
        for (String s : input.split("")) {
            if (disableStrings.contains(s)) continue;

            if (list.contains(s)) {
                list.remove(s);
                disableStrings.add(s);
                continue;
            }
            list.add(s);
        }
        return list.size() != 0 ? list.get(0) : "#";
    }
}
