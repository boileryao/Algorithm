package leetcode

import model.ListNode

/**
 * Created by boileryao on 8/21/2019.
 * Licensed under WTFPL©2019.
 */
@LeetCode(id = 2, problemName = "add-two-numbers", level = LeetCode.Level.MEDIUM)
fun addTwoNumbers(l1: ListNode, l2: ListNode): ListNode {
    val r = ListNode(0)

    var c1: ListNode? = l1
    var c2: ListNode? = l2
    var cr = r

    do {
        if (cr.next == null) {
            cr.next = ListNode(0)
        }
        cr = cr.next

        val digitSum = cr.`val` + (c1?.`val` ?: 0) + (c2?.`val` ?: 0)
        cr.`val` = digitSum % 10
        if (digitSum >= 10) {
            cr.next = ListNode(1)
        }

        c1 = c1?.next; c2 = c2?.next
    } while (c1 != null || c2 != null)

    return r.next
}
