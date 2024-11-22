package com.example.DP;
// Code taken from https://github.com/TheAlgorithms/Java/blob/master/src/main/java/com/thealgorithms/dynamicprogramming/LongestPalindromicSubstring.java

/*
 * Algorithm explanation https://leetcode.com/problems/longest-palindromic-substring/
 */
public class LongestPalindromicSubstringSource {
	
    public static String LPS(String input) {
        if (input == null || input.length() == 0) {
            return input;
        }
        boolean arr[][] = new boolean[input.length()][input.length()];
        int start = 0, end = 0;
        for (int g = 0; g < input.length(); g++) {
            for (int i = 0, j = g; j < input.length(); i++, j++) {
                if (g == 0) {
                    arr[i][j] = true;
                } else if (g == 1) {
                    if (input.charAt(i) == input.charAt(j)) {
                        arr[i][j] = true;
                    } else {
                        arr[i][j] = false;
                    }
                } else {
                    if (
                        input.charAt(i) == input.charAt(j) && arr[i + 1][j - 1]
                    ) {
                        arr[i][j] = true;
                    } else {
                        arr[i][j] = false;
                    }
                }

                if (arr[i][j]) {
                    start = i;
                    end = j;
                }
            }
        }
        return input.substring(start, end + 1);
    }
}
