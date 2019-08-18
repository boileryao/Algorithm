package assignment.ex1

import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * Created by boileryao on 2018/4/30.
 * Licensed under WTFPL©2018.
 * May you have a good life, may you stand on the firm earth.
 * May you a better man and do no evil.
 */

/**
 * Describe a Θ(n lgn)-time algorithm that, given a set S of n integers and another
 * integer x, determines whether or not there exist two elements in S whose sum is
 * exactly x.
 */
fun hasExactSum(arr: IntArray, sum: Int): Boolean {
    arr.sort()  // n*lgn
    var startIndex = 0
    var endIndex = arr.size - 1
    while (startIndex <= endIndex) {  // O(n)
        val tmpSum = arr[startIndex] + arr[endIndex]
        if (tmpSum < sum) {
            startIndex++
            continue
        } else if (tmpSum > sum) {
            endIndex--
            continue
        }
        return true
    }

    return false
}

fun main(args: Array<String>) {
    val arr = intArrayOf(2, 3, 4, 5, 8, 3, -1)
    assertFalse(hasExactSum(arr, 100))
    assertFalse(hasExactSum(arr, -100))
    assertFalse(hasExactSum(arr, -1))

    assertTrue(hasExactSum(arr, 1))  // -1 + 2
    assertTrue(hasExactSum(arr, 9))  // 4 + 5
    assertTrue(hasExactSum(arr, 13))  // 5 + 8
}