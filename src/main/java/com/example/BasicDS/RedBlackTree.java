package com.example.BasicDS;

public class RedBlackTree {
    public static final int RED = 0;
    public static final int BLACK = 1;

    private class Node {
        int data, color;
        Node left, right, parent;

        Node(int data) {
            this.data = data;
            this.color = RED;
            this.left = this.right = this.parent = null;
        }
    }

    private Node root;

    public RedBlackTree() {
        root = null;
    }

    // Insert a new node
    public void insert(int data) {
        Node newNode = new Node(data);
        root = insert(root, newNode);
        fixInsert(newNode);
    }

    // Insert Helper
    private Node insert(Node root, Node newNode) {
        if (root == null) {
            return newNode;
        }
        if (newNode.data < root.data) {
            root.left = insert(root.left, newNode);
            root.left.parent = root;
        } else if (newNode.data > root.data) {
            root.right = insert(root.right, newNode);
            root.right.parent = root;
        }
        return root;
    }

    // Fixing violations of Red-Black Tree properties
    private void fixInsert(Node node) {
        Node parent = null;
        Node grandParent = null;

        while (node != root && node.color == RED && node.parent.color == RED) {
            parent = node.parent;
            grandParent = parent.parent;

            if (parent == grandParent.left) {
                Node uncle = grandParent.right;
                if (uncle != null && uncle.color == RED) {
                    // Case 1: Uncle is RED
                    grandParent.color = RED;
                    parent.color = BLACK;
                    uncle.color = BLACK;
                    node = grandParent;
                } else {
                    if (node == parent.right) {
                        // Case 2: Node is a right child, left rotate it
                        node = parent;
                        leftRotate(node);
                    }
                    // Case 3: Node is a left child, right rotate it
                    parent.color = BLACK;
                    grandParent.color = RED;
                    rightRotate(grandParent);
                }
            } else {
                Node uncle = grandParent.left;
                if (uncle != null && uncle.color == RED) {
                    // Case 1: Uncle is RED
                    grandParent.color = RED;
                    parent.color = BLACK;
                    uncle.color = BLACK;
                    node = grandParent;
                } else {
                    if (node == parent.left) {
                        // Case 2: Node is a left child, right rotate it
                        node = parent;
                        rightRotate(node);
                    }
                    // Case 3: Node is a right child, left rotate it
                    parent.color = BLACK;
                    grandParent.color = RED;
                    leftRotate(grandParent);
                }
            }
        }
        root.color = BLACK;
    }

    // Left rotate
    private void leftRotate(Node node) {
        Node newParent = node.right;
        node.right = newParent.left;
        if (newParent.left != null) {
            newParent.left.parent = node;
        }
        newParent.parent = node.parent;
        if (node.parent == null) {
            root = newParent;
        } else if (node == node.parent.left) {
            node.parent.left = newParent;
        } else {
            node.parent.right = newParent;
        }
        newParent.left = node;
        node.parent = newParent;
    }

    // Right rotate
    private void rightRotate(Node node) {
        Node newParent = node.left;
        node.left = newParent.right;
        if (newParent.right != null) {
            newParent.right.parent = node;
        }
        newParent.parent = node.parent;
        if (node.parent == null) {
            root = newParent;
        } else if (node == node.parent.right) {
            node.parent.right = newParent;
        } else {
            node.parent.left = newParent;
        }
        newParent.right = node;
        node.parent = newParent;
    }

    // Inorder traversal
    public String inorder() {
        StringBuilder sb = new StringBuilder();
        inorder(root, sb);
        return sb.toString().trim();
    }

    private void inorder(Node node, StringBuilder sb) {
        if (node != null) {
            inorder(node.left, sb);
            sb.append(node.data).append(" ");
            inorder(node.right, sb);
        }
    }

    // Search for a value in the tree
    public boolean search(int key) {
        return search(root, key);
    }

    private boolean search(Node node, int key) {
        if (node == null) {
            return false;
        }
        if (key == node.data) {
            return true;
        }
        if (key < node.data) {
            return search(node.left, key);
        }
        return search(node.right, key);
    }

    // Delete a node
    public void delete(int key) {
        root = delete(root, key);
    }

    private Node delete(Node root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.data) {
            root.left = delete(root.left, key);
        } else if (key > root.data) {
            root.right = delete(root.right, key);
        } else {
            if (root.left == null || root.right == null) {
                Node temp = (root.left != null) ? root.left : root.right;
                if (temp == null) {
                    temp = root;
                    root = null;
                } else {
                    root = temp;
                }
            } else {
                Node temp = minValueNode(root.right);
                root.data = temp.data;
                root.right = delete(root.right, temp.data);
            }
        }
        return root;
    }

    private Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }
}
