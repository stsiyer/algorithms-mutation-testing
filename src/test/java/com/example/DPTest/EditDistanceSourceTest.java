package com.example.DPTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.example.DP.EditDistanceSource;


public class EditDistanceSourceTest {

	@Test
	public void testMinDistance() {
		EditDistanceSource eds = new EditDistanceSource(); 
		
		// Test 1
		String word11 = "abcde"; 
		String word12 = "a"; 
		assertEquals(4, eds.minDistance(word11, word12)); 
		
		// Test 2
		String word21 = "a"; 
		String word22 = "a"; 
		assertEquals(0, eds.minDistance(word21, word22)); 
		
		// Test 3
		String word31 = "bb"; 
		String word32 = "abb"; 
		assertEquals(1, eds.minDistance(word31, word32)); 
		
		// Test 4
		String word41 = "abba";
		String word42 = "abccba"; 
		assertEquals(2, eds.minDistance(word41, word42)); 
	}

}
