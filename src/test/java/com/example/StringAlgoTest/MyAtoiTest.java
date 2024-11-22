package com.example.StringAlgoTest;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.example.StringAlgo.MyAtoi;

public class MyAtoiTest {

	@Test
	public void testMyAtoi() {
		MyAtoi atoi = new MyAtoi();
		
		assertEquals(1234, atoi.myAtoi("1234"));
		assertEquals(10000, atoi.myAtoi("10000"));
		assertEquals(0, atoi.myAtoi("0"));
		assertEquals(0, atoi.myAtoi("00000"));
		assertEquals(-100, atoi.myAtoi("-100"));
		assertEquals(-199, atoi.myAtoi("-199"));
		assertEquals(-199, atoi.myAtoi("-199.25"));
		assertEquals(-2147483648, atoi.myAtoi("-199999999999999999"));
		assertEquals(2147483647, atoi.myAtoi("9199999999999999999"));
		assertEquals(876, atoi.myAtoi("+876"));
		assertEquals(0, atoi.myAtoi("*&^%$#@!()"));
		assertEquals(-452, atoi.myAtoi("-452"));
		assertEquals(101, atoi.myAtoi("+101"));
		assertEquals(-999, atoi.myAtoi("-999.99"));
		assertEquals(0, atoi.myAtoi("."));
		assertEquals(2147483647, atoi.myAtoi("9999999999"));
		assertEquals(-2147483648, atoi.myAtoi("-9999999999"));	
		assertEquals(-1111111111, atoi.myAtoi("-1111111111"));
		assertEquals(1111111111, atoi.myAtoi("1111111111"));
		assertEquals(0, atoi.myAtoi("-0000"));
		assertEquals(0, atoi.myAtoi("+0000000000"));
		assertEquals(2147483647, atoi.myAtoi("9876543210"));
		assertEquals(123456789, atoi.myAtoi("0123456789"));
		assertEquals(4193, atoi.myAtoi("4193 with words"));
		assertEquals(-42, atoi.myAtoi("   -42"));		
	}
}
