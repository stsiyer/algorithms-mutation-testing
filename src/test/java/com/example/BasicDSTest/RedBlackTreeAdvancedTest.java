package com.example.BasicDSTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.example.BasicDS.RedBlackTree;

public class RedBlackTreeAdvancedTest {

    @Test
    public void testInsertAndStructure() {
        RedBlackTree rbt = new RedBlackTree();
        rbt.insert(10);
        rbt.insert(20);
        rbt.insert(5);
        rbt.insert(4);
        rbt.insert(8);
        assertEquals("4 5 8 10 20", rbt.inorder());
    }

    @Test
    public void testLargeInsertions() {
        RedBlackTree rbt = new RedBlackTree();
        for (int i = 1; i <= 100; i++) {
            rbt.insert(i);
        }
        StringBuilder expected = new StringBuilder();
        for (int i = 1; i <= 100; i++) {
            expected.append(i).append(" ");
        }
        assertEquals(expected.toString().trim(), rbt.inorder());
    }

    @Test
    public void testDeleteRoot() {
        RedBlackTree rbt = new RedBlackTree();
        rbt.insert(10);
        rbt.insert(20);
        rbt.insert(5);
        rbt.delete(10);
        assertEquals("5 20", rbt.inorder());
    }

    @Test
    public void testDeleteLeaf() {
        RedBlackTree rbt = new RedBlackTree();
        rbt.insert(15);
        rbt.insert(10);
        rbt.insert(20);
        rbt.delete(10);
        assertEquals("15 20", rbt.inorder());
    }

    @Test
    public void testDeleteNodeWithOneChild() {
        RedBlackTree rbt = new RedBlackTree();
        rbt.insert(50);
        rbt.insert(30);
        rbt.insert(70);
        rbt.insert(20);
        rbt.insert(40);
        rbt.delete(30);
        assertEquals("20 40 50 70", rbt.inorder());
    }

    @Test
    public void testDeleteNodeWithTwoChildren() {
        RedBlackTree rbt = new RedBlackTree();
        rbt.insert(50);
        rbt.insert(30);
        rbt.insert(70);
        rbt.insert(60);
        rbt.insert(80);
        rbt.delete(70);
        assertEquals("30 50 60 80", rbt.inorder());
    }

    @Test
    public void testStressDelete() {
        RedBlackTree rbt = new RedBlackTree();
        for (int i = 1; i <= 50; i++) {
            rbt.insert(i);
        }
        for (int i = 1; i <= 25; i++) {
            rbt.delete(i);
        }
        StringBuilder expected = new StringBuilder();
        for (int i = 26; i <= 50; i++) {
            expected.append(i).append(" ");
        }
        assertEquals(expected.toString().trim(), rbt.inorder());
    }

    @Test
    public void testSearchVariousCases() {
        RedBlackTree rbt = new RedBlackTree();
        rbt.insert(10);
        rbt.insert(20);
        rbt.insert(5);

        assertTrue(rbt.search(10)); // Present
        assertFalse(rbt.search(15)); // Not present
        rbt.delete(10);
        assertFalse(rbt.search(10)); // Deleted
    }

    @Test
    public void testEdgeCases() {
        RedBlackTree rbt = new RedBlackTree();
        rbt.insert(10); // Single node
        assertTrue(rbt.search(10));
        rbt.delete(10); // Empty tree
        assertFalse(rbt.search(10));
        assertEquals("", rbt.inorder());
    }
}
