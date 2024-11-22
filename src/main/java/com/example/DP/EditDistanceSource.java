package com.example.DP;
// Code taken from: https://github.com/TheAlgorithms/Java/blob/master/src/main/java/com/thealgorithms/dynamicprogramming/EditDistance.java
	
/**
 * @author SUBHAM SANGHAI
 */

public class EditDistanceSource {

    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        // len1+1, len2+1, because finally return dp[len1][len2]
        int[][] dp = new int[len1 + 1][len2 + 1];
        /* If second string is empty, the only option is to
    insert all characters of first string into second*/
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        /* If first string is empty, the only option is to
    insert all characters of second string into first*/
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }
        // iterate though, and check last char
        for (int i = 0; i < len1; i++) {
            char c1 = word1.charAt(i);
            for (int j = 0; j < len2; j++) {
                char c2 = word2.charAt(j);
                // if last two chars equal
                if (c1 == c2) {
                    // update dp value for +1 length
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    /* if two characters are different ,
          then take the minimum of the various operations(i.e insertion,removal,substitution)*/
                    int replace = dp[i][j] + 1;
                    int insert = dp[i][j + 1] + 1;
                    int delete = dp[i + 1][j] + 1;

                    int min = replace > insert ? insert : replace;
                    min = delete > min ? min : delete;
                    dp[i + 1][j + 1] = min;
                }
            }
        }
        /* return the final answer , after traversing through both the strings*/
        return dp[len1][len2];
    }
}
