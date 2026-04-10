package com.hackerrank.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class VerticalOrderTraversal {


    public static void main(String[] args) {

        Node node = InsertBST.getFilledRoot(null);
        BTreePrinter.printNode(node);
        verticalOrderTraversal(node);

    }

    public static void verticalOrderTraversal(Node root) {


        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        HashMap<Integer, String> hm = new HashMap<>();

        root.vd = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            Node n = queue.poll();
            if (n.left != null) {
                Node left = n.left;
                left.vd = n.vd - 1;
                queue.add(left);
            }
            if (n.right != null) {
                Node right = n.right;
                right.vd = n.vd + 1;
                queue.add(right);
            }
            int vd = n.vd;
            String s = hm.get(vd);
            if (s == null) {
                hm.put(vd, String.valueOf(n.data));
            } else {
                s = s + "," + n.data;
                hm.put(vd, s);
            }
        }
        System.out.println(hm);


    }
}
