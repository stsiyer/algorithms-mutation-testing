package com.example.StringAlgoTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.example.StringAlgo.Anagram;

public class AnagramTest {
	Anagram nm = new Anagram();
	
	@Test	
	public void testAnagram1() {
		assertEquals(true, nm.approach1("lead", "deal"));
		assertEquals(true, nm.approach1("abdce", "edcba"));
		assertEquals(false, nm.approach1("aaaaa", "aaa"));
		assertEquals(false, nm.approach1("anmlo", "!@#$%"));
		assertEquals(true, nm.approach1("wowow", "wwwoo"));
	}
	
	@Test	
	public void testAnagram2() {
		assertEquals(true, nm.approach2("lead", "deal"));
		assertEquals(true, nm.approach2("abdce", "edcba"));
		assertEquals(false, nm.approach2("aaaaa", "aaa"));
		assertEquals(false, nm.approach2("anmlo", "lllll"));
		assertEquals(true, nm.approach2("wowow", "wwwoo"));
	}
	
	@Test	
	public void testAnagram3() {
		assertEquals(true, nm.approach3("lead", "deal"));
		assertEquals(true, nm.approach3("abdce", "edcba"));
		assertEquals(false, nm.approach3("aaaaa", "aaa"));
		assertEquals(false, nm.approach3("anmlo", "ppppp"));
		assertEquals(true, nm.approach3("wowow", "wwwoo"));
	}
	
	@Test	
	public void testAnagram4() {
		assertEquals(true, nm.approach4("lead", "deal"));
		assertEquals(true, nm.approach4("abdce", "edcba"));
		assertEquals(false, nm.approach4("aaaaa", "aaa"));
		assertEquals(false, nm.approach4("anmlo", "hhhhh"));
		assertEquals(true, nm.approach4("wowow", "wwwoo"));
	}
}
