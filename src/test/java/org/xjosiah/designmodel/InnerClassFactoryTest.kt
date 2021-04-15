package org.xjosiah.designmodel

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import org.xjosiah.designmodel.innerclassfactory.InnerClassFactroy.getInnerClass as getInnerClass2Test

@Suppress("INACCESSIBLE_TYPE")
class InnerClassFactoryTest : StringSpec({
    "initialize, and then get the object from factory should be same"{
        val objectXjosiah1 = getInnerClass2Test("my_name_is_xjosiah")
        val objectXjosiah2 = getInnerClass2Test("my_name_is_xjosiah")
        val objectDifferent = getInnerClass2Test("my_name_is_haisojx")
        objectXjosiah1 shouldBe objectXjosiah2
        objectXjosiah1 shouldBe  objectDifferent
    }
})