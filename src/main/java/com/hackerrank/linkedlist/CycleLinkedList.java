package com.hackerrank.linkedlist;

public class CycleLinkedList {


    static boolean hasCycle(SinglyLinkedListNode head) {

        SinglyLinkedListNode t1 = head;
        if (head == null) {
            return false;
        }
        SinglyLinkedListNode next1 = head.next;
        if (next1 == null) return false;
        if (next1.next == null) return false;
        SinglyLinkedListNode t2 = next1.next;
        int c = 0;
        while (t1 != t2) {
            c++;
            if (c > 1000) return false;
            if (t1 == null || t2 == null) {
                return false;
            }
            t1 = t1.next;
            SinglyLinkedListNode next = t2.next;
            if (next.next == null) return false;
            t2 = next;
        }

        return true;

    }

    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;
    }

}
