package org.xjosiah.algorithm

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import java.lang.IllegalArgumentException
import java.util.*
import org.xjosiah.algorithm._014_ReOrderArray as reorder

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * @author xjosiah
 * @since 2021/4/9
 */
class _014_ReOrderArrayTest : StringSpec({
    "[1,2,3,4,5,6,7,8,9] reorder should be [1,3,5,7,9,2,4,6,8]"{
        val list = arrayListOf<Int>()
        list.addAll(1..9)
        val reOrderArrayByPop = reorder.reOrderArrayByPop(Arrays.copyOf(list.toIntArray(), list.size))
        reOrderArrayByPop shouldBe arrayOf(1, 3, 5, 7, 9, 2, 4, 6, 8)

        val reOrderArrayQuicklyButCostly = reorder.reOrderArrayQuicklyButCostly(Arrays.copyOf(list.toIntArray(), list.size))
        reOrderArrayQuicklyButCostly shouldBe arrayOf(1, 3, 5, 7, 9, 2, 4, 6, 8)
    }

    "[1,3,5,7,9] or [2,4,6,8]should not changed"{
        val listOdd = arrayListOf<Int>()
        listOdd.addAll((1..9).filter { it % 2 == 1 })
        val reOrderOddArrayByPop = reorder.reOrderArrayByPop(Arrays.copyOf(listOdd.toIntArray(), listOdd.size))
        reOrderOddArrayByPop shouldBe listOdd
        val reOrderOddArrayQuicklyButCostly = reorder.reOrderArrayQuicklyButCostly(Arrays.copyOf(listOdd.toIntArray(), listOdd.size))
        reOrderOddArrayQuicklyButCostly shouldBe listOdd

        val listEven = arrayListOf<Int>()
        listEven.addAll((1..9).filter { it % 2 == 0 })
        val reOrderEvenArrayByPop = reorder.reOrderArrayByPop(Arrays.copyOf(listEven.toIntArray(), listEven.size))
        reOrderEvenArrayByPop shouldBe listEven
        val reOrderEvenArrayQuicklyButCostly = reorder.reOrderArrayQuicklyButCostly(Arrays.copyOf(listEven.toIntArray(), listEven.size))
        reOrderEvenArrayQuicklyButCostly shouldBe listEven
    }

    "[] should be [] or throw Exception"{
        val arrayListOf = arrayListOf<Int>()
        reorder.reOrderArrayByPop(arrayListOf.toIntArray()).size shouldBe 0
        reorder.reOrderArrayQuicklyButCostly(arrayListOf.toIntArray()).size shouldBe 0
        shouldThrow<IllegalArgumentException> { reorder.reOrderArrayByPop(null) }
        shouldThrow<IllegalArgumentException> { reorder.reOrderArrayQuicklyButCostly(null) }
    }
})