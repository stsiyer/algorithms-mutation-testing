package com.example.DPTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.example.DP.FibonacciSource;


public class FibonacciSourceTest {

	@Test
	public void testFibMemo() {
		FibonacciSource fs = new FibonacciSource(); 
		
		// Test 1
		assertEquals(0, fs.fibMemo(0));
		
		// Test 2
		assertEquals(1, fs.fibMemo(1)); 
		
		// Test 3
		assertEquals(1, fs.fibMemo(2));
		
		// Test 4
		assertEquals(144, fs.fibMemo(12)); 
		
		// Test 5
		assertEquals(610, fs.fibMemo(15)); 
	}
	
	@Test
	public void testFibBotUp() {
		FibonacciSource fs = new FibonacciSource();
		
		// Test 1
		assertEquals(2, fs.fibBotUp(3));
		
		// Test 2
		assertEquals(1, fs.fibBotUp(2)); 
		
		// Test 3
		assertEquals(102334155, fs.fibBotUp(40)); 
	}
	
	@Test
	public void testFibOptimized() {
		FibonacciSource fs = new FibonacciSource();
		
		// Test 1
		assertEquals(832040, fs.fibOptimized(30));
		
		// Test 2
		assertEquals(1, fs.fibOptimized(2)); 
	}
	
	@Test
	public void testFibBinet() {
		FibonacciSource fs = new FibonacciSource();
		
		// Test 1
		assertEquals(3, fs.fibBinet(4));
		
		// Test 2
		assertEquals(10946, fs.fibBinet(21)); 
	}
	
}
