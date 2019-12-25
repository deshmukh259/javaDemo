package com.hackerrank.linkedlist;

public class DeleteAtPostionLL {

    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;
    }


    static SinglyLinkedListNode deleteNodeAtPosition(SinglyLinkedListNode head, int position) {


        if (head == null || position == 0) {
            return null;
        }
        SinglyLinkedListNode temp = head;
        SinglyLinkedListNode pre = null;
        while (position > 1) {
            // 0 1 2 3 4 5 6
            ///*20 0 3
            //6 1 2
            //2 2 1
            //19 0
            //7
            //4
            //15
            //9
            // */
            pre = temp;
            temp = temp.next;
            position--;
        }
        pre.next  = temp.next;
        return head;

    }
}
