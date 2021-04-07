package org.xjosiah.algorithm

import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldHaveSameLengthAs
import org.junit.Test
import org.xjosiah.common.MyLinkedNode

/**
 * 递归方式输出反转后的单链表
 */
class _005_ReverseLinkedListTest {

    @Test
    fun reverseTest() {
        val linkedNode1 = MyLinkedNode('h', null)
        val linkedNode2 = MyLinkedNode('g', linkedNode1)
        val linkedNode3 = MyLinkedNode('f', linkedNode2)
        val linkedNode4 = MyLinkedNode('e', linkedNode3)
        val linkedNode5 = MyLinkedNode('d', linkedNode4)
        val linkedNode6 = MyLinkedNode('c', linkedNode5)
        val linkedNode7 = MyLinkedNode('b', linkedNode6)
        val linkedNode8 = MyLinkedNode('a', linkedNode7)

        val stringBulid: StringBuilder = java.lang.StringBuilder()
        _005_ReverseLinkedList.reverse(stringBulid, linkedNode8)
        stringBulid.endsWith("a ")
        stringBulid.startsWith("h ")
        stringBulid.toString() shouldHaveSameLengthAs "h g f e d c b a "
        stringBulid.toString() shouldBe "h g f e d c b a "
    }

    @Test
    fun failedCazNullTest() {
        var linkedNode = MyLinkedNode('h', null)
        _005_ReverseLinkedList.reverse(java.lang.StringBuilder(), linkedNode)

        linkedNode = MyLinkedNode(null, null)
        _005_ReverseLinkedList.reverse(java.lang.StringBuilder(), linkedNode)

        _005_ReverseLinkedList.reverse(null, linkedNode)
    }
}