package com.example.IntegrationTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.example.Integration.TextAnalyzer;

public class TextAnalyzerIntegrationTest {

    /**
     * Basic Functional Test: Verifies that a word exists in the given text.
     */
    @Test
    public void testContainsWordTrue() {
        TextAnalyzer analyzer = new TextAnalyzer();
        assertTrue(analyzer.containsWord("hello world", "world"));
    }

    /**
     * Basic Functional Test: Verifies that a word does not exist in the given text.
     */
    @Test
    public void testContainsWordFalse() {
        TextAnalyzer analyzer = new TextAnalyzer();
        assertFalse(analyzer.containsWord("hello world", "planet"));
    }

    /**
     * Basic Functional Test: Finds a single occurrence of a word in the text.
     */
    @Test
    public void testFindAllOccurrencesSingle() {
        TextAnalyzer analyzer = new TextAnalyzer();
        List<Integer> indices = analyzer.findAllOccurrences("hello world", "world");
        assertEquals(1, indices.size());
        assertEquals(6, (int) indices.get(0));
    }

    /**
     * Basic Functional Test: Finds multiple occurrences of a word in the text.
     */
    @Test
    public void testFindAllOccurrencesMultiple() {
        TextAnalyzer analyzer = new TextAnalyzer();
        List<Integer> indices = analyzer.findAllOccurrences("hello hello hello", "hello");
        assertEquals(3, indices.size());
        assertEquals(0, (int) indices.get(0));
        assertEquals(6, (int) indices.get(1));
        assertEquals(12, (int) indices.get(2));
    }

    /**
     * Basic Functional Test: Verifies no occurrences of a word in the text.
     */
    @Test
    public void testFindAllOccurrencesNone() {
        TextAnalyzer analyzer = new TextAnalyzer();
        List<Integer> indices = analyzer.findAllOccurrences("hello world", "planet");
        assertTrue(indices.isEmpty());
    }

    /**
     * Basic Functional Test: Counts a single occurrence of a word in the text.
     */
    @Test
    public void testCountWordFrequencySingle() {
        TextAnalyzer analyzer = new TextAnalyzer();
        assertEquals(1, analyzer.countWordFrequency("hello world", "world"));
    }

    /**
     * Basic Functional Test: Counts multiple occurrences of a word in the text.
     */
    @Test
    public void testCountWordFrequencyMultiple() {
        TextAnalyzer analyzer = new TextAnalyzer();
        assertEquals(3, analyzer.countWordFrequency("hello hello hello", "hello"));
    }

    /**
     * Basic Functional Test: Verifies zero occurrences of a word in the text.
     */
    @Test
    public void testCountWordFrequencyNone() {
        TextAnalyzer analyzer = new TextAnalyzer();
        assertEquals(0, analyzer.countWordFrequency("hello world", "planet"));
    }

    /**
     * Boundary Test: Verifies behavior when the pattern is empty.
     */
    @Test
    public void testEmptyPattern() {
        TextAnalyzer analyzer = new TextAnalyzer();
        assertTrue(analyzer.containsWord("hello world", ""));
        assertEquals(11, analyzer.countWordFrequency("hello world", ""));
    }

    /**
     * Boundary Test: Verifies behavior when the text is empty.
     */
    @Test
    public void testEmptyText() {
        TextAnalyzer analyzer = new TextAnalyzer();
        assertFalse(analyzer.containsWord("", "word"));
        assertEquals(0, analyzer.countWordFrequency("", "word"));
    }

    /**
     * Edge Test: Verifies behavior with single-character text and pattern.
     */
    @Test
    public void testEdgeCases() {
        TextAnalyzer analyzer = new TextAnalyzer();

        // Single-character match
        assertTrue(analyzer.containsWord("a", "a"));
        assertEquals(1, analyzer.countWordFrequency("a", "a"));

        // Single-character mismatch
        assertFalse(analyzer.containsWord("a", "b"));
        assertEquals(0, analyzer.countWordFrequency("a", "b"));

        // Pattern larger than text
        assertFalse(analyzer.containsWord("abc", "abcd"));
        assertEquals(0, analyzer.countWordFrequency("abc", "abcd"));
    }
}

