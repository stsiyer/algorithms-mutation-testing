package com.example.String;

public class KMPSearch {
    public int kmpSearch(String pat, String txt) {
        if (pat == null || pat.isEmpty()) {
            // Return 0 for empty pattern (every string contains an empty pattern at the start).
            return 0;
        }

        int M = pat.length();
        int N = txt.length();
        int lps[] = new int[M];
        int j = 0; // index for pat[]
        computeLPSArray(pat, M, lps);

        int i = 0; // index for txt[]
        while ((N - i) >= (M - j)) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }
            if (j == M) {
                System.out.println("Found pattern " + "at index " + (i - j));
                int index = (i - j);
                j = lps[j - 1];
                return index;
            } else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0) j = lps[j - 1];
                else i = i + 1;
            }
        }
        System.out.println("No pattern found");
        return -1;
    }

    void computeLPSArray(String pat, int M, int lps[]) {
        int len = 0;
        int i = 1;
        lps[0] = 0;

        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }
}
