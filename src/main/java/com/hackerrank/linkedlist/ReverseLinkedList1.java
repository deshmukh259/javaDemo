package com.hackerrank.linkedlist;

public class ReverseLinkedList1 {


    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;
    }

    public static void main(String[] args) {

        int i = 0, j = 0;
        SinglyLinkedListNode s0 = new SinglyLinkedListNode();
        s0.data = 0;
        SinglyLinkedListNode s1 = new SinglyLinkedListNode();
        s1.data = 11;
        s0.next = s1;
        while (i < 5) {
            SinglyLinkedListNode t = new SinglyLinkedListNode();
            t.data = j++;
            s1.next = t;
            s1 = s1.next;
            i++;
        }
        s0 = reverse(s0);

        while (s0 != null) {
            System.out.println(s0.data);
            s0 = s0.next;
        }
    }

    static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {


        SinglyLinkedListNode temp = head;
        SinglyLinkedListNode pre = null;
        SinglyLinkedListNode t = null;

        while (temp != null) {  // 1    2   3   4   5   6   7   8   9
            if (pre == null) {
                pre = temp; // 1
                temp = temp.next; //2
                continue;
            }
            if (t == null) {
                t = pre; //1
                pre = temp; // 2
                temp = temp.next; // 3
                t.next = null;
                continue;
            }

            pre.next = t; // 3 ->2->1,
            t = pre;
            if (temp.next == null) {
                temp.next = pre;
                return temp;
            }
            pre = temp; //3
            temp = temp.next; // 4


        }

        return pre;

    }
}
