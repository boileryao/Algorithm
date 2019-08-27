package leetcode

import model.ListNode
import org.testng.Assert.assertEquals
import org.testng.annotations.Test

/**
 * Created by boileryao on 8/21/2019.
 * Licensed under WTFPL©2019.
 */
class AddTwoNumbersKtTest {

    @Test
    fun testAddTwoNumbers_SameWidth() {
        val l1 = ListNode.asList(2, 4, 3)
        val l2 = ListNode.asList(5, 6, 4)
        val expect = ListNode.asList(7, 0, 8)
        assertEquals(addTwoNumbers(l1, l2), expect)
    }

    @Test
    fun testAddTwoNumbers_DiffWidth() {
        @Suppress("RemoveRedundantSpreadOperator")
        val l1 = ListNode.asList(*intArrayOf(2, 4))
        val l2 = ListNode.asList(5, 6, 4)
        val expect = ListNode.asList(7, 0, 5)
        assertEquals(addTwoNumbers(l1, l2), expect)
    }

    @Test
    fun testAddTwoNumbers_Zero() {
        val l1 = ListNode.asList(0)
        val l2 = ListNode.asList(5, 6, 4)
        assertEquals(addTwoNumbers(l1, l2), l2)
    }

    @Test
    fun testAddTwoNumbers_RankPlus() {
        val l1 = ListNode.asList(5)
        val l2 = ListNode.asList(5)
        assertEquals(addTwoNumbers(l1, l2), ListNode.asList(0, 1))
    }
}
