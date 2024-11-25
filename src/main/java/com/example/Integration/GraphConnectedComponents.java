package com.example.Integration;

import com.example.BasicDS.DSU;

public class GraphConnectedComponents {
    private final int numNodes;
    private final DSU dsu;

    public GraphConnectedComponents(int numNodes) {
        this.numNodes = numNodes;
        this.dsu = new DSU(numNodes);
    }

    public void addEdge(int node1, int node2) {
        dsu.union(node1, node2);
    }

    public int countConnectedComponents() {
        int[] uniqueRoots = new int[numNodes];
        int count = 0;

        for (int i = 0; i < numNodes; i++) {
            int root = dsu.find(i);
            if (uniqueRoots[root] == 0) {
                count++;
                uniqueRoots[root] = 1;
            }
        }
        return count;
    }

    public boolean areNodesConnected(int node1, int node2) {
        return dsu.connected(node1, node2);
    }
}
