package com.example.TreeTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.example.Tree.CeilInBinarySearchTree;
import com.example.Tree.Node;

public class CeilInBinarySearchTreeTest {

    @Test
    public void testCeilInBinarySearchTree() {
        assertNull(CeilInBinarySearchTree.getCeil(null, 9));
        Node root1 = TreeTestUtils.createTree(new Integer[]{100, 10, 200});
        assertEquals(100, CeilInBinarySearchTree.getCeil(root1, 100).data);
        Node root2 = TreeTestUtils.createTree(new Integer[]{100, 10, 200});
        assertEquals(10, CeilInBinarySearchTree.getCeil(root2, 10).data);
        Node root3 = TreeTestUtils.createTree(new Integer[]{100, 10, 200, 5, 50, 150, 300});
        assertEquals(100, CeilInBinarySearchTree.getCeil(root3, 75).data);
        Node root4 = TreeTestUtils.createTree(new Integer[]{100, 10, 200, 5, 50, 150, 300});
        assertEquals(50, CeilInBinarySearchTree.getCeil(root4, 40).data);
        Node root5 = TreeTestUtils.createTree(new Integer[]{100, 10, 200, 5, 50, 150, 300});
        assertEquals(5, CeilInBinarySearchTree.getCeil(root5, 1).data);
        Node root6 = TreeTestUtils.createTree(new Integer[]{100, 10, 200, 5, 50, 150, 300});
        assertNull(CeilInBinarySearchTree.getCeil(root6, 400));
    }
}