package leetcode

import org.testng.Assert
import org.testng.annotations.Test

/**
 * Created by boileryao on 2019/12/23.
 * Licensed under WTFPL©2019.
 */
class MajorityElementTest {
    var solution = MajorityElement()
    @Test
    fun testMajorityElementII_Case1() {
        val nums = intArrayOf(3, 2, 3)
        val majorities = solution.majorityElementII(nums)
        Assert.assertEquals(HashSet(majorities), setOf(3))
    }

    @Test
    fun testMajorityElementII_Case2() {
        val nums = intArrayOf(1, 1, 1, 3, 3, 2, 2, 2)
        val majorities = solution.majorityElementII(nums)
        Assert.assertEquals(HashSet(majorities), setOf(1, 2))
    }

    @Test
    fun testMajorityElementII_Case3() {
        val nums = intArrayOf(1, 1, 1, 1, 1, 1, 1)
        val majorities = solution.majorityElementII(nums)
        Assert.assertEquals(HashSet(majorities), setOf(1))
    }

    @Test
    fun testMajorityElementII_Case4() {
        val nums = intArrayOf(1, 2, 1, 2, 1)
        val majorities = solution.majorityElementII(nums)
        Assert.assertEquals(HashSet(majorities), setOf(1, 2))
    }
}
