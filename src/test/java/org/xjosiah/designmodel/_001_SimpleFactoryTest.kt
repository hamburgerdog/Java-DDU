package org.xjosiah.designmodel

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import org.xjosiah.designmodel.simplefactory.OperationFactory
import org.xjosiah.designmodel.simplefactory.operation.*
import java.lang.IllegalArgumentException

class _001_SimpleFactoryTest : StringSpec({
    "1 + 2 should be 3"{
        compute(1.0, 2.0, AddOperation::class.java) shouldBe 3.0
    }
    "1 - 2 should be -1"{
        compute(1.0, 2.0, SubOperation::class.java) shouldBe -1.0
    }
    "1 * 2 should be 2"{
        compute(1.0, 2.0, MultOperation::class.java) shouldBe 2.0
    }
    "1 / 2 should be 0.5"{
        compute(1.0, 2.0, DivOperation::class.java) shouldBe 0.5
    }

    "anything / 0 should throw exception"{
        shouldThrow<IllegalArgumentException> { compute(1.0, 0.0, DivOperation::class.java) }
        shouldThrow<IllegalArgumentException> { compute(0.0, 0.0, DivOperation::class.java) }
        shouldThrow<IllegalArgumentException> { compute(-1.0, 0.0, DivOperation::class.java) }
    }
})

fun compute(a: Double, b: Double, operationClz: Class<out Operation>): Double = OperationFactory.getOperation(operationClz).compute(a, b)