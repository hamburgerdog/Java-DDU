package org.xjosiah.algorithm;

import java.util.stream.IntStream;

/**
 * 求1+2+3+...+n 要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句
 *
 * @author xjosiah
 * @since 2021/3/31
 */
public class _046_Sum_1_To_N {
    private static final int N = 1003;

    public static void main(String[] args) {
        System.out.println(sumByThrowException(N));
        System.out.println(sumByStream(N));
        System.out.println(sumByUsingRecursion2ImitatePow(N));
    }

    /**
     * 捕捉除0异常来中断递归从而实现退出
     *
     * @param n 1+...+n
     * @return 总和
     */
    private static int sumByThrowException(int n) {
        try {
            int unit = 1 / n;
        } catch (ArithmeticException e) {
            return 0;
        }
        return n + sumByThrowException(n - 1);
    }

    /**
     * 。有点取巧，没啥意义
     */
    private static int sumByStream(int n) {
        return IntStream.range(1, n + 1).sum();
    }

    /**
     * 通过等差数列公式求和，用加法模拟乘法
     *
     * @param n 1..N
     * @return 和
     */
    private static int sumByUsingRecursion2ImitatePow(int n) {
        int lastBit = n & 1;    //  恢复左移1位后消失的值
        int power = n >> 1;
        int result = imitatePow((1 + n), power);
        try {
            int i = 1 / lastBit;
            result += (n >> lastBit) + lastBit;
        } catch (ArithmeticException ignored) {
        }
        return result;
    }

    /**
     * 递归方法模拟乘法
     *
     * @param n     被乘数
     * @param power 乘数
     * @return 乘
     */
    private static int imitatePow(int n, int power) {
        try {
            int unit = 1 / power;
        } catch (ArithmeticException e) {
            return 0;
        }
        return n + imitatePow(n, power - 1);
    }
}
