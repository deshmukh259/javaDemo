package com.hackerrank.tree;


import java.util.LinkedList;
import java.util.Queue;



public  class OrderLevelTree {
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
    /*

    class Node
        int data;
        Node left;
        Node right;
    */
    public static void levelOrder(Node root) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node t = root;
        int j = 0;
        while (!queue.isEmpty()) {
            t = queue.peek();
            if (t.left != null)
                queue.add(t.left);

            if (t.right != null)
                queue.add(t.right);
            System.out.print(queue.poll().data + " ");
            j++;
        }


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
        int t = 0;
        int kk[] = {1, 2, 5, 3, 6, 4};
        Node root = null;
        while (t < 6) {
            int data = kk[t++];
            root = insert(root, data);
        }
        levelOrder(root);
    }
}