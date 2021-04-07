package org.xjosiah.algorithm

import io.kotest.matchers.collections.shouldBeSameSizeAs
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.collections.shouldEndWith
import io.kotest.matchers.collections.shouldStartWith
import org.junit.Test


/**
 * 根据先序中序生成二叉树
 * 先序{1, 2, 4, 7, 3, 5, 6, 8}
 * 中序{4, 7, 2, 1, 5, 3, 8, 6}
 *
 * @author xjosiah
 * @since 2021/4/7
 */
class _006_CreateBinaryTreeTest {
    @Test
    fun createBTreeTest() {
        val preList = arrayListOf(1, 2, 4, 7, 3, 5, 6, 8)
        val midList = arrayListOf(4, 7, 2, 1, 5, 3, 8, 6)
        val createBinaryTree = _006_CreateBinaryTree(preList, midList)
        val ordList = createBinaryTree.createBTreeAndCollectInListByBackward()
        ordList shouldEndWith 1
        ordList shouldStartWith 7
        ordList shouldBeSameSizeAs preList
        ordList shouldContainExactly arrayListOf(7, 4, 2, 5, 8, 6, 3, 1)
    }

    @Test
    fun createFailedCazErrorListTest() {
        var preList = arrayListOf(1, 2, 3, 4, 5)
        var midList = arrayListOf(4, 3, 2, 1)
        println(_006_CreateBinaryTree(preList, midList).createBTreeAndCollectInListByBackward().toString())

        preList = arrayListOf()
        midList = arrayListOf()
        println(_006_CreateBinaryTree(preList, midList).createBTreeAndCollectInListByBackward().toString())

        preList = arrayListOf(1, 2, 3, 4, 5)
        midList = arrayListOf(6, 5, 4, 3, 2)
        println(_006_CreateBinaryTree(preList, midList).createBTreeAndCollectInListByBackward().toString())
    }

}