package com.hackerrank.linkedlist;

public class MeargeLinkedList2 {

    public static void main(String[] args) {
        int i = 0, j = 0;
        SinglyLinkedListNode s1 = new SinglyLinkedListNode(0);
        SinglyLinkedListNode s12 = s1;
        while (i < 5) {
            SinglyLinkedListNode t = new SinglyLinkedListNode(j++);
            s1.next = t;
            s1 = s1.next;
            i++;
        }
        i = 0;
        j = 4;
        SinglyLinkedListNode s2 = new SinglyLinkedListNode(3);
        SinglyLinkedListNode s3 = s2;
        while (i < 5) {
            SinglyLinkedListNode t = new SinglyLinkedListNode(j++);
            s2.next = t;
            s2 = s2.next;
            i++;
        }
        SinglyLinkedListNode s0 = mergeLists(s12, s3);

        while (s0 != null) {
            System.out.println(s0.data);
            s0 = s0.next;
        }

    }

    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
/*
        h1.n.d<h2.d
        t1 = h1.n
        nb.n = h1.n.n
        . .h1.n.n = nb
        h2 = h2.n*/
        while (head2 != null) {
            SinglyLinkedListNode temp = head1;
            while (temp != null) {
                int ff = head2.data - temp.next.data;

                if (ff == -1 || ff == 1) {
                    SinglyLinkedListNode t = temp.next;
                    SinglyLinkedListNode nb = new SinglyLinkedListNode(head2.data);
                    nb.next = temp.next.next;
                    temp.next.next = nb;
                    head2 = head2.next;
                }
                temp = temp.next;
            }
            head2 = head2.next;
        }
        return head1;
    }

    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        public SinglyLinkedListNode(int data) {
            this.data = data;
        }
    }
}
