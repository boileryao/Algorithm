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
        ListNode list = ListNode.makeList(1, 6);
        ListNode interaction = mListOperations.getIntersectionNode(list, list);
        assertEquals(interaction, list);
    }

    @Test
    public void testGetIntersectionNode_NonInteraction() {
        ListNode list1 = ListNode.makeList(1, 6);
        ListNode list2 = ListNode.makeList(1, 5);

        ListNode interaction = mListOperations.getIntersectionNode(list1, list2);
        assertNull(interaction);
    }

    @Test
    public void testGetIntersectionNode_Interaction() {
        ListNode list1 = ListNode.makeList(1, 6);
        ListNode list2 = ListNode.makeList(1);
        list2.next = list1;

        ListNode interaction = mListOperations.getIntersectionNode(list1, list2);
        assertEquals(interaction, list1);
    }

    @Test
    public void testReverseList() {
        ListNode head = ListNode.makeList(1, 4);
        assertEquals(head.toString(), "1 2 3 4");
        ListNode reversedHead = mListOperations.invertLinkedList(head);
        assertEquals(reversedHead.toString(), "4 3 2 1");
    }

    @Test
    public void testReverseList_OneElement() {
        ListNode head = ListNode.makeList(1);
        ListNode reversedHead = mListOperations.invertLinkedList(head);
        assertEquals(reversedHead.toString(), "1");
    }

    @Test
    public void testReverseList_Empty() {
        ListNode head = ListNode.makeList();
        ListNode reversedHead = mListOperations.invertLinkedList(head);
        assertNull(reversedHead);
    }

    @Test
    public void testRemoveNthFromEnd_Atom() {
        ListNode head = ListNode.makeList(1);
        ListNode reversedHead = mListOperations.removeNthFromEnd(head, 1);
        assertNull(reversedHead);
    }

    @Test
    public void testRemoveNthFromEnd_22() {
        ListNode head = ListNode.makeList(1, 2);
        ListNode reversedHead = mListOperations.removeNthFromEnd(head, 2);
        assertEquals(reversedHead.toString(), "2");
    }

    @Test
    public void testRemoveNthFromEnd_21() {
        ListNode head = ListNode.makeList(1, 2);
        ListNode reversedHead = mListOperations.removeNthFromEnd(head, 1);
        assertEquals(reversedHead.toString(), "1");
    }

    @Test
    public void testRemoveNthFromEnd_5() {
        ListNode head = ListNode.makeList(1, 5);
        ListNode reversedHead = mListOperations.removeNthFromEnd(head, 2);
        assertEquals(reversedHead.toString(), "1 2 3 5");
    }

    @Test
    public void testMergeTwoLists() {
        ListNode a = ListNode.makeList(1, 2, 4);
        ListNode b = ListNode.makeList(1, 3, 4);
        ListNode actual = mListOperations.mergeTwoLists(a, b);
        ListNode expect = ListNode.makeList(1, 1, 2, 3, 4, 4);
        assertEquals(actual.toString(), expect.toString());
    }
}
