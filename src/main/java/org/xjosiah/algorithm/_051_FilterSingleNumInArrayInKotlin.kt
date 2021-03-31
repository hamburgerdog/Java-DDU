package org.xjosiah.algorithm

import java.util.*
import kotlin.collections.HashSet

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是重复的数字2或者3。
 *
 * @author xjosiah
 * @since 2021/3/31
 */
fun main() {
    val N = 8
    val originArray = SplittableRandom().ints()
            .filter { it >= 0 }
            .map { it % N }
            .limit(N.toLong())
            .toArray()

    println(Arrays.toString(originArray))
    val input = Arrays.copyOf(originArray, originArray.size)
    println(filterSingleNumInArray(input).toString())
}

/**
 * 桶占位法：「利用交换有效节省空间」因为数组中的数组都小于长度n，我们可以利用交换的方法来模拟HASH算法的概念
 * 即当我们把数组转换到符合 array【number】 = number 时，其他不在相应桶位置上的整数肯定都是重复的。
 * 以[3,1,3,2,0]为例子，首先为[2,1,3,3,0] 3回到桶中， [3,1,2,3,0] 2回到桶中， 接下来3以归位则遍历下一个1，1也已经归位则继续直到0
 * 此时[0,1,2,3,3]全部已经归位，再从0开始进行一次检查即可步出循环，接下来只有3不在对应桶中，说明3就是重复数字
 *
 * @param array 源数组
 * @return 重复数字的集合
 */
fun filterSingleNumInArray(array: IntArray): HashSet<Int> {
    run {
        var i = 0
        while (i < array.size) {
            val number = array[i]
            if (array[number] != number) {
                array[i] = array[number]
                array[number] = number
            } else {
                i++
            }
        }
    }
    val list = HashSet<Int>()
    for (i in array.indices) {
        if (array[i] != i) list.add(array[i])
    }
    return list
}