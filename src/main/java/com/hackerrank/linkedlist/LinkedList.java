package com.hackerrank.linkedlist;


public class LinkedList {

    public static Node head, tail;
    public static int last;

    public static void main(String[] args) {

        insert("abcd1 ", 0);
        insert("abcd 2", 1);
        insert("abcdx2", 3);
        insert("abcd 3", 2);
        insert("abcd 4", 3);
        display();
        insert("abcd 9", 2);
        display();
        System.out.println("delete from here");
        delete(0);
        display();
        delete(1);
        display();
        delete(last);
        display();
    }

    static void insert(String val, int pos) {

        Node newNode = new Node();
        newNode.data = val;
        if (0 == pos) {
            Node oldHead = head;
            newNode.next = head;
            head = newNode;
            last++;
            tail = newNode;
            return;
        }
        if (last == pos) {
            tail.next = newNode;
            tail = newNode;
            last++;

            return;
        }
        Node checkNode = null;
        for (int i = 0; i < pos; i++) {
            checkNode = head.next;
        }

        newNode.next = checkNode.next;
        checkNode.next = newNode;
        last++;

    }

    public static void display() {
        System.out.println("------------------------------------------");
        if (head != null) {
            Node t = head;
            do {

                System.out.println(" " + t.data);
                t = t.next;
            } while (t != null);
        }
        System.out.println("------------------------------------------");

    }

    public static void delete(int pos) {

        if (pos == 0) {
            head = head.next;
            last--;
            return;
        }
        Node t = head;
        Node preNode = null;
        for (int i = 0; i < pos - 1; i++) {
            preNode = t;
            t = t.next;
        }
        if (pos == last) {
            preNode.next = null;
        } else
            t.next = t.next.next;
        last--;
    }


    static class Node {
        public String data;
        public Node next;
    }
}
