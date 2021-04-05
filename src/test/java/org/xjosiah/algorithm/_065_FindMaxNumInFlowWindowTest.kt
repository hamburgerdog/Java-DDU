package org.xjosiah.algorithm

import io.kotest.matchers.collections.*
import org.junit.Test

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值
 * @author xjosiah
 * @since 2021/4/5
 */
class _065_FindMaxNumInFlowWindowTest {
    @Test
    fun testFindNumByHeap() {
        val testArray = listOf(2, 3, 4, 2, 6, 2, 5, 1).toIntArray()
        val result = listOf(4, 4, 6, 6, 6, 5)
        val collectNumsByMaxHeap = _065_FindMaxNumInFlowWindow.collectNumsByMaxHeap(testArray)
        collectNumsByMaxHeap shouldBeSameSizeAs result
        collectNumsByMaxHeap shouldStartWith 4
        collectNumsByMaxHeap shouldEndWith 5
        collectNumsByMaxHeap shouldContainExactly result
    }

    @Test
    fun testFindNumByDeque() {
        val testArray = listOf(2, 3, 4, 2, 6, 2, 5, 1).toIntArray()
        val result = listOf(4, 4, 6, 6, 6, 5)
        val collectNumsByDeque = _065_FindMaxNumInFlowWindow.collectNumsByDeque(testArray)
        collectNumsByDeque shouldBeSameSizeAs result
        collectNumsByDeque shouldStartWith 4
        collectNumsByDeque shouldEndWith 5
        collectNumsByDeque shouldContainExactly result
    }
}