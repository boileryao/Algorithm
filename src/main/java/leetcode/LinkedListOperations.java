package leetcode;

import model.ListNode;

import static leetcode.LeetCode.Level.*;

/**
 * Created by boileryao on 2018/3/20.
 * Licensed under WTFPL©2018.
 * May you have a good life, may you stand on the firm earth.
 * May you a better man and do no evil.
 */
public class LinkedListOperations {
    @LeetCode(id = 141, problemName = "linked-list-cycle", level = EASY)
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        do {
            if (fast == null || fast.next == null) return false;
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);
        return true;
    }

    /**
     * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
     */
    @LeetCode(id = 61, problemName = "rotate-list", level = MEDIUM)
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        // calc list size
        int listSize = 1;
        ListNode tailNode = head;
        while (tailNode.next != null) {
            tailNode = tailNode.next;
            listSize++;
        }

        // rotate
        int remainingMoves = k % listSize;
        remainingMoves = (listSize - remainingMoves) % listSize;
        ListNode newHead = head;
        ListNode firstHalfTail = null;
        while (remainingMoves-- > 0) {
            firstHalfTail = newHead;
            newHead = newHead.next == null ? head : newHead.next;
        }

        // concat
        if (firstHalfTail != null) {
            tailNode.next = head;
            firstHalfTail.next = null;
        }
        return newHead;
    }

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
    @LeetCode(id = 160, problemName = "intersection-of-ex2-linked-lists", level = EASY)
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

    @LeetCode(id = 206, problemName = "reverse-linked-list", level = EASY)
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

    @LeetCode(id = 19, problemName = "remove-nth-node-from-end-of-list", level = MEDIUM)
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

    @LeetCode(id = 21, problemName = "merge-two-sorted-lists", level = EASY)
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

    @LeetCode(id = 23, problemName = "merge-k-sorted-lists", level = HARD)
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = findSmallestHeading(lists);
        if (head == null) return null;

        ListNode cursor = head;
        do {
            cursor.next = findSmallestHeading(lists);
            cursor = cursor.next;
        } while (cursor != null);
        return head;
    }

    private ListNode findSmallestHeading(ListNode[] lists) {
        int minIdx = -1;
        int minVal = Integer.MAX_VALUE;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null && lists[i].val < minVal) {
                minVal = lists[i].val;
                minIdx = i;
            }
        }
        if (minIdx < 0) return null;
        ListNode minNode = lists[minIdx];
        lists[minIdx] = lists[minIdx].next;
        return minNode;
    }
}
