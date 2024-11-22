package com.example.BasicDSTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;

import org.junit.Test;

import com.example.BasicDS.MinHeap;

public class MinHeapTest {

    @Test
    public void testInsertAndToString() {
        MinHeap heap = new MinHeap(5);
        heap.insert(10);
        heap.insert(20);
        heap.insert(5);
        heap.insert(15);
        heap.insert(2);

        // Check if the root is the smallest element
        assertEquals(2, heap.peek());

        // Check overall structure indirectly
        String heapString = heap.toString();
        String[] elements = heapString.split(" ");
        int[] heapElements = new int[elements.length];
        for (int i = 0; i < elements.length; i++) {
            heapElements[i] = Integer.parseInt(elements[i]);
        }

        // Validate heap property
        for (int i = 1; i < heapElements.length; i++) {
            int parentIndex = (i - 1) / 2;
            assertTrue(heapElements[parentIndex] <= heapElements[i]);
        }
    }

    @Test
    public void testExtractMin() {
        MinHeap heap = new MinHeap(5);
        heap.insert(10);
        heap.insert(20);
        heap.insert(5);
        heap.insert(15);
        heap.insert(2);

        assertEquals(2, heap.extractMin());
        assertEquals(5, heap.extractMin());
        assertEquals(10, heap.extractMin());
        assertEquals("15 20", heap.toString());

        assertEquals(15, heap.extractMin());
        assertEquals(20, heap.extractMin());

        assertThrows(NoSuchElementException.class, heap::extractMin);
    }

    @Test
    public void testPeek() {
        MinHeap heap = new MinHeap(3);
        heap.insert(15);
        heap.insert(10);
        heap.insert(20);

        assertEquals(10, heap.peek());
        heap.extractMin();
        assertEquals(15, heap.peek());

        heap.extractMin();
        heap.extractMin();
        assertThrows(NoSuchElementException.class, heap::peek);
    }

    @Test
    public void testIsEmpty() {
        MinHeap heap = new MinHeap(3);
        assertEquals(true, heap.isEmpty());

        heap.insert(10);
        assertEquals(false, heap.isEmpty());

        heap.extractMin();
        assertEquals(true, heap.isEmpty());
    }

    @Test
    public void testSize() {
        MinHeap heap = new MinHeap(5);
        assertEquals(0, heap.size());

        heap.insert(10);
        heap.insert(20);
        assertEquals(2, heap.size());

        heap.extractMin();
        assertEquals(1, heap.size());
    }

    @Test
    public void testHeapOverflow() {
        MinHeap heap = new MinHeap(2);
        heap.insert(10);
        heap.insert(20);

        assertThrows(IllegalStateException.class, () -> heap.insert(30));
    }

    @Test
    public void testEdgeCases() {
        MinHeap heap = new MinHeap(1);

        // Insert and extract for single element
        heap.insert(5);
        assertEquals(5, heap.extractMin());
        assertEquals(true, heap.isEmpty());

        // Operations on empty heap
        assertThrows(NoSuchElementException.class, heap::peek);
        assertThrows(NoSuchElementException.class, heap::extractMin);
    }

    @Test
    public void testHeapifyUpAndDown() {
        MinHeap heap = new MinHeap(5);

        // Heapify up
        heap.insert(20);
        heap.insert(15);
        heap.insert(10);
        heap.insert(5);
        assertEquals("5 10 15 20", heap.toString());

        // Heapify down
        heap.extractMin();
        assertEquals("10 20 15", heap.toString());
    }
}
