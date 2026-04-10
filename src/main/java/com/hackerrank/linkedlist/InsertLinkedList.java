package com.hackerrank.linkedlist;

public class InsertLinkedList {


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

    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;
        public SinglyLinkedListNode(int data) {
            this.data = data;
        }
    }
}
