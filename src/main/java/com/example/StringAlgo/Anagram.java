package com.example.StringAlgo;

import java.util.Arrays;
import java.util.HashMap;

/**
 * An anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.[1]
 * For example, the word anagram itself can be rearranged into nag a ram,
 * also the word binary into brainy and the word adobe into abode.
 * Reference from https://en.wikipedia.org/wiki/Anagram
 */
public class Anagram {
	public boolean approach1(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		} else {
			char c[] = s.toCharArray();
			char d[] = t.toCharArray();
			Arrays.sort(c);
			Arrays.sort(d);
			if (Arrays.equals(c, d)) {
				return true;
			} else {
				return false;
			}
		}
	}

	public boolean approach2(String a, String b) {
		if (a.length() != b.length()) {
			return false;
		} else {
			int m[] = new int[26];
			int n[] = new int[26];
			for (char c : a.toCharArray()) {
				m[c - 'a']++;
			}
			for (char c : b.toCharArray()) {
				n[c - 'a']++;
			}
			for (int i = 0; i < 26; i++) {
				if (m[i] != n[i]) {
					return false;
				}
			}
			return true;
		}
	}

	public boolean approach3(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		else {
			int a[] = new int[26];
			int b[] = new int[26];
			int k = s.length();
			for (int i = 0; i < k; i++) {
				a[s.charAt(i) - 'a']++;
				b[t.charAt(i) - 'a']++;
			}
			for (int i = 0; i < 26; i++) {
				if (a[i] != b[i]) return false;
			}
			return true;
		}
	}

	public boolean approach4(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		else {
			HashMap<Character, Integer> nm = new HashMap<>();
			HashMap<Character, Integer> kk = new HashMap<>();
			for (char c : s.toCharArray()) {
				nm.put(c, nm.getOrDefault(c, 0) + 1);
			}
			for (char c : t.toCharArray()) {
				kk.put(c, kk.getOrDefault(c, 0) + 1);
			}
			return nm.equals(kk);
		}
	}
}