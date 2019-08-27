package model;

import java.util.Objects;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public static ListNode asList(int... args) {
        ListNode head = null;
        if (args.length > 0) head = new ListNode(args[0]);

        ListNode tail = head;
        for (int i = 1; i < args.length; i++) {
            ListNode tmp = new ListNode(args[i]);
            tail.next = tmp;
            tail = tmp;
        }

        return head;
    }

    /**
     * @param low,  low boundary, included
     * @param high, high boundary, included
     */
    public static ListNode range(int low, int high) {
        int[] args = new int[high - low + 1];
        for (int i = low; i <= high; i++) {
            args[i - low] = i;
        }
        return asList(args);
    }

    @Override public int hashCode() {
        return Objects.hash(val, next);
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode one = this;
        ListNode other = (ListNode) o;
        while (one != null && other != null) {
            if (one.val != other.val) return false;
            one = one.next;
            other = other.next;
        }
        return one == other;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode current = this;
        while (current != null) {
            sb.append(current.val).append(' ');
            current = current.next;
        }
        return sb.toString().trim();
    }
}
