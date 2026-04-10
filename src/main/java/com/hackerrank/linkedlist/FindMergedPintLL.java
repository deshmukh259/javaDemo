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
/*
* int FindMergeNode(Node headA, Node headB) {
    Node currentA = headA;
    Node currentB = headB;

    //Do till the two nodes are the same
    while(currentA != currentB){
        //If you reached the end of one list start at the beginning of the other one
        //currentA
        if(currentA.next == null){
            currentA = headB;
        }else{
            currentA = currentA.next;
        }
        //currentB
        if(currentB.next == null){
            currentB = headA;
        }else{
            currentB = currentB.next;
        }
    }
    return currentB.data;
* */
    static class
    SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        public SinglyLinkedListNode(int data) {
            this.data = data;
        }
    }
}
