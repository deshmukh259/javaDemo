package com.hackerrank.tree;

public class CommonLowestAncestor {

    public static Node lca(Node root, int v1, int v2) {

        if (root == null) return null;
        if(root.data == v1 || root.data == v2) return root;
        Node v11 = lca(root.left,v1,v2);
        Node v22 = lca(root.right,v1,v2);
        if(v11!= null && v22 != null) return root;
        if(v11== null && v22 == null) return null;

        return v11!= null?v11:v22;




    }
}
