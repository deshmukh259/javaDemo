package com.hackerrank.tree;


import java.util.Scanner;


class HeightOfBT {

    /*
    class Node
        int data;
        Node left;
        Node right;
    */


    public static int height(Node root) {

        if (root == null) return 0;

        int l = height(root.left);
        int r = height(root.right);
        if (l > r) {
            return l + 1;
        } else
            return r + 1;

    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }
}
