package com.hackerrank.tree;

import java.util.LinkedList;
import java.util.Queue;

public class SwapNode {


    public static void main(String[] args) {

        int[] a = {100, 75, 120, 50, 130, 150, 40};

        Node bb = InsertBST.getFilledRoot(a);
        BTreePrinter.printNode(bb);
        bb = swapNode(bb);
        BTreePrinter.printNode(bb);


    }

    public static Node swapNode(Node root) {

        if (root == null) {
            return null;
        }
        Node temp = root;
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(temp);

        while (!nodeQueue.isEmpty()) {

            temp = nodeQueue.peek();
            Node left = temp.left;
            Node right = temp.right;
            Node v = left;
            temp.left = right;
            temp.right = v;
            if (left != null) nodeQueue.add(left);
            if (right != null) nodeQueue.add(right);
            nodeQueue.poll();

        }
        return root;


    }
}
