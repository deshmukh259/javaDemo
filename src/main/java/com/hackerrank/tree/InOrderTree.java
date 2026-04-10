package com.hackerrank.tree;


class InOrderTree {
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
/* you only have to complete the function given below.
Node is defined as

class Node {
    int data;
    Node left;
    Node right;
}

*/

    public static void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static PreOrderTree.Node insert(PreOrderTree.Node root, int data) {
        if (root == null) {
            return new PreOrderTree.Node(data);
        } else {
            PreOrderTree.Node cur;
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
}