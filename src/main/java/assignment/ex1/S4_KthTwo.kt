package assignment.ex1

import kotlin.math.max
import kotlin.math.min

/**
 * Created by boileryao on 2018/4/30.
 * Licensed under WTFPL©2018.
 * May you have a good life, may you stand on the firm earth.
 * May you a better man and do no evil.
 */


/**
 * Give a divide and conquer algorithm for the following problem:
 * you are given two sorted lists of size m and n, and are allowed unit time access to the ith element of each list.
 * Give an O(lg m + lgn) time algorithm for computing the kth largest element in the union of the two lists.
 * (For simplicity, you can assume that the elements of the two lists are distinct).
 */
fun findKth(arrA: IntArray, arrB: IntArray, la: Int, ha: Int, lb: Int, hb: Int, k: Int): Int {
    val ma = (la + ha) / 2
    val mb = (lb + hb) / 2
    if (la > ha) return arrB[lb + k - 1]
    if (lb > hb) return arrA[la + k - 1]
    return if (arrA[ma] <= arrB[mb]) {
        if (k <= ma - la + (mb - lb) + 1) {
            findKth(arrA, arrB, la, ha, lb, mb - 1, k)
        } else {
            findKth(arrA, arrB, ma + 1, ha, lb, hb, k - (ma - la) - 1)
        }
    } else {
        if (k <= ma - la + (mb - lb) + 1) {
            findKth(arrA, arrB, la, ma - 1, lb, hb, k)
        } else {
            findKth(arrA, arrB, la, ha, mb + 1, hb, k - (mb - lb) - 1)
        }
    }
}

@Deprecated("incorrect solution")
fun kthLargest(arrA: IntArray, arrB: IntArray, k: Int): Int {
    var la = 0
    var lb = 0
    var ha = arrA.size - 1
    var hb = arrB.size - 1
    var ma = 0
    var mb = 0
    var order = ma + mb

    while (k !in order - 1..order + 4) {
        println("Magic: $k not in [${order - 1}, ${order + 4}]")
        if (k < order - 1) {
            if (arrA[ma] > arrB[mb]) {
                ha = ma - 1
                ma = (la + ha).shr(1)
            } else {
                hb = mb - 1
                mb = (lb + hb).shr(1)
            }
        } else {
            if (arrA[ma] < arrB[mb]) {
                la = ma + 1
                ma = (la + ha).shr(1)
            } else {
                lb = mb + 1
                mb = (lb + hb).shr(1)
            }
        }

        order = ma + mb
    }

    println("Log(k=$k): $k in [${order - 1}, ${order + 4}]")
    return when (k) {
        order - 1 -> min(if (ma < 1) Int.MAX_VALUE else arrA[ma - 1], if (mb < 1) Int.MAX_VALUE else arrB[mb - 1])
        order -> max(if (ma < 1) Int.MIN_VALUE else arrA[ma - 1], if (mb < 1) Int.MIN_VALUE else arrB[mb - 1])

        order + 1 -> min(arrA[ma], arrB[mb])
        order + 2 -> max(arrA[ma], arrB[mb])

        order + 3 -> min(if (ma + 1 < arrA.size) arrA[ma + 1] else Int.MAX_VALUE, if (mb + 1 < arrB.size) arrB[mb + 1] else Int.MAX_VALUE)
        order + 4 -> max(if (ma + 1 < arrA.size) arrA[ma + 1] else Int.MIN_VALUE, if (mb + 1 < arrB.size) arrB[mb + 1] else Int.MIN_VALUE)

        else -> throw IllegalArgumentException("k which is $k is illegal")
    }
}

fun main() {
    val arrA = intArrayOf(0, 1, 2, 3, 5, 8, 9)
    val arrB = intArrayOf(4, 6, 7)
    (1..arrA.size + arrB.size).forEach {
        println(findKth(arrA, arrB, 0, arrA.size - 1, 0, arrB.size - 1, it))  // expect 0 to 9, one for one line
    }
}