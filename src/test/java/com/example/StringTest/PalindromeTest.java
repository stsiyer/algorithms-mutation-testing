package com.example.StringTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.example.String.Palindrome;

public class PalindromeTest {

	@Test
	public void testPalindrome() {
		assertEquals(true, Palindrome.isPalindrome(null));
		assertEquals(true, Palindrome.isPalindrome(""));
		assertEquals(true, Palindrome.isPalindrome("a"));
		assertEquals(true, Palindrome.isPalindrome("aba"));
		assertEquals(true, Palindrome.isPalindrome("aaaa"));
		assertEquals(false, Palindrome.isPalindrome("abc"));
		assertEquals(true, Palindrome.isPalindrome("abcba"));
		assertEquals(false, Palindrome.isPalindrome("!@#$%^&"));
		assertEquals(true, Palindrome.isPalindrome("aabbcbbaa"));
		assertEquals(true, Palindrome.isPalindrome("abba"));
		assertEquals(false, Palindrome.isPalindrome("aaabba"));
		assertEquals(true, Palindrome.isPalindrome("kayak"));
		assertEquals(true, Palindrome.isPalindrome("123321"));
		assertEquals(true, Palindrome.isPalindrome("1234321"));
		assertEquals(false, Palindrome.isPalindrome("abc123"));
		assertEquals(false, Palindrome.isPalindrome("kayaks"));
	}
	
	@Test
	public void testPalindromeRecursive() {
		assertEquals(true, Palindrome.isPalindromeRecursion(null));
		assertEquals(true, Palindrome.isPalindromeRecursion(""));
		assertEquals(true, Palindrome.isPalindromeRecursion("a"));
		assertEquals(true, Palindrome.isPalindromeRecursion("aba"));
		assertEquals(true, Palindrome.isPalindromeRecursion("aaaa"));
		assertEquals(false, Palindrome.isPalindromeRecursion("abc"));
		assertEquals(true, Palindrome.isPalindromeRecursion("abcba"));
		assertEquals(false, Palindrome.isPalindromeRecursion("!@#$%^&"));
		assertEquals(true, Palindrome.isPalindromeRecursion("aabbcbbaa"));
		assertEquals(true, Palindrome.isPalindromeRecursion("abba"));
		assertEquals(false, Palindrome.isPalindromeRecursion("aaabba"));
		assertEquals(true, Palindrome.isPalindromeRecursion("kayak"));
		assertEquals(true, Palindrome.isPalindromeRecursion("123321"));
		assertEquals(true, Palindrome.isPalindromeRecursion("1234321"));
		assertEquals(false, Palindrome.isPalindromeRecursion("abc123"));
		assertEquals(false, Palindrome.isPalindromeRecursion("kayaks"));	
	}
	
	@Test
	public void testPalindromeTwoPointer() {
		assertEquals(true, Palindrome.isPalindromeTwoPointer(null));
		assertEquals(true, Palindrome.isPalindromeTwoPointer(""));
		assertEquals(true, Palindrome.isPalindromeTwoPointer("a"));
		assertEquals(true, Palindrome.isPalindromeTwoPointer("aba"));
		assertEquals(true, Palindrome.isPalindromeTwoPointer("aaaa"));
		assertEquals(false, Palindrome.isPalindromeTwoPointer("abc"));
		assertEquals(true, Palindrome.isPalindromeTwoPointer("aabbcbbaa"));
		assertEquals(true, Palindrome.isPalindromeTwoPointer("abba"));
		assertEquals(false, Palindrome.isPalindromeTwoPointer("aaabba"));
		assertEquals(true, Palindrome.isPalindromeTwoPointer("abcba"));
		assertEquals(false, Palindrome.isPalindromeTwoPointer("!@#$%^&"));
		assertEquals(true, Palindrome.isPalindromeTwoPointer("kayak"));
		assertEquals(true, Palindrome.isPalindromeTwoPointer("123321"));
		assertEquals(true, Palindrome.isPalindromeTwoPointer("1234321"));
		assertEquals(false, Palindrome.isPalindromeTwoPointer("abc123"));
		assertEquals(false, Palindrome.isPalindromeTwoPointer("kayaks"));
	}
}
