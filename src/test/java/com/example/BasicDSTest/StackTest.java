package com.example.BasicDSTest;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.EmptyStackException;

import org.junit.Test;

import com.example.BasicDS.Stack;

public class StackTest {

    @Test
    public void testPushAndToString() {
        Stack stack = new Stack(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        assertEquals("10 20 30", stack.toString());
    }

    @Test
    public void testPop() {
        Stack stack = new Stack(3);
        stack.push(10);
        stack.push(20);
        stack.push(30);

        assertEquals(30, stack.pop());
        assertEquals(20, stack.pop());
        assertEquals(10, stack.pop());

        assertThrows(EmptyStackException.class, stack::pop);
    }

    @Test
    public void testPeek() {
        Stack stack = new Stack(3);
        stack.push(10);
        stack.push(20);

        assertEquals(20, stack.peek());
        stack.pop();
        assertEquals(10, stack.peek());

        stack.pop();
        assertThrows(EmptyStackException.class, stack::peek);
    }

    @Test
    public void testIsEmpty() {
        Stack stack = new Stack(3);
        assertEquals(true, stack.isEmpty());

        stack.push(10);
        assertEquals(false, stack.isEmpty());

        stack.pop();
        assertEquals(true, stack.isEmpty());
    }

    @Test
    public void testSize() {
        Stack stack = new Stack(5);
        assertEquals(0, stack.size());

        stack.push(10);
        stack.push(20);
        assertEquals(2, stack.size());

        stack.pop();
        assertEquals(1, stack.size());
    }

    @Test
    public void testStackOverflow() {
        Stack stack = new Stack(2);
        stack.push(10);
        stack.push(20);

        assertThrows(StackOverflowError.class, () -> stack.push(30));
    }

    @Test
    public void testEdgeCases() {
        Stack stack = new Stack(1);

        // Push and Pop on single element
        stack.push(5);
        assertEquals(5, stack.pop());
        assertEquals(true, stack.isEmpty());

        // Operations on empty stack
        assertThrows(EmptyStackException.class, stack::peek);
        assertThrows(EmptyStackException.class, stack::pop);
   
    }
}