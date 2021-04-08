package org.xjosiah.algorithm;

import java.math.BigDecimal;

/**
 * 用函数计算 power(double base ,int exponent) -> base^exponent
 *
 * @author xjosiah
 * @since 2021/3/18
 */
public class _011_Power {
    /**
     * 全面处理异常但不高效的函数
     *
     * @param base     底数
     * @param exponent 指数
     * @return 运算结果
     */
    static double powerMethod1(double base, int exponent) {
        if (exponent == 0) {
            return 1.0;
        }
        if (exponent < 0) {
            if (base == 0)
                throw new IllegalArgumentException("当指数小于0时，底数不能为0");
            return 1 / calculateInMethod(base, -exponent);
        }
        return calculateInMethod(base, exponent);
    }

    /**
     * 真正执行指数计算的函数
     *
     * @param base     指数
     * @param exponent 底数
     * @return 运算结果
     */
    private static double calculateInMethod(double base, int exponent) {
        double res = 1.0;
        for (int i = 0; i < exponent; i++) {
            res *= base;
        }
        return res;
    }

    /**
     * 全面且高效的计算方法（按bit位来精简计算）
     * 核心：
     * 将指数化成二进制，我们可以在其中找到规律，运算的结果和指数中1的个数和位置有关系，
     * 按二进制指数 最高位1 的位数进行迭代，即循环结束条件是当二进制指数减为0，每次迭代
     * 先判断当前指数最低位是否为1，是则将乘数累乘到结果中，且每次都要将乘数也进行自我累
     * 乘,然后将指数右移1位（如果指数为负需要先使其为正，因为这里的>>是算术右移）
     * <p>
     * 以 power(2.0, 9) 为例：
     * 1. 9 = 1001b
     * 2. 0001b = 1 | 1000b = 8
     * 3. 2.0 ^ 9 = 2.0 ^ 1 * 2.0 ^ 8
     * 乘数累乘则得出乘数与位数相关：当1位时乘数为2.0^1 3位时乘数为2.0^(2^3)=2.0^8
     * 当最低位为1则乘数累乘到结果 -> 即步骤3
     *
     * @param base     底数
     * @param exponent 指数
     * @return 指数运算结果
     */
    static double powerMethod2(double base, int exponent) {
        if (exponent == 0) return 1.0;
        else if (exponent == 1) return base;

        if (base == 0.0) {
            if (exponent < 0) throw new IllegalArgumentException("0不能有负数次方");
        }

        boolean isNegative = false;

        double res = 1.0;
        double temp = base;

        if (exponent < 0) {
            exponent = -exponent;
            isNegative = true;
        }

        while (exponent != 0) {
            if ((exponent & 1) == 1) {
                res *= temp;
            }
            temp *= temp;
            exponent = exponent >> 1;
        }
        return isNegative ? 1/res : res;
    }
}
