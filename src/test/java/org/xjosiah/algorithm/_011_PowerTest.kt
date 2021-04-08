package org.xjosiah.algorithm

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import org.xjosiah.algorithm._011_Power as powertest

/**
 * 用函数计算 power(double base ,int exponent) -> base^exponent
 *
 * @author xjosiah
 * @since 2021/4/8
 */
class _011_PowerTest : StringSpec({
    "1 ** Anything should be 1".config(enabled = true) {
        powertest.powerMethod1(1.0, 99) shouldBe 1.0
        powertest.powerMethod2(1.0, -123) shouldBe 1.0
    }

    "0 ** Positive_number should be 0 But ** Negative_number should throw Exception".config(enabled = true) {
        powertest.powerMethod1(0.0, 0) shouldBe 1.0    //  一个没有商定值的数学表达式 通常被表示为1
        powertest.powerMethod1(0.0, 1) shouldBe 0
        powertest.powerMethod1(0.0, 99) shouldBe 0
        shouldThrow<IllegalArgumentException> { powertest.powerMethod1(0.0, -1) }

        powertest.powerMethod2(0.0, 0) shouldBe 1.0
        powertest.powerMethod2(0.0, 1) shouldBe 0
        powertest.powerMethod2(0.0, 99) shouldBe 0
        shouldThrow<IllegalArgumentException> { powertest.powerMethod2(0.0, -1) }
    }

    "normal test".config(enabled = true) {
        powertest.powerMethod1(1.0, 10) shouldBe powertest.powerMethod2(1.0, 10)
        powertest.powerMethod1(-1.0, 10) shouldBe powertest.powerMethod2(-1.0, 10)
        powertest.powerMethod1(1.0, -10) shouldBe powertest.powerMethod2(1.0, -10)
        powertest.powerMethod1(-1.0, -10) shouldBe powertest.powerMethod2(-1.0, -10)
        powertest.powerMethod1(99.0, 10) shouldBe powertest.powerMethod2(99.0, 10)
        powertest.powerMethod1(-99.0, 10) shouldBe powertest.powerMethod2(-99.0, 10)
        powertest.powerMethod1(99.0, -10) shouldBe powertest.powerMethod2(99.0, -10)
        powertest.powerMethod1(-99.0, -10) shouldBe powertest.powerMethod2(-99.0, -10)

        powertest.powerMethod1(1.5,9) shouldBe 38.443359375
        powertest.powerMethod2(1.5,9) shouldBe 38.443359375
    }
})