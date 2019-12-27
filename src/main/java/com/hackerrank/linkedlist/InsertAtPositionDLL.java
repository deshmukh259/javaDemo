package com.hackerrank.linkedlist;

import java.io.IOException;
import java.util.Scanner;

public class InsertAtPositionDLL {

    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }

    static class DoublyLinkedList {
        public DoublyLinkedListNode head;
        public DoublyLinkedListNode tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
            }

            this.tail = node;
        }
    }

    public static void printDoublyLinkedList(DoublyLinkedListNode node, String sep) {
        while (node != null) {
            if (node != null) {
                System.out.println(node.data);
            }
            node = node.next;
        }
    }

    // Complete the sortedInsert function below.

    /*
     * For your reference:
     *
     * DoublyLinkedListNode {
     *     int data;
     *     DoublyLinkedListNode next;
     *     DoublyLinkedListNode prev;
     * }
     *
     */
    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        DoublyLinkedListNode t = head;
        DoublyLinkedListNode n = new DoublyLinkedListNode(data);
        boolean f = true;
        while (t != null) {
            if (t.data >= data && f) {
                n.next = t;
                t.prev = n;
                return n;
            }
            f = false;
            if (t.data > data) {
                n.next = t;
                n.prev = t.prev;
                t.prev.next = n;
                t.prev = n;
                return head;
            }
            if (t.next == null) {
                t.next = n;
                n.prev = t;
                return head;
            }

            t = t.next;
        }
        return head;


    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {


        DoublyLinkedList llist = new DoublyLinkedList();

        int llistCount = 5;
        int a[] = {1, 2, 3, 4, 55};
        for (int i = 0; i < llistCount; i++) {
            int llistItem = a[i];

            llist.insertNode(llistItem);
        }
        int data = 2;
        DoublyLinkedListNode llist1 = sortedInsert(llist.head, 40);

        printDoublyLinkedList(llist1, " ");


        scanner.close();
    }
}
