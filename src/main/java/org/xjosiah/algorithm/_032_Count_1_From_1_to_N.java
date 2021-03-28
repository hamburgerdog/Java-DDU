package org.xjosiah.algorithm;

/**
 * 从1到n整数中1出现的次数
 *
 * @author xjosiah
 * @since 2021/3/28
 */
public class _032_Count_1_From_1_to_N {
    private static final int N = 12013;

    public static void main(String[] args) {
        System.out.println(count_1(3));
        System.out.println(count_1(21));
        System.out.println(count_1(11));
        System.out.println(count_1(93));
        System.out.println(count_1(111));
        System.out.println(count_1(123));
        System.out.println(count_1(9999));
        System.out.println(count_1(12013));
        System.out.println(count_1(12113));
        System.out.println(count_1(12213));
    }

    /**
     * 找出规律，各个位置上的1的个数和高位是存在联系的
     *
     * @param n 第N为
     * @return 1到N上1出现的次数
     */
    private static int count_1(int n) {
        if (n < 1) throw new IllegalArgumentException("N应当大于1");

        int count = 0;
        int current;
        int base = 1;
        int remain = 0;
        while (n != 0) {
            current = n % 10;   //  当前位上的值
            n = n / 10; //  计算下一位

            if (current > 1)
                count += (n + 1) * base;
            else if (current == 1)
                count += n * base + (remain + 1);
            else
                count += n * base;

            remain += current * base;
            base *= 10;
        }
        return count;
    }
}
