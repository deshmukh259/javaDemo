package com.hackerrank.tree;

public class AVLLLConditionTree {


    public static void main(String[] args) {
        int kk[] = {15, 9, 5, 7, 23};
        int t = 0;
        Node root = null;
        while (t < kk.length) {
            int data = kk[t++];
            root = InsertBST.insert(root, data);
        }

        BTreePrinterTest.display(root);
        System.out.println("------------");
        root.left = LR_Rotaion(root.left);

        System.out.println("------------");
        BTreePrinterTest.display(root);

        System.out.println("------------");
        //preOrder(root);
        BTreePrinterTest.display(root);

//        int l = HeightOfBT.height(root.left);
//        int r = HeightOfBT.height(root.right);
//        if (l - r > 1) {
//            System.out.println("----------- r_r------------");
//            root.left = R_Rotation(root.left);
//        }
//        BTreePrinterTest.display(root);

    }

    private static Node LR_Rotaion(Node distb) {

        // point to left of dist in new node
        //  30
        //20
        //  25
        Node newN = distb.left.right;
        distb.left.right = distb.left.right.left;
        newN.left = distb.left;
        //distb.left = R_Rotation(distb.left.left);
        distb.left = newN;
        return R_Rotation(distb);


    }

    public static Node R_Rotation(Node dist) {

        //              40
        //          30
        //      20

        //  newNode = 30
        // 30-r.40
        //
        if (dist == null) return null;

        Node newN = dist.left;
        newN.right = dist;
        dist.left = null;
        return newN;

    }


}
