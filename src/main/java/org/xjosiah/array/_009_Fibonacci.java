package org.xjosiah.array;

import java.math.BigInteger;

/**
 * 斐波那契数列的各类变形问题：
 *
 * 1.一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 *      求该青蛙跳上一个n级的台阶总共有多少种跳法（近似斐波那契数列）
 *
 * 2.一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 *      求该青蛙跳上一个n级的台阶总共有多少种跳法。（斐波那契数列的变形，可用数学归纳法）
 *      核心：f(n) = f(n-1) + f(n-1) =2 * f(n-1)
 *
 * 3.我们可以用21的小矩形横着或者竖着去覆盖更大的矩形。
 *      请问用n个21的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？（近似斐波那契数列）
 *
 * @author xjosiah
 * @since 2021/3/17
 */
public class _009_Fibonacci {
    public static void main(String[] args) {
        System.out.println(getSimpleFibonacci(10));
        System.out.println(getCrazyFibonacciFrog(100));
    }

    /**
     * 循环求法 - 简单求法
     * @param n
     * @return
     */
    private static int getSimpleFibonacci(int n) {
        if (n <= 1){
            return n;
        }
        int result = 0;
        int x = 0;
        int y = 1;
        for (int i = 1; i < n; i++) {
            result = x + y;
            x = y;
            y = result;
        }
        return result;
    }

    /**
     * 第二种变态青蛙解法
     * @param n
     * @return  BigInteger足够表示 least 1 to 2^500000000
     */
    private static BigInteger getCrazyFibonacciFrog(int n){
        if (n < 2)
            return BigInteger.valueOf(n);
        return BigInteger.ONE.shiftLeft(n-1).multiply(BigInteger.valueOf(2));
    }

}
