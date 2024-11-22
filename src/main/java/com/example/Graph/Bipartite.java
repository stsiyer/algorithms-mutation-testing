package com.example.Graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an adjacency list of a graph adj of V no. of vertices having 0 based
 * index. Check whether the graph is bipartite or not.
 *
 * Input : {{0, 1, 0, 1}, {1, 0, 1, 0}, {0, 1, 0, 1}, {1, 0, 1, 0}}
 *
 * Output : YES
 */
public class Bipartite {

	public static boolean bipartite(
			int V,
			ArrayList<ArrayList<Integer>> adj,
			int[] color,
			int node
			) {
		if (color[node] == -1) {
			color[node] = 1;
		}
		for (Integer it : adj.get(node)) {
			if (color[it] == -1) {
				color[it] = 1 - color[node];
				if (bipartite(V, adj, color, it) == false) {
					return false;
				}
			} else if (color[it] == color[node]) {
				return false;
			}
		}
		return true;
	}

	public static boolean isBipartite(
			int V,
			ArrayList<ArrayList<Integer>> adj
			) {
		int[] color = new int[V + 1];
		Arrays.fill(color, -1);

		for (int i = 0; i < V; i++) {
			if (color[i] == -1) {
				if (!bipartite(V, adj, color, i)) {
					return false;
				}
			}
		}
		return true;
	}	
}