package com.example.IntegrationTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.example.Integration.GraphConnectedComponents;

public class GraphConnectedComponentsIntegrationTest {

    // Basic functionality test
    @Test
    public void testSingleComponentGraph() {
        GraphConnectedComponents graph = new GraphConnectedComponents(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        assertEquals(1, graph.countConnectedComponents());
        assertTrue(graph.areNodesConnected(0, 4));
    }

    // Edge case test
    @Test
    public void testDisconnectedGraph() {
        GraphConnectedComponents graph = new GraphConnectedComponents(5);

        assertEquals(5, graph.countConnectedComponents());
        assertFalse(graph.areNodesConnected(0, 1));
    }

    // Boundary test
    @Test
    public void testSingleNodeGraph() {
        GraphConnectedComponents graph = new GraphConnectedComponents(1);

        assertEquals(1, graph.countConnectedComponents());
    }

    // Mixed scenario test
    @Test
    public void testMultipleComponentsGraph() {
        GraphConnectedComponents graph = new GraphConnectedComponents(6);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);

        assertEquals(3, graph.countConnectedComponents());
        assertTrue(graph.areNodesConnected(0, 2));
        assertTrue(graph.areNodesConnected(3, 4));
        assertFalse(graph.areNodesConnected(2, 3));
    }

    // Error scenario test
    @Test
    public void testInvalidEdge() {
        GraphConnectedComponents graph = new GraphConnectedComponents(5);

        assertThrows(IndexOutOfBoundsException.class, () -> graph.addEdge(-1, 5));
    }

    // Stress test
    @Test
    public void testLargeGraph() {
        int size = 1000;
        GraphConnectedComponents graph = new GraphConnectedComponents(size);

        for (int i = 0; i < size - 1; i++) {
            graph.addEdge(i, i + 1);
        }

        assertEquals(1, graph.countConnectedComponents());
    }
}
