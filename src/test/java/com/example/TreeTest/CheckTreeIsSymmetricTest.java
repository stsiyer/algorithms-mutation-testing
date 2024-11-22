package com.example.TreeTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.example.Tree.CheckTreeIsSymmetric;
import com.example.Tree.Node;

public class CheckTreeIsSymmetricTest {

    @Test
    public void testSymmetric() {
        assertTrue(CheckTreeIsSymmetric.isSymmetric(null));
        Node root1 = TreeTestUtils.createTree(new Integer[]{100});
        assertTrue(CheckTreeIsSymmetric.isSymmetric(root1));
        Node root2 = TreeTestUtils.createTree(new Integer[]{1,2,2,3,4,4,3});
        assertTrue(CheckTreeIsSymmetric.isSymmetric(root2));
        Node root3 = TreeTestUtils.createTree(new Integer[]{1,2,2,3,5,4,3});
        assertFalse(CheckTreeIsSymmetric.isSymmetric(root3));
    }
}