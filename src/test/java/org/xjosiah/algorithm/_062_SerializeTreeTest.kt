package org.xjosiah.algorithm

import io.kotest.matchers.sequences.shouldContain
import io.kotest.matchers.sequences.shouldHaveSize
import io.kotest.matchers.shouldBe
import org.junit.Test
import org.xjosiah.common.MyTreeNode

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 * 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，
 * 二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
 *
 * @author xjosiah
 * @since 2021/4/3
 */
class _062_SerializeTreeTest {

    val node = MyTreeNode.createTreeByArray(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).toIntArray())

    @Test
    fun createSerialize() {
        val serializeTreeString = _062_SerializeTree.serializeTree(node)
        println(serializeTreeString)
        val sequence = serializeTreeString.splitToSequence(",").filterNot { it == "" }
        sequence shouldHaveSize 10
        sequence.last() shouldBe "7 # #"
        sequence shouldContain "1 2 3"
        sequence shouldContain "2 4 5"
        sequence shouldContain "3 6 7"
    }

    @Test
    fun createTreeFromSerialize() {
        val serializeTreeString = _062_SerializeTree.serializeTreeReturnBase64(node)
        print(serializeTreeString)

        val rootNode = _062_SerializeTree.createTreeFromSerialize(serializeTreeString)
        rootNode.value shouldBe 1
        rootNode.rightChild.rightChild.value shouldBe 7
        rootNode.leftChild.leftChild.leftChild.value shouldBe 8
        rootNode.leftChild.leftChild.leftChild.rightChild?.shouldBe(null)
    }
}