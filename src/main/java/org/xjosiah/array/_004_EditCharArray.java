package org.xjosiah.array;

import java.util.Arrays;

/**
 * @author xjosiah
 * @since 2021/3/3
 */
public class _004_EditCharArray {
    private static char[] chars = "We Are Happy".toCharArray();

    /**
     * 将数组中的空格替换成%20,采用从尾部处理可以有效的减少数据移动次数
     * @return  处理后的数组
     */
    private static char[] editChars() {
        int length = chars.length;
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (' ' == chars[i])
                count++;
        }
        //  无空格则直接返回
        if (count == 0)
            return chars;

        length += count * 2;
        //  拓宽数组
        chars = Arrays.copyOf(_004_EditCharArray.chars, length);

        int p2Index = length - 1;
        int p1Index = p2Index - count * 2;

        for (; p1Index != p2Index; p1Index--) {
            if (chars[p1Index] != ' ') {
                chars[p2Index] = chars[p1Index];
                p2Index--;
            } else {
                chars[p2Index--]='0';
                chars[p2Index--]='2';
                chars[p2Index--]='%';
            }
        }
        return chars;
    }

    public static void main(String[] args) {
        /*
            Arrays.asList()知识点:
                假数组，用于读可以，如果对数据进行改动会抛异常

            如果需要将其转化成ArrayList可以使用：
            1.  new ArrayList<>(Arrays.asList(chars));
            2.  new ArrayList(List.of(chars));  jdk9以上支持的List类中的方法
         */

        Arrays.asList(editChars()).forEach(System.out::print);
    }
}
