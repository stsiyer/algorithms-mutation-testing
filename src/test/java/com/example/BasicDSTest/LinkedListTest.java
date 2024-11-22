package com.example.BasicDSTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.example.BasicDS.LL;


public class LinkedListTest {

    @Test
    public void testAdd() {
        LL list = new LL();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals("1 -> 2 -> 3 -> null", list.toString());
    }

    @Test
    public void testRemove() {
        LL list = new LL();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(2);
        assertEquals("1 -> 3 -> null", list.toString());

        list.remove(1);
        assertEquals("3 -> null", list.toString());

        list.remove(3);
        assertEquals("null", list.toString());

        list.remove(4); // Non-existing value
        assertEquals("null", list.toString());
    }

    @Test
    public void testPalindrome() {
        LL list = new LL();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(1);
        assertEquals(true, list.isPalindrome());

        list = new LL();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(1);
        assertEquals(true, list.isPalindrome());

        list = new LL();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(false, list.isPalindrome());
    }

    @Test
    public void testReverse() {
        LL list = new LL();
        list.add(1);
        list.add(2);
        list.add(3);
        list.reverse();
        assertEquals("3 -> 2 -> 1 -> null", list.toString());

        list = new LL();
        list.add(1);
        list.reverse();
        assertEquals("1 -> null", list.toString());

        list = new LL();
        list.reverse();
        assertEquals("null", list.toString());
    }

    @Test
    public void testEdgeCases() {
        LL list = new LL();

        // Empty list tests
        assertEquals(true, list.isPalindrome());
        list.reverse();
        assertEquals("null", list.toString());

        // Single element list
        list.add(1);
        assertEquals(true, list.isPalindrome());
        list.reverse();
        assertEquals("1 -> null", list.toString());
    }

    @Test
    public void testComplexCases() {
        LL list = new LL();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(1);

        list.reverse();
        assertEquals("1 -> 2 -> 3 -> 2 -> 1 -> null", list.toString());
    }
}
