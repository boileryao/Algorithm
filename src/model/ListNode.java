package model;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public static ListNode makeList(int... args) {
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
    public static ListNode makeList(int low, int high) {
        int[] args = new int[high - low + 1];
        for (int i = low; i <= high; i++) {
            args[i - low] = i;
        }
        return makeList(args);
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