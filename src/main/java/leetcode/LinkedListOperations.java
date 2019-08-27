package leetcode;

import model.ListNode;

import static leetcode.LeetCode.Level.EASY;
import static leetcode.LeetCode.Level.MEDIUM;

/**
 * Created by boileryao on 2018/3/20.
 * Licensed under WTFPL©2018.
 * May you have a good life, may you stand on the firm earth.
 * May you a better man and do no evil.
 */
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

    @LeetCode(id = 19, problemName = "remove-nth-node-from-end-of-list", level = MEDIUM, accepted = true)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pioneer = head;
        ListNode follower = head;
        ListNode removedPre = null;

        for (int i = 0; i < n; i++) {
            if (pioneer == null) throw new IllegalArgumentException();
            pioneer = pioneer.next;
        }

        while (pioneer != null) {
            pioneer = pioneer.next;
            removedPre = follower;
            follower = follower.next;
        }

        if (follower == head) return head.next;
        removedPre.next = removedPre.next.next;
        return head;
    }

    @LeetCode(id = 21, problemName = "merge-two-sorted-lists", level = EASY, accepted = true)
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return l1 == null ? l2 : l1;

        ListNode newHead = null;
        ListNode cursor = null;

        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                ListNode smallerNode = l1.val > l2.val ? l2 : l1;
                if (newHead == null) {
                    newHead = smallerNode;
                    cursor = newHead;
                } else {
                    cursor.next = smallerNode;
                    cursor = cursor.next;
                }
                if (cursor == l1) {
                    l1 = l1.next;
                } else {
                    l2 = l2.next;
                }
                continue;
            }

            if (l1 == null) {
                cursor.next = l2;
                l2 = l2.next;
            } else {
                cursor.next = l1;
                l1 = l1.next;
            }
            cursor = cursor.next;
        }

        return newHead;
    }
}
