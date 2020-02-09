package leetcode

import org.testng.Assert
import org.testng.annotations.Test

/**
 * Created by boileryao on 2020/2/9.
 * Licensed under WTFPL©2020.
 */
class RussianDollEnvelopesTest {

    private val solution = RussianDollEnvelopes()

    @Test
    fun testMaxEnvelopes() {
        val envelopes = arrayOf(intArrayOf(5, 4), intArrayOf(6, 4), intArrayOf(6, 7), intArrayOf(2, 3))
        Assert.assertEquals(solution.maxEnvelopes(envelopes), 3)
        Assert.assertEquals(solution.maxEnvelopesNLN(envelopes), 3)
    }

    @Test
    fun testMaxEnvelopes_None() {
        val envelopes = arrayOf<IntArray>()
        Assert.assertEquals(solution.maxEnvelopes(envelopes), 0)
        Assert.assertEquals(solution.maxEnvelopesNLN(envelopes), 0)
    }

    @Test
    fun testMaxEnvelopes_Atomic() {
        val envelopes = arrayOf(intArrayOf(1, 2))
        Assert.assertEquals(solution.maxEnvelopes(envelopes), 1)
        Assert.assertEquals(solution.maxEnvelopesNLN(envelopes), 1)
    }

    @Test
    fun testMaxEnvelopes_Fail1() {
        val whs = intArrayOf(1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 5, 5, 6, 7, 7, 8)
        val envelopes = Array(whs.size / 2) { intArrayOf(whs[2 * it], whs[2 * it + 1]) }
        Assert.assertEquals(solution.maxEnvelopes(envelopes), 7)
        Assert.assertEquals(solution.maxEnvelopesNLN(envelopes), 7)
    }
}
