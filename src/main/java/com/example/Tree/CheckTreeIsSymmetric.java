package com.example.Tree;

public class CheckTreeIsSymmetric {

    public static boolean isSymmetric(Node root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private static boolean isSymmetric(Node leftSubtreeRoot, Node rightSubtreRoot) {
        if (leftSubtreeRoot == null && rightSubtreRoot == null) {
            return true;
        }
        if (leftSubtreeRoot == null || rightSubtreRoot == null || leftSubtreeRoot.data != rightSubtreRoot.data) {
            return false;
        }
        return isSymmetric(leftSubtreeRoot.right, rightSubtreRoot.left) && isSymmetric(leftSubtreeRoot.left, rightSubtreRoot.right);
    }
}
