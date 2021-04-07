package org.xjosiah.algorithm

import io.kotest.matchers.shouldBe
import org.junit.Test
import org.xjosiah.algorithm._010_NumberOf as countNumber1

/**
 * 求整数转化为二进制后 1 的个数，负数用补码表示
 *
 * @author xjosiah
 * @since 2021/4/7
 */
class _010_NumberOfTest {

    @Test
    fun CountTest() {
        countNumber1.numberOf(0) shouldBe 0
        countNumber1.numberOf(15) shouldBe 4
        countNumber1.numberOf(16) shouldBe 1
        countNumber1.numberOf(-16) shouldBe 32 - 4
        countNumber1.numberOf(-1) shouldBe 32
    }
}