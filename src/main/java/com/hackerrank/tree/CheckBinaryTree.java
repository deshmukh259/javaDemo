package com.hackerrank.tree;

import java.util.LinkedList;
import java.util.Queue;

public class CheckBinaryTree {

    public static void main(String[] args) {
        //1 2 3 4 5 6 7
        //Node filledRoot = InsertBST.getFilledRoot(new int[]{1, 2, 3, 4, 5, 6, 7});
        Node filledRoot = InsertBST.getFilledRoot(new int[]{1, 2, 4, 3, 5, 6, 7});
        BTreePrinter.printNode(filledRoot);
        System.out.println(checkBST(filledRoot));
    }

    static boolean checkBST(Node root) { // this is one soln

        if (root == null) return true;
        checkBST(root.right);
        if (root.data > root.right.data) return false;
        checkBST(root.left);
        if (root.data < root.left.data) return false;
        return true;
    }

    static boolean checkBST2(Node root) { // this another

        Queue<Node> queue = new LinkedList<>();
        Node temp = root;
        queue.add(temp);
        boolean f = false;
        boolean g = false;
        int r = root.data;
        int lsum = r;
        int rsum = r;
        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            int x = r;
            if (poll != null) {
                //System.out.println("poll.data : " + poll.data);
                Node left = poll.left;
                Node right = poll.right;
                boolean ri = right != null ? poll.data > right.data : false;
                boolean le = left != null ? poll.data < left.data: false;
                //System.out.println("right.data : "+(right != null ?  right.data:"$"));
                //System.out.println("left.data : "+(left != null ?  left.data:"$"));
                if (ri || le) {
                    f = true;
                    break;
                }
                if (g == false) {
                    lsum = left != null ? lsum + left.data : lsum;
                    rsum = right != null ? rsum + right.data : rsum;
                    g = true;
                } else {
                    int tlsum = left != null ? poll.data + left.data : lsum;
                    int trsum = right != null ? poll.data + right.data : rsum;
                    //System.out.println("tlsum " + tlsum);
                    //System.out.println("trsum " + trsum);
                    if (tlsum > lsum || trsum < rsum) {
                        f = true;
                        break;
                    }
                    tlsum = left != null ? poll.data + left.data : lsum;
                    trsum = right != null ? poll.data + right.data : rsum;

                }
                queue.add(poll.left);
                queue.add(poll.right);

            }
        }
        return !f;
    }
}
