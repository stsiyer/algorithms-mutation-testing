package com.example.BasicDSTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.example.BasicDS.AVLTree;

public class AVLTreeAdvancedTest {

    @Test
    public void testInsertionsWithRotations() {
        AVLTree avl = new AVLTree();
        avl.insert(30);
        avl.insert(20);
        avl.insert(40);
        avl.insert(10); // Left rotation
        assertEquals("10 20 30 40", avl.inOrder());

        avl.insert(50); // Right rotation
        assertEquals("10 20 30 40 50", avl.inOrder());
    }

    @Test
    public void testLargeInsertions() {
        AVLTree avl = new AVLTree();
        for (int i = 1; i <= 100; i++) {
            avl.insert(i);
        }
        StringBuilder expected = new StringBuilder();
        for (int i = 1; i <= 100; i++) {
            expected.append(i).append(" ");
        }
        assertEquals(expected.toString().trim(), avl.inOrder());
    }

    @Test
    public void testDeleteRoot() {
        AVLTree avl = new AVLTree();
        avl.insert(30);
        avl.insert(20);
        avl.insert(40);
        avl.delete(30);
        assertEquals("20 40", avl.inOrder());
    }

    @Test
    public void testDeleteLeaf() {
        AVLTree avl = new AVLTree();
        avl.insert(30);
        avl.insert(20);
        avl.insert(40);
        avl.delete(40);
        assertEquals("20 30", avl.inOrder());
    }

    @Test
    public void testDeleteNodeWithOneChild() {
        AVLTree avl = new AVLTree();
        avl.insert(50);
        avl.insert(30);
        avl.insert(70);
        avl.insert(20);
        avl.insert(40);
        avl.delete(30);
        assertEquals("20 40 50 70", avl.inOrder());
    }

    @Test
    public void testDeleteNodeWithTwoChildren() {
        AVLTree avl = new AVLTree();
        avl.insert(50);
        avl.insert(30);
        avl.insert(70);
        avl.insert(60);
        avl.insert(80);
        avl.delete(70);
        assertEquals("30 50 60 80", avl.inOrder());
    }

    @Test
    public void testBalanceAfterInsertion() {
        AVLTree avl = new AVLTree();
        avl.insert(10);
        avl.insert(20);
        avl.insert(30); // Right-right case
        assertEquals("10 20 30", avl.inOrder());

        avl.insert(5);
        avl.insert(15); // Left-right case
        assertEquals("5 10 15 20 30", avl.inOrder());
    }

    @Test
    public void testStressDelete() {
        AVLTree avl = new AVLTree();
        for (int i = 1; i <= 50; i++) {
            avl.insert(i);
        }
        for (int i = 1; i <= 25; i++) {
            avl.delete(i);
        }
        StringBuilder expected = new StringBuilder();
        for (int i = 26; i <= 50; i++) {
            expected.append(i).append(" ");
        }
        assertEquals(expected.toString().trim(), avl.inOrder());
    }

    @Test
    public void testSearchVariousCases() {
        AVLTree avl = new AVLTree();
        avl.insert(10);
        avl.insert(20);
        avl.insert(5);

        assertTrue(avl.search(10)); // Present
        assertFalse(avl.search(15)); // Not present
        avl.delete(10);
        assertFalse(avl.search(10)); // Deleted
    }

    @Test
    public void testEdgeCases() {
        AVLTree avl = new AVLTree();
        avl.insert(10); // Single node
        assertTrue(avl.search(10));
        avl.delete(10); // Empty tree
        assertFalse(avl.search(10));
        assertEquals("", avl.inOrder());
    }
}
