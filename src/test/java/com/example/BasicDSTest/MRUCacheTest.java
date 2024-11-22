package com.example.BasicDSTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.example.BasicDS.MRUCache;

public class MRUCacheTest {

    @Test
    public void testPutAndGet() {
        MRUCache cache = new MRUCache(3);
        cache.put(1, 10);
        cache.put(2, 20);
        cache.put(3, 30);
        assertEquals(10, cache.get(1));  // Should return 10
        assertEquals(20, cache.get(2));  // Should return 20
        assertEquals(30, cache.get(3));  // Should return 30
    }

    @Test
    public void testEviction() {
        MRUCache cache = new MRUCache(3);
        cache.put(1, 10);
        cache.put(2, 20);
        cache.put(3, 30);
        // The cache should have (1, 10), (2, 20), and (3, 30)
        cache.put(4, 40);  // This will evict the most recently used element, which is 3
        assertEquals(30, cache.get(3));  // Should return -1, as 3 is evicted
        assertEquals(40, cache.get(4));  // Should return 40
    }

    @Test
    public void testCacheSize() {
        MRUCache cache = new MRUCache(2);
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
        MRUCache cache = new MRUCache(2);
        cache.put(1, 10);
        cache.put(2, 20);
        cache.put(3, 30);  // Evicts key 2, since key 1 is the most recently used
    }

    @Test
    public void testEmptyCache() {
        MRUCache cache = new MRUCache(2);
        assertEquals(-1, cache.get(1));  // Cache is empty, returns -1
    }

    @Test
    public void testToString() {
        MRUCache cache = new MRUCache(3);
        cache.put(1, 10);
        cache.put(2, 20);
        cache.put(3, 30);
        assertEquals("{1=10, 2=20, 3=30}", cache.toString()); // To string should reflect current cache state
    }
}
