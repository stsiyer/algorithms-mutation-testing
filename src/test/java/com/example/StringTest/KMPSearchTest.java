package com.example.StringTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.example.String.KMPSearch;

public class KMPSearchTest {
    @Test
    public void testKMPSearch() {
    	KMPSearch kmp = new KMPSearch();        
        
        assertEquals(kmp.kmpSearch("ABABCABAB", "ABABDABACDABABCABAB"), 10);
        assertEquals(kmp.kmpSearch("AAAA", "AAAAABAAABA"), 0);
        assertEquals(kmp.kmpSearch("AAAA", "AAACAAAAAC"), 4);
        assertEquals(kmp.kmpSearch("AAAA", "AAABAAAA"), 4);
        assertEquals(kmp.kmpSearch("AAAA", "AABAAA"), -1);
    }
}