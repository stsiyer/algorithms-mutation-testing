package com.example.DPTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.example.DP.KnapsackSource;


public class KnapsackSourceTest {

	@Test
	public void testKnapsack() {
		KnapsackSource kss = new KnapsackSource(); 
		
		// Test 1
		int W1 = 100; 
		int wt1 [] = {1,1,101}; 
		int val1 [] = {10,20,31}; 
		int n1 = wt1.length; 
		assertEquals(30, kss.knapSack(W1, wt1, val1, n1));
		
		// Test 2
		int W2 = 10; 
		int wt2 [] = {11,12}; 
		int val2 [] = {11,22}; 
		int n2 = wt2.length; 
		assertEquals(0, kss.knapSack(W2, wt2, val2, n2));
				
		// Test 3
		int W3 = 15; 
		int wt3 [] = {15, 100}; 
		int val3 [] = {1,100}; 
		int n3 = wt3.length; 
		assertEquals(1, kss.knapSack(W3, wt3, val3, n3));
						
		// Test 4
		int W4 = 25; 
		int wt4 [] = {5,5,5,5,5,5}; 
		int val4 [] = {1,4,3,7,2,8}; 
		int n4 = wt4.length; 
		assertEquals(24, kss.knapSack(W4, wt4, val4, n4));
						
					
	}

}
