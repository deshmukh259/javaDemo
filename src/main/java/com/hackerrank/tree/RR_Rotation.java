package com.hackerrank.tree;

public class RR_Rotation {

    public static void main(String[] args) {

        int[] kk = {4, 2, 7, 1, 3, 23, 45, 44, 1, 89};
        Node root = InsertBST.getFilledRoot(kk);
        Node v = root.right.right;
        BTreePrinter.printNode(root);
        root.right.right = RR_Rotation(v);
        BTreePrinter.printNode(root);

    }

    public static Node RR_Rotation(Node root) {

        if (root == null) return null;
        /*            23
         *               45
         *           44      89
         *
         * */

        Node retNode = root.right;
        root.right = root.right.left;
        root.left = null;
        retNode.left = root;
        return retNode;


    }

}
