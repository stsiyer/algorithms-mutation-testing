package com.example.BasicDSTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.example.BasicDS.LRUCache;

public class LRUCacheTest {

    @Test
    public void testPutAndGet() {
        LRUCache cache = new LRUCache(3);
        cache.put(1, 10);
        cache.put(2, 20);
        cache.put(3, 30);
        assertEquals(10, cache.get(1));  // Should return 10
        assertEquals(20, cache.get(2));  // Should return 20
        assertEquals(30, cache.get(3));  // Should return 30
    }

    @Test
    public void testEviction() {
        LRUCache cache = new LRUCache(3);
        cache.put(1, 10);
        cache.put(2, 20);
        cache.put(3, 30);
        // The cache should have (1, 10), (2, 20), and (3, 30)
        cache.put(4, 40);  // This will evict the least recently used element, which is 1
        assertEquals(-1, cache.get(1));  // Should return -1, as 1 is evicted
        assertEquals(40, cache.get(4));  // Should return 40
    }

    @Test
    public void testCacheSize() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 10);
        cache.put(2, 20);
        assertEquals(2, cache.size());
        cache.put(3, 30); // This will evict key 1, as 2 is most recently used
        assertEquals(2, cache.size()); // Cache size remains 2
        assertEquals(-1, cache.get(1)); // Key 1 is evicted
        assertEquals(30, cache.get(3)); // Key 3 is present
    }

    @Test
    public void testFullCache() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 10);
        cache.put(2, 20);
        assertTrue(cache.isFull());  // Cache is full
        cache.put(3, 30);  // Evicts key 1, since key 2 is the most recently used
        assertEquals(-1, cache.get(1));  // Key 1 is evicted
    }

    @Test
    public void testEmptyCache() {
        LRUCache cache = new LRUCache(2);
        assertEquals(-1, cache.get(1));  // Cache is empty, returns -1
    }

    @Test
    public void testToString() {
        LRUCache cache = new LRUCache(3);
        cache.put(1, 10);
        cache.put(2, 20);
        cache.put(3, 30);
        assertEquals("{1=10, 2=20, 3=30}", cache.toString()); // To string should reflect current cache state
    }

    @Test
    public void testAccessOrder() {
        LRUCache cache = new LRUCache(3);
        cache.put(1, 10);
        cache.put(2, 20);
        cache.put(3, 30);
        // Access the key 1 to make it the most recently used
        cache.get(1);
        cache.put(4, 40);  // This will evict key 2 since key 1 is most recently used
        assertEquals(-1, cache.get(2));  // Should return -1, as 2 is evicted
        assertEquals(40, cache.get(4));  // Should return 40
    }
}
