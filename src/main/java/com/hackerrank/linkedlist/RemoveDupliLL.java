package com.hackerrank.linkedlist;

public class RemoveDupliLL {


    public static void main(String[] args) {


        SinglyLinkedListNode s2 = new SinglyLinkedListNode(3);
        SinglyLinkedListNode s3 = s2;
        int i = 0;
        int j = 2;
        while (i < 5) {
            SinglyLinkedListNode t = new SinglyLinkedListNode(j++);
            s2.next = t;
            s2 = s2.next;
            i++;
        }
        s3.next.next.data = 4;
        s3.next.data = 4;
        s3.next.next.next.data = 4;

        removeDuplicates(s3);
    }

    // *****
    static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head) {
        SinglyLinkedListNode t = head;
        SinglyLinkedListNode p = new SinglyLinkedListNode(Integer.MIN_VALUE);
        while (t != null) {
            if (p.data == t.data) {
                p.next = t.next;
                t = t.next;
                continue;
            }
            p = t;
            t = t.next;
        }
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
