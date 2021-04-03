package org.xjosiah.algorithm

import io.kotest.matchers.shouldBe
import org.junit.Test

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 *
 * @author xjosiah
 * @since 2021/4/3
 */
class _064_FindMidNumInIntStreamTest {
    @Test
    fun findMidTest(){
        val arrayEven = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9).toIntArray()
        _064_FindMidNumInIntStream.getMidNumByMinHeap(arrayEven) shouldBe "5.00"


        val arrayOdd = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).toIntArray()
        _064_FindMidNumInIntStream.getMidNumByMinHeap(arrayOdd) shouldBe "5.50"
    }
}