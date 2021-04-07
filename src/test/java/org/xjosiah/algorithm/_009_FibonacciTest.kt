package org.xjosiah.algorithm

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.Test
import java.math.BigInteger

/**
 **
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
 * @since 2021/4/7
 */
class _009_FibonacciTest {

    @Test
    fun FibonacciTest() {
        _009_Fibonacci.getSimpleFibonacci(10) shouldBe 55
        _009_Fibonacci.getSimpleFibonacci(11) shouldBe 89
        _009_Fibonacci.getSimpleFibonacci(12) shouldBe 144
        //  79以上就会int溢出 如果需要更大的数据，需要使用大整型数
        shouldThrow<IllegalArgumentException> { _009_Fibonacci.getSimpleFibonacci(79) }
        shouldThrow<IllegalArgumentException> { _009_Fibonacci.getSimpleFibonacci(80) }
        shouldThrow<IllegalArgumentException> { _009_Fibonacci.getSimpleFibonacci(100) }
        shouldThrow<IllegalArgumentException> { _009_Fibonacci.getSimpleFibonacci(-1) }

        _009_Fibonacci.getCrazyFibonacciFrog(10) shouldBe BigInteger("1024")
        _009_Fibonacci.getCrazyFibonacciFrog(20) shouldBe BigInteger((1024 * 1024).toString())
        _009_Fibonacci.getCrazyFibonacciFrog(100) shouldBe BigInteger("1267650600228229401496703205376")
        shouldThrow<IllegalArgumentException> { _009_Fibonacci.getCrazyFibonacciFrog(-1) }
    }
}