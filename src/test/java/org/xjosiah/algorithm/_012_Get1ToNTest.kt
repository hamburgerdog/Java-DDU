package org.xjosiah.algorithm

import io.kotest.assertions.assertSoftly
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.collections.shouldEndWith
import io.kotest.matchers.collections.shouldStartWith
import io.kotest.matchers.shouldBe
import org.xjosiah.algorithm._012_Get1ToN as From1toN

/**
 * 给定一个数字N，打印从1到最大的N位数。
 * 如 n=1 则 1,2,3,4,5,6,7,8,9
 * @author xjosiah
 * @since 2021/4/8
 */
class _012_Get1ToNTest : StringSpec({


    "when N=3 should in 1..999"{
        val testList = ArrayList<Int?>()
        testList.addAll(1..999)
        assertSoftly(From1toN.print1ToN(3)){
            size shouldBe 999
            shouldEndWith(999)
            shouldStartWith(1)
            shouldContainExactly(testList)
        }
    }

    "when N<1 should throw exception"{
        shouldThrow<IllegalArgumentException> { From1toN.print1ToN(0) }
        shouldThrow<IllegalArgumentException> { From1toN.print1ToN(-99) }
    }
})