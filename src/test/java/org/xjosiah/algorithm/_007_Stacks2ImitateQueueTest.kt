package org.xjosiah.algorithm

import io.kotest.matchers.collections.*
import org.junit.Test

/**
 * 使用两个堆栈来模仿队列的 pop 和 push 操作
 *
 * @author xjosiah
 * @since 2021/4/7
 */
class _007_Stacks2ImitateQueueTest {

    @Test
    fun PushAndPopTest() {
        val stack = _007_Stacks2ImitateQueue()
        for (i in -99..100) {
            stack.push(i)
        }

        val list = ArrayList<Int>()
        for (i in 1..200) {
            list.add(stack.pop())
        }

        list shouldHaveSize 200
        list shouldStartWith -99
        list shouldEndWith 100
        list shouldNotContain 101
        list shouldNotContain -100
    }

    @Test
    fun NullAndExceptionTest() {
        val stack = _007_Stacks2ImitateQueue()
        stack.pop()
    }
}