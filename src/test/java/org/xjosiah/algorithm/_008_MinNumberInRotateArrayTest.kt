package org.xjosiah.algorithm

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.Test

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减序列的一个旋转，输出旋转数组的最小元素。
 *
 * @author xjosiah
 * @since 2021/4/7
 */
class _008_MinNumberInRotateArrayTest {

    @Test
    fun FindMinTest() {
        val array = arrayOf(3, 4, 5, 1, 2).toIntArray()
        _008_MinNumberInRotateArray.finMinNum(array) shouldBe 1

        val arrayNoRotate = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9).toIntArray()
        _008_MinNumberInRotateArray.finMinNum(arrayNoRotate) shouldBe 1

        val nullArray = IntArray(0)
        shouldThrow<IllegalArgumentException> { _008_MinNumberInRotateArray.finMinNum(nullArray) }

        val nullArrayWithSize = IntArray(10)
        _008_MinNumberInRotateArray.finMinNum(nullArrayWithSize) shouldBe 0

        val arrayNoRotateSingle = arrayOf(1).toIntArray()
        _008_MinNumberInRotateArray.finMinNum(arrayNoRotateSingle) shouldBe 1
    }

    @Test
    fun UnRulerTest() {
        var arrayNoFollowRuler = arrayOf(9, 8, 7, 6, 5).toIntArray()
        shouldThrow<IllegalArgumentException> { _008_MinNumberInRotateArray.finMinNum(arrayNoFollowRuler) }

        arrayNoFollowRuler = arrayOf(9, 8, 7, 6, 5, 6, 7, 8, 9).toIntArray()
        shouldThrow<IllegalArgumentException> { _008_MinNumberInRotateArray.finMinNum(arrayNoFollowRuler) }

        arrayNoFollowRuler = arrayOf(9, 6, 7, 8, 1, 2, 3, 4, 5).toIntArray()
        shouldThrow<IllegalArgumentException> { _008_MinNumberInRotateArray.finMinNum(arrayNoFollowRuler) }

        arrayNoFollowRuler = arrayOf(7, 8, 9, 6, 1, 3, 2, 5, 4).toIntArray()
        shouldThrow<IllegalArgumentException> { _008_MinNumberInRotateArray.finMinNum(arrayNoFollowRuler) }
    }
}