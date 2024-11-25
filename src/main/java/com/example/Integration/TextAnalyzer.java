package com.example.Integration;

import java.util.ArrayList;
import java.util.List;

import com.example.String.KMPSearch;

public class TextAnalyzer {
    private KMPSearch kmpSearch;

    public TextAnalyzer() {
        this.kmpSearch = new KMPSearch();
    }

    // Check if a word exists in the text
    public boolean containsWord(String text, String word) {
        return kmpSearch.kmpSearch(word, text) != -1;
    }

    // Find all occurrences of a word in the text
    public List<Integer> findAllOccurrences(String text, String word) {
        List<Integer> indices = new ArrayList<>();
        int index = 0;

        while (index < text.length()) {
            int result = kmpSearch.kmpSearch(word, text.substring(index));
            if (result == -1) {
                break;
            }
            result += index; // Adjust index relative to the original text
            indices.add(result);
            index = result + 1;
        }
        return indices;
    }

    // Count the frequency of a word in the text
    public int countWordFrequency(String text, String word) {
        return findAllOccurrences(text, word).size();
    }
}
