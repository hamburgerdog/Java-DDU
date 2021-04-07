package org.xjosiah.algorithm

import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldHaveLength
import org.junit.Test

/**
 * 将数组中的空格替换成%20,采用从尾部处理可以有效的减少数据移动次数
 */
class _004_EditCharArrayTest {
    @Test
    fun SpaceChangeTest() {
        val testStr = "We are family"
        val result = _004_EditCharArray.editChars(testStr.toCharArray()).joinToString("")
        result shouldHaveLength (testStr.length + 4)
        result shouldBe "We%20are%20family"

        val allSpace = "    1    "
        val spaceResult = _004_EditCharArray.editChars(allSpace.toCharArray()).joinToString("")
        spaceResult shouldBe "%20%20%20%201%20%20%20%20"
    }
}