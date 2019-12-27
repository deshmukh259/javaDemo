package com.hackerrank.linkedlist;

public class InsertAtPostionLL {

    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {


        SinglyLinkedListNode singlyLinkedListNode = new SinglyLinkedListNode();
        if (head == null || position == 0) {
            singlyLinkedListNode.next = head;
            return singlyLinkedListNode;
        }
        SinglyLinkedListNode temp = head;
        SinglyLinkedListNode pre = null;
        while (position > 0) {
            // 0 1 2 3 4 5 6
            //
            pre = temp;
            temp = temp.next;
            position--;
        }
        pre.next = singlyLinkedListNode.next = temp;
        return head;

    }

    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;
    }
}
