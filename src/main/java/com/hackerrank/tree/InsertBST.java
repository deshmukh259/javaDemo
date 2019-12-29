package com.hackerrank.tree;

class InsertBST {

    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static void preOrder(Node root) {

        if (root == null)
            return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);

    }

 /* Node is defined as :
 class Node
    int data;
    Node left;
    Node right;

    */

    public static Node insert(Node root, int data) {

        if (root == null) {
            return new Node(data);
        }

        if (root.data > data && root.left == null) {
            Node n = new Node(data);
            root.left = n;
            return root;
        }
        if (root.data < data && root.right == null) {
            Node n = new Node(data);
            root.right = n;
            return root;
        }

        if (root.data > data)
            insert(root.left, data);
        else
            insert(root.right, data);
        return root;


    }

    public static void main(String[] args) {
        int kk[] = {4, 2, 7, 1, 3};
        int t = 0;
        Node root = null;
        while (t < 5) {
            int data = kk[t++];
            root = insert(root, data);
        }
        System.out.println("------------");
        preOrder(root);
    }
}
