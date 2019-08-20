package dp

import leetcode.LeetCode
import kotlin.test.asserter

/**
 * Created by boileryao on 2018/4/6.
 * Licensed under WTFPL©2018.
 * May you have a good life, may you stand on the firm earth.
 * May you a better man and do no evil.
 */

@LeetCode(id = 55, problemName = "Jump Game", accepted = false)
fun canJump(nums: IntArray): Boolean {
    if (nums.size == 1) return true
    var tmpArray = getReachableSrc(nums, intArrayOf(nums.size - 1))
    do {
//        println("Before: " + Arrays.toString(tmpArray))
        if (tmpArray.contains(0)) return true
        tmpArray = getReachableSrc(nums, tmpArray)
//        println("After: " + Arrays.toString(tmpArray))
    } while (tmpArray.isNotEmpty())
    return false
}

/**
 * @return all indexes of which can jump to dstPos
 */
fun getReachableSrc(nums: IntArray, dstPosArr: IntArray): IntArray {
    val src = mutableSetOf<Int>()
    for (dstPos in dstPosArr) {
        for (i in 0 until dstPos) {
            if (i + nums[i] >= dstPos) {
                src.add(i)
            }
        }
    }
    return src.toIntArray()
}

fun main() {
    asserter.assertTrue("", canJump(intArrayOf(1, 2, 2, 6, 3, 6, 1, 8, 9, 4, 7, 6, 5, 6, 8, 2, 6, 1, 3, 6, 6, 6, 3, 2, 4, 9, 4, 5, 9, 8, 2, 2, 1, 6, 1, 6, 2, 2, 6, 1, 8, 6, 8, 3, 2, 8, 5, 8, 0, 1, 4, 8, 7, 9, 0, 3, 9, 4, 8, 0, 2, 2, 5, 5, 8, 6, 3, 1, 0, 2, 4, 9, 8, 4, 4, 2, 3, 2, 2, 5, 5, 9, 3, 2, 8, 5, 8, 9, 1, 6, 2, 5, 9, 9, 3, 9, 7, 6, 0, 7, 8, 7, 8, 8, 3, 5, 0)))
    asserter.assertTrue("", canJump(intArrayOf(2, 3, 1, 1, 4)))
    asserter.assertTrue("", canJump(intArrayOf(2)))
    asserter.assertTrue("", canJump(intArrayOf(2, 3, 1, 1, 4)))
    asserter.assertTrue("", !canJump(intArrayOf(3, 2, 1, 0, 4)))
}
