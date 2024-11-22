package com.example.BasicDSTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.example.BasicDS.Trie;

public class TrieTest {

    @Test
    public void testInsertAndSearch() {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("app");

        assertTrue(trie.search("apple"));
        assertTrue(trie.search("app"));
        assertFalse(trie.search("ap"));
    }

    @Test
    public void testStartsWith() {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("app");

        assertTrue(trie.startsWith("app"));
        assertTrue(trie.startsWith("ap"));
        assertFalse(trie.startsWith("apl"));
    }

    @Test
    public void testDelete() {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("app");

        trie.delete("app");
        assertFalse(trie.search("app"));
        assertTrue(trie.search("apple"));

        trie.delete("apple");
        assertFalse(trie.search("apple"));
        assertFalse(trie.startsWith("app"));
    }
}
