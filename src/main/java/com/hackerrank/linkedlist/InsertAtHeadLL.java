package com.hackerrank.linkedlist;

public class InsertAtHeadLL {

    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;
    }


    static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {

        SinglyLinkedListNode singlyLinkedListNode = new SinglyLinkedListNode();
        singlyLinkedListNode.data = data;
        if (llist == null) {
            return singlyLinkedListNode;
        }
        singlyLinkedListNode.next = llist;
        return singlyLinkedListNode;

    }

}
