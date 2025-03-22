package org.dsa;

class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.left = null;
        this.right = null;
    }
}

class BinaryTree {
    Node root;

    public void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.println(node.data + " ");
            inorder(node.right);
        }
    }

    public void preorder(Node node) {
        if (node != null) {
            System.out.println(node.data + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    
}
public class BinaryTreeTest {
    public static void main(String[] args) {

    }
}
