package com.example.Tree;

public class CeilInBinarySearchTree {
	public static Node getCeil(Node root, int key) {
        if (root == null) {
            return null;
        }

        if (root.data == key) {
            return root;
        }

        if (root.data < key) {
            return getCeil(root.right, key);
        }

        Node result = getCeil(root.left, key);

        return result == null ? root : result;
    }
}
