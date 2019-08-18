package leetcode;

import model.ListNode;

/**
 * Created by boileryao on 2018/3/20.
 * Licensed under WTFPL©2018.
 * May you have a good life, may you stand on the firm earth.
 * May you a better man and do no evil.
 */

/* Problem #160, https://leetcode.com/problems/intersection-of-two-linked-lists */
public class LinkedListOperations {
    /**
     * Iterate ex2 lists (just like somewhat a ring) parallel respectively
     * Two cases:
     * 1. List A and B has no interactions:
     * A -> nil -> B -> nil and B -> nil -> A -> nil, a and b will be null after the first ring
     * 2. List A and B has interactions(exclude common list from A and B as C):
     * A -> C -> nil -> B -> **C -> nil, B -> C -> nil -> A -> **C -> nil, a and b will be equal at start of **C
     * <p>
     * other solutions: @see{naive search} and @see{hash table}
     *
     * @return null or interaction node, if any.
     */
    @LeetCode(id = 160, problemName = "intersection-of-ex2-linked-lists", accepted = true)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }

    @LeetCode(id = 206, problemName = "reverse-linked-list", accepted = true)
    public ListNode invertLinkedList(ListNode head) {
        if (head == null) return null;

        ListNode cur = head;
        ListNode pre = null;
        ListNode follow;

        while (cur != null) {
            follow = cur.next;
            cur.next = pre;
            pre = cur;
            cur = follow;
        }

        return pre;
    }
}
