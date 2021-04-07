package org.xjosiah.algorithm

import io.kotest.matchers.shouldBe
import org.junit.Test

/**
 * 在一个二维数组中，每一行按从左到右递增，每一列按从上到下递增，
 * 请完成一个函数输入一个整数，判断数据中是否含有该整数
 * arrays\[x]\[y] =>
 * {1, 2, 8,  9 }
 * {2, 4, 9,  12}
 * {4, 7, 10, 13}
 * {6, 8, 11, 15}
 */
class _003_WhetherInDbArrayTest{
    @Test
    fun whetherInArrayTest(){
        _003_WhetherInDbArray.whetherInArrays(1) shouldBe true
        _003_WhetherInDbArray.whetherInArrays(7) shouldBe true
        _003_WhetherInDbArray.whetherInArrays(13) shouldBe true
        _003_WhetherInDbArray.whetherInArrays(15) shouldBe true
        _003_WhetherInDbArray.whetherInArrays(9) shouldBe true
        _003_WhetherInDbArray.whetherInArrays(6) shouldBe true
        _003_WhetherInDbArray.whetherInArrays(5) shouldBe false
        _003_WhetherInDbArray.whetherInArrays(16) shouldBe false
        _003_WhetherInDbArray.whetherInArrays(99) shouldBe false
    }
}