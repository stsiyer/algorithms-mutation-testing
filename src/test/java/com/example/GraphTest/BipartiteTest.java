package com.example.GraphTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import com.example.Graph.Bipartite;

public class BipartiteTest {

	@Test
	public void test() {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> a0 = new ArrayList<Integer>();
		a0.add(1);
		a0.add(2);
		a0.add(3);
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		a1.add(4);
		a1.add(3);
		ArrayList<Integer> a2 = new ArrayList<Integer>();
		a2.add(0);
		a2.add(1);
		ArrayList<Integer> a3 = new ArrayList<Integer>();
		a3.add(1);
		a3.add(2);
		a3.add(3);
		ArrayList<Integer> a4 = new ArrayList<Integer>();
		a4.add(1);
		a4.add(2);
			
		adj.add(a0);
		adj.add(a1);
		adj.add(a2);
		adj.add(a3);
		adj.add(a4);
		
		ArrayList<ArrayList<Integer>> adj2 = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> b0 = new ArrayList<Integer>();
		b0.add(1);
		b0.add(2);
		b0.add(3);
		ArrayList<Integer> b1 = new ArrayList<Integer>();
		b1.add(0);
		b1.add(2);
		ArrayList<Integer> b2 = new ArrayList<Integer>();
		b2.add(0);
		b2.add(1);
		b2.add(3);
		ArrayList<Integer> b3 = new ArrayList<Integer>();
		b3.add(0);
		b3.add(2);
		
		adj2.add(b0);
		adj2.add(b1);
		adj2.add(b2);
		adj2.add(b3);
		
		assertFalse(Bipartite.isBipartite(4, adj2));
		
		ArrayList<ArrayList<Integer>> adj3 = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> c0 = new ArrayList<Integer>();
		c0.add(1);
		c0.add(3);
		ArrayList<Integer> c1 = new ArrayList<Integer>();
		c1.add(0);
		c1.add(2);
		ArrayList<Integer> c2 = new ArrayList<Integer>();
		c2.add(1);
		c2.add(3);
		ArrayList<Integer> c3 = new ArrayList<Integer>();
		c3.add(0);
		c3.add(2);
		
		adj3.add(c0);
		adj3.add(c1);
		adj3.add(c2);
		adj3.add(c3);
		
		assertTrue(Bipartite.isBipartite(4, adj3));
	}
}
