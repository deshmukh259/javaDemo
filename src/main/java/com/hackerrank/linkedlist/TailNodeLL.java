package com.hackerrank.linkedlist;

public class TailNodeLL {
    //*****
    static int getNode(SinglyLinkedListNode head, int positionFromTail) {

        SinglyLinkedListNode current = head;
        SinglyLinkedListNode result = head;
        long index = 0;
        while (current != null) {
            current = current.next;


            if (index++ > positionFromTail) {
                result = result.next;
            }
        }
        return result.data;


//
//        if (head == null) {
//            return positionFromTail-=-1;
//        }
//
//        int b = getNode(head.next, positionFromTail);
//        if (positionFromTail == 1)
//            b=  head.data;
//
//
//        return b;

    }

    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        public SinglyLinkedListNode(int data) {
            this.data = data;
        }
    }
}
