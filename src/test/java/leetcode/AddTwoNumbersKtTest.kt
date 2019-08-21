package leetcode

import model.ListNode
import org.testng.annotations.Test
import kotlin.test.assertEquals

/**
 * Created by boileryao on 8/21/2019.
 * Licensed under WTFPL©2019.
 */
class AddTwoNumbersKtTest {

    @Test
    fun testAddTwoNumbers_SameWidth() {
        val l1 = ListNode.makeList(2, 4, 3)
        val l2 = ListNode.makeList(5, 6, 4)
        assertEquals("7 0 8", addTwoNumbers(l1, l2).toString())
    }

    @Test
    fun testAddTwoNumbers_DiffWidth() {
        @Suppress("RemoveRedundantSpreadOperator")
        val l1 = ListNode.makeList(*intArrayOf(2, 4))
        val l2 = ListNode.makeList(5, 6, 4)
        assertEquals("7 0 5", addTwoNumbers(l1, l2).toString())
    }

    @Test
    fun testAddTwoNumbers_Zero() {
        val l1 = ListNode.makeList(0)
        val l2 = ListNode.makeList(5, 6, 4)
        assertEquals("5 6 4", addTwoNumbers(l1, l2).toString())
    }

    @Test
    fun testAddTwoNumbers_RankPlus() {
        val l1 = ListNode.makeList(5)
        val l2 = ListNode.makeList(5)
        assertEquals("0 1", addTwoNumbers(l1, l2).toString())
    }
}
