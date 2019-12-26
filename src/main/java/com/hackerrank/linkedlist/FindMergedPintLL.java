package com.hackerrank.linkedlist;

public class FindMergedPintLL {


    // *****
    static int findMergNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        if (head1 == null || head2 == null) return 0;
        while (head1 != null) {
            SinglyLinkedListNode head3 = head2;
            while (head3 != null) {
                if (head1 == head3) {
                    return head1.data;
                }
                head3 = head3.next;
            }
            head1 = head1.next;
        }
        return 0;
    }

    static class
    SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        public SinglyLinkedListNode(int data) {
            this.data = data;
        }
    }
}
