package org.xjosiah.designmodel

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.doubles.shouldBeExactly
import org.xjosiah.designmodel.strategy.CashContext

/**
 * 策略模式通常和简单工厂结合，主要封装的是某种策略（即方法，方法参数可以不同），
 * 使策略对用户隐形方便修改
 * @author xjosiah
 * @since 2021/4/13
 */
class _002_Strategy : StringSpec({
    "choose 'a' rebate 0.8"{
        CashContext("a").getCash(300.0) shouldBeExactly 240.0
    }
    "choose 'b' return 30"{
        CashContext("b").getCash(330.0) shouldBeExactly 300.0
    }
    "choose 'c' use point 2 cut cash"{
        CashContext("c").getCash(100.0) shouldBeExactly 99.0
    }
    "anther use normal"{
        CashContext("d").getCash(100.0) shouldBeExactly 100.0
        CashContext("").getCash(100.0) shouldBeExactly 100.0
        CashContext("I want to pay double!!").getCash(100.0) shouldBeExactly 100.0
    }
})