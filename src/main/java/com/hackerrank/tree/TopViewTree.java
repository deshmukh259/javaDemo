package com.hackerrank.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TopViewTree {

    public static void topView(Node root) {


        if (root == null)
            return;

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


        boolean bb = false;
        if (root.right != null)
            bb = true;

        while (root != null) {
            System.out.print(root.data + " ");
            root = bb ? root.right : root.left;

        }
    }

    public static void main(String[] args) {
        Node filledRoot = InsertBST.getFilledRoot(null);
        BTreePrinter.printNode(filledRoot);
        topView(filledRoot);
    }
}
