package com.hackerrank.linkedlist;

public class ReverseLinkedList {


    static void reversePrint(SinglyLinkedListNode head) {

        if (head == null) {
            return;
        }

        reversePrint(head.next);
        System.out.println(head.data);


    }

    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;
    }
}
