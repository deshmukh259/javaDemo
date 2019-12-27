package com.hackerrank.linkedlist;

public class SimpleLinkedList {


    // Complete the printLinkedList function below.


    public static void main(String[] args) {

    }

    static void printLinkedList(SinglyLinkedListNode head) {
        if (head != null) {
            while (head.next != null) {
                System.out.println(head.data);
                head = head.next;
            }
        }
    }

    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;
    }
}
