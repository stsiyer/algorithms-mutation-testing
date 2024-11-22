package com.example.DivideAndConTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.example.DivideAndCon.RabinKarp;

public class RabinKarpTest {
    @Test
    public void testRabinKarp() {
    	RabinKarp rka = new RabinKarp();
        int q = 101;
        assertEquals(rka.search("algorithmn", "This is an example for rabin karp algorithmn", q), 34);
        assertEquals(rka.search("AAA", "AAABBDDG", q), 0);
        assertEquals(rka.search("BBCC", "AAABBCCBB", q), 3);
        assertEquals(rka.search("CCC", "AAAABBBBCCC", q), 8);
        assertEquals(rka.search("AADB", "ABCBCBCAAB", q), -1);
    }
}