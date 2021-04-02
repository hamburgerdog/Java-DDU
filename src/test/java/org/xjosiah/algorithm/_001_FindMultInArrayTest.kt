package org.xjosiah.algorithm

import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.collections.shouldNotContain
import io.kotest.matchers.ints.shouldBeGreaterThanOrEqual
import io.kotest.matchers.ints.shouldBeLessThan
import org.junit.Test

/**
 * 找出题目中重复的数字：
 * 在一个长度为n的数组中所有数字都在0-n-1的范围，数组中某几个数字重复了，请找出任意一个重复的数字。
 */
class _001_FindMultInArrayTest() {
    @Test
    fun findMultTestContainAll() {
        val array = listOf(1, 2, 2, 3, 3, 4, 5, 5, 6, 7, 8, 9).toIntArray()
        array.forEach {
            it shouldBeLessThan array.size
            it shouldBeGreaterThanOrEqual 0
        }

        val resultArray = _001_FindMultInArray.findMult(array)
        resultArray shouldNotContain 1
        resultArray shouldContain 2
        resultArray shouldHaveSize 3

        val testList: List<Int> = listOf(2, 3, 5)
        resultArray shouldContainAll testList
    }

    @Test
    fun findMultTestContainNull() {
        val array = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8).toIntArray()
        array.forEach {
            it shouldBeLessThan array.size
            it shouldBeGreaterThanOrEqual 0
        }
        _001_FindMultInArray.findMult(array) shouldHaveSize 0
    }
}