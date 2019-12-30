package com.hackerrank.tree;

public class DelNodeBST {
    // if root = null just return
    // d > root -> go in the right
    // d < root -> go in thew left
    // find the node to be delete
    // case 1# node is leaf just delete it
    //case 2# node having 1 child just point that chil to curr node parent
    //case 3# if node have 2 child then find successor/precedncer and replace it


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

    public static Node deleteNode(Node root, int data) {
        if (root == null) return null;

        if (root.data > data) root.left = deleteNode(root.left, data);
        else if (root.data < data) root.right = deleteNode(root.right, data);

        else {
            //1#
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left != null) {
                root = root.left;
            } else if (root.right != null) {
                root = root.right;
            } else if (root.left != null && root.right != null) {
                Node nn = min(root.right);
                root.data = nn.data;
                root.right = deleteNode(root.right, nn.data);
            }
        }
        return root;
    }

    static Node min(Node node) {
        if (node == null) return null;
        return min(node.left);
    }

    // Helper Method for delete
    public static Node deleteNode1(Node root, int value) {
        if (root == null) {
            System.out.println("Value not found in BST");
            return null;
        }
        if (value < root.data) {
            root.left = (deleteNode1(root.left, value));
        } else if (value > root.data) {
            root.right = (deleteNode1(root.right, value));
        } else { // If currentNode is the node to be deleted

            if (root.left != null && root.right != null) { // if nodeToBeDeleted have both children
                Node temp = root;
                Node minNodeForRight = min(temp.right);// Finding minimum element from right subtree
                root.data = (minNodeForRight.data); // Replacing current node with minimum node from right subtree
                root.right = (deleteNode1(root.right, minNodeForRight.data));  // Deleting minimum node from right now
            } else if (root.left != null) {// if nodeToBeDeleted has only left child
                root = root.left;
            } else if (root.right != null) {// if nodeToBeDeleted has only right child
                root = root.right;
            } else // if nodeToBeDeleted do not have child (Leaf node)
                root = null;
        }
        return root;
    }// end of method*/

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
        int kk[] = {4, 2, 7, 1, 3, 23, 45, 1, 89};
        int t = 0;
        Node root = null;
        while (t < kk.length) {
            int data = kk[t++];
            root = insert(root, data);
        }
        System.out.println("------------");
        preOrder(root);
        deleteNode(root, 1);
        System.out.println("------------");
        preOrder(root);
        System.out.println("------------");
        preOrder(root);
        deleteNode(root, 3);
        System.out.println("------------");
        preOrder(root);
    }


}
