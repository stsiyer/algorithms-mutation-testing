package com.example.BasicDSTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.NoSuchElementException;

import org.junit.Test;

import com.example.BasicDS.Queue;

public class QueueTest {

    @Test
    public void testEnqueueAndToString() {
        Queue queue = new Queue(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        assertEquals("10 20 30", queue.toString());
    }

    @Test
    public void testDequeue() {
        Queue queue = new Queue(3);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        assertEquals(10, queue.dequeue());
        assertEquals(20, queue.dequeue());
        assertEquals(30, queue.dequeue());

        assertThrows(NoSuchElementException.class, queue::dequeue);
    }

    @Test
    public void testPeek() {
        Queue queue = new Queue(3);
        queue.enqueue(10);
        queue.enqueue(20);

        assertEquals(10, queue.peek());
        queue.dequeue();
        assertEquals(20, queue.peek());

        queue.dequeue();
        assertThrows(NoSuchElementException.class, queue::peek);
    }

    @Test
    public void testIsEmpty() {
        Queue queue = new Queue(3);
        assertEquals(true, queue.isEmpty());

        queue.enqueue(10);
        assertEquals(false, queue.isEmpty());

        queue.dequeue();
        assertEquals(true, queue.isEmpty());
    }

    @Test
    public void testIsFull() {
        Queue queue = new Queue(2);
        assertEquals(false, queue.isFull());

        queue.enqueue(10);
        assertEquals(false, queue.isFull());

        queue.enqueue(20);
        assertEquals(true, queue.isFull());

        queue.dequeue();
        assertEquals(false, queue.isFull());
    }

    @Test
    public void testSize() {
        Queue queue = new Queue(5);
        assertEquals(0, queue.size());

        queue.enqueue(10);
        queue.enqueue(20);
        assertEquals(2, queue.size());

        queue.dequeue();
        assertEquals(1, queue.size());
    }

    @Test
    public void testQueueOverflow() {
        Queue queue = new Queue(2);
        queue.enqueue(10);
        queue.enqueue(20);

        assertThrows(IllegalStateException.class, () -> queue.enqueue(30));
    }

    @Test
    public void testEdgeCases() {
        Queue queue = new Queue(1);

        // Enqueue and Dequeue on single element
        queue.enqueue(5);
        assertEquals(5, queue.dequeue());
        assertEquals(true, queue.isEmpty());

        // Operations on empty queue
        assertThrows(NoSuchElementException.class, queue::peek);
        assertThrows(NoSuchElementException.class, queue::dequeue);
    }

    @Test
    public void testCircularBehavior() {
        Queue queue = new Queue(3);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        queue.dequeue(); // Remove 10
        queue.enqueue(40); // Should wrap around and insert at the start

        assertEquals("20 30 40", queue.toString());
    }
}
