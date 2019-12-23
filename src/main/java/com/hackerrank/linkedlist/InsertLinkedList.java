package com.hackerrank.linkedlist;

public class InsertLinkedList {


    static class SinglyLinkedListNode {
        public SinglyLinkedListNode(int data) {
            this.data = data;
        }

        int data;
        SinglyLinkedListNode next;
    }

    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {

        SinglyLinkedListNode singlyLinkedListNode = new SinglyLinkedListNode(data);
        if (head == null) {
            head = singlyLinkedListNode;
            return head;
        }
        SinglyLinkedListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = singlyLinkedListNode;
        return head;
    }
}
