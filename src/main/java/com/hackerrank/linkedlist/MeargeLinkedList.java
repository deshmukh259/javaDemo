package com.hackerrank.linkedlist;

public class MeargeLinkedList {

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
        while (head2 != null) {
            SinglyLinkedListNode t2 = head1;
            SinglyLinkedListNode t1 = head1;
            SinglyLinkedListNode tb = null;
            SinglyLinkedListNode pre = null;
            if (head2.data == Integer.MIN_VALUE) {
                head2 = head2.next;
                continue;
            }
            while (t1 != null) {
                if (pre == null) {
                    pre = t1;
                    t1 = t1.next;
                    continue;
                }
                if (head2.data <= pre.data) {

                    SinglyLinkedListNode cc = new SinglyLinkedListNode(head2.data);
                    head2.data = Integer.MIN_VALUE;
                    cc.next = t2.next.next;
                    t2.next.next = cc;

                }
                t2 = pre;
                pre = t1;
                t1 = t1.next;
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
