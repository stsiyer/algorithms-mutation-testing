package com.example.BasicDS;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    private final int capacity;
    private final Map<Integer, Integer> cache;

    // Constructor to initialize the cache with the given capacity
    public LRUCache(int capacity) {
        this.capacity = capacity;
        // LinkedHashMap with accessOrder=true to maintain access order
        this.cache = new LinkedHashMap<>(capacity, 0.75f, true);
    }

    // Get the value from the cache
    public int get(int key) {
        return cache.getOrDefault(key, -1); // Returns -1 if key is not found
    }

    // Put a value in the cache
    public void put(int key, int value) {
        if (cache.size() >= capacity) {
            // Remove the least recently used (first entry in LinkedHashMap)
            Map.Entry<Integer, Integer> eldest = cache.entrySet().iterator().next();
            cache.remove(eldest.getKey());
        }
        cache.put(key, value);
    }

    // Check if the cache is full
    public boolean isFull() {
        return cache.size() == capacity;
    }

    // Get the cache size
    public int size() {
        return cache.size();
    }

    // Convert the cache to a string representation
    public String toString() {
        return cache.toString();
    }
}
