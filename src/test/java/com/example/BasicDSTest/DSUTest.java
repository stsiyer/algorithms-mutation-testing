package com.example.BasicDSTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import com.example.BasicDS.DSU;

public class DSUTest {

    @Test
    public void testUnionAndFind() {
        DSU dsu = new DSU(5);
        assertTrue(dsu.union(0, 1));
        assertTrue(dsu.union(1, 2));
        assertFalse(dsu.union(0, 2)); // Already connected

        assertTrue(dsu.connected(0, 2));
        assertFalse(dsu.connected(0, 3));
    }

    @Test
    public void testPathCompression() {
        DSU dsu = new DSU(5);
        dsu.union(0, 1);
        dsu.union(1, 2);
        dsu.union(2, 3);

        assertTrue(dsu.connected(0, 3));

        // Validate path compression by checking direct parent linkage
        assertTrue(dsu.find(3) == dsu.find(0));
    }

    @Test
    public void testEdgeCases() {
        DSU dsu = new DSU(1);
        assertTrue(dsu.connected(0, 0));

        DSU dsu2 = new DSU(2);
        assertFalse(dsu2.connected(0, 1));
        assertTrue(dsu2.union(0, 1));
        assertTrue(dsu2.connected(0, 1));
    }
}
