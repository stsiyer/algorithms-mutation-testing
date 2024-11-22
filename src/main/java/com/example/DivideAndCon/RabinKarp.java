package com.example.DivideAndCon;

public class RabinKarp {

	public static final int d = 256;

	public int search(String pat, String txt, int q) {
		int index = -1; //note: -1 here represent not found, it is not an index
		int M = pat.length();
		int N = txt.length();
		int i, j;
		int p = 0; // hash value for pattern
		int t = 0; // hash value for txt
		int h = 1;

		for (i = 0; i < M - 1; i++) h = (h * d) % q;

		for (i = 0; i < M; i++) {
			p = (d * p + pat.charAt(i)) % q;
			t = (d * t + txt.charAt(i)) % q;
		}

		for (i = 0; i <= N - M; i++) {
			if (p == t) {
				for (j = 0; j < M; j++) {
					if (txt.charAt(i + j) != pat.charAt(j)) break;
				}

				if (j == M) {
					System.out.println("Pattern found at index " + i);
					index = i;
					return index;
				}
			}

			if (i < N - M) {
				t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + M)) % q;
				if (t < 0) t = (t + q);
			}
		}
		return index;
	}
}