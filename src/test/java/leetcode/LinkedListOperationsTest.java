package leetcode;

import model.ListNode;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

/**
 * Created by boileryao on 2018/3/20.
 * Licensed under WTFPL©2018.
 * May you have a good life, may you stand on the firm earth.
 * May you a better man and do no evil.
 */
public class LinkedListOperationsTest {
    private LinkedListOperations mListOperations = new LinkedListOperations();

    @Test
    public void testGetIntersectionNode_SameList() {
        ListNode list = ListNode.range(1, 6);
        ListNode interaction = mListOperations.getIntersectionNode(list, list);
        assertEquals(interaction, list);
    }

    @Test
    public void testGetIntersectionNode_NonInteraction() {
        ListNode list1 = ListNode.range(1, 6);
        ListNode list2 = ListNode.range(1, 5);

        ListNode interaction = mListOperations.getIntersectionNode(list1, list2);
        assertNull(interaction);
    }

    @Test
    public void testGetIntersectionNode_Interaction() {
        ListNode list1 = ListNode.range(1, 6);
        ListNode list2 = ListNode.asList(1);
        list2.next = list1;

        ListNode interaction = mListOperations.getIntersectionNode(list1, list2);
        assertEquals(interaction, list1);
    }

    @Test
    public void testReverseList() {
        ListNode head = ListNode.range(1, 4);
        ListNode reversedHead = mListOperations.invertLinkedList(head);
        assertEquals(reversedHead, ListNode.asList(4, 3, 2, 1));
    }

    @Test
    public void testReverseList_OneElement() {
        ListNode head = ListNode.asList(1);
        ListNode reversedHead = mListOperations.invertLinkedList(head);
        assertEquals(reversedHead, ListNode.asList(1));
    }

    @Test
    public void testReverseList_Empty() {
        ListNode head = ListNode.asList();
        ListNode reversedHead = mListOperations.invertLinkedList(head);
        assertNull(reversedHead);
    }

    @Test
    public void testRemoveNthFromEnd_Atom() {
        ListNode head = ListNode.asList(1);
        ListNode reversedHead = mListOperations.removeNthFromEnd(head, 1);
        assertNull(reversedHead);
    }

    @Test
    public void testRemoveNthFromEnd_22() {
        ListNode head = ListNode.range(1, 2);
        ListNode reversedHead = mListOperations.removeNthFromEnd(head, 2);
        assertEquals(reversedHead, ListNode.asList(2));
    }

    @Test
    public void testRemoveNthFromEnd_21() {
        ListNode head = ListNode.range(1, 2);
        ListNode reversedHead = mListOperations.removeNthFromEnd(head, 1);
        assertEquals(reversedHead, ListNode.asList(1));
    }

    @Test
    public void testRemoveNthFromEnd_5() {
        ListNode head = ListNode.range(1, 5);
        ListNode reversedHead = mListOperations.removeNthFromEnd(head, 2);
        assertEquals(reversedHead, ListNode.asList(1, 2, 3, 5));
    }

    @Test
    public void testMergeTwoLists() {
        ListNode a = ListNode.asList(1, 2, 4);
        ListNode b = ListNode.asList(1, 3, 4);
        ListNode actual = mListOperations.mergeTwoLists(a, b);
        ListNode expect = ListNode.asList(1, 1, 2, 3, 4, 4);
        assertEquals(actual, expect);
    }

    @Test
    public void testMergeKLists() {
        ListNode actual = mListOperations.mergeKLists(new ListNode[]{
                ListNode.asList(1, 4, 5),
                ListNode.asList(1, 3, 4),
                ListNode.asList(2, 6)
        });
        assertEquals(actual, ListNode.asList(1, 1, 2, 3, 4, 4, 5, 6));
    }
}
