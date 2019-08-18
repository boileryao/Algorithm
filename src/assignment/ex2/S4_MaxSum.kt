package assignment.ex2

import kotlin.test.assertEquals

/**
 * Created by boileryao on 2018/4/17.
 * Licensed under WTFPL©2018.
 * May you have a good life, may you stand on the firm earth.
 * May you a better man and do no evil.
 */

/**
 * 数组中 连续元素的最大和
 */
fun maxSum(arr: IntArray): Int {
    var sum = 0
    var max = Int.MIN_VALUE
    for (num in arr) {
        sum = if (sum > 0) sum + num else num
        if (sum > max) max = sum
    }

    return max
}

/** Test Cases */
fun main(args: Array<String>) {
    assertEquals(maxSum(intArrayOf(-2)), -2)
    assertEquals(maxSum(intArrayOf(-2, 11, -4, 13, -5, -2)), 20)
}