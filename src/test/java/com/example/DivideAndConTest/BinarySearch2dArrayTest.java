package com.example.DivideAndConTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.example.DivideAndCon.BinarySearch2dArray;

public class BinarySearch2dArrayTest {

    @Test
    public void BinarySearch2dArrayTestMiddle() {
        int[][] arr = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};

        int[] ans1 = BinarySearch2dArray.BinarySearch(arr, 1);
        assertEquals(0, ans1[0]);
        assertEquals(0, ans1[1]);
        
        int[] ans2 = BinarySearch2dArray.BinarySearch(arr, 8);
        assertEquals(1, ans2[0]);
        assertEquals(2, ans2[1]);
//        
        int[] ans3 = BinarySearch2dArray.BinarySearch(arr, 2);
        assertEquals(0, ans3[0]);
        assertEquals(1, ans3[1]);
//        
        int[] ans4 = BinarySearch2dArray.BinarySearch(arr, 6);
        assertEquals(1, ans4[0]);
        assertEquals(0, ans4[1]);
        
        int[] ans5 = BinarySearch2dArray.BinarySearch(arr, 25);
        assertEquals(4, ans5[0]);
        assertEquals(4, ans5[1]);
////        
        int[] ans6 = BinarySearch2dArray.BinarySearch(arr, 10);
        assertEquals(1, ans6[0]);
        assertEquals(4, ans6[1]);
//        
        int[] ans7 = BinarySearch2dArray.BinarySearch(arr, 500);
        assertEquals(-1, ans7[0]);
        assertEquals(-1, ans7[1]);
        
        int[] ans8 = BinarySearch2dArray.BinarySearch(arr, -1);
        assertEquals(-1, ans8[0]);
        assertEquals(-1, ans8[1]);
//        
        int[] ans9 = BinarySearch2dArray.BinarySearch(arr, 26);
        assertEquals(-1, ans9[0]);
        assertEquals(-1, ans9[1]);
//        
        int[] ans10 = BinarySearch2dArray.BinarySearch(arr, 20);
        assertEquals(3, ans10[0]);
        assertEquals(4, ans10[1]);
//        
        int[] ans11 = BinarySearch2dArray.BinarySearch(arr, -1000);
        assertEquals(-1, ans11[0]);
        assertEquals(-1, ans11[1]);
//        
        int[] ans12 = BinarySearch2dArray.BinarySearch(arr, 15);
        assertEquals(2, ans12[0]);
        assertEquals(4, ans12[1]);
//        
        int[] ans13 = BinarySearch2dArray.BinarySearch(arr, 13);
        assertEquals(2, ans13[0]);
        assertEquals(2, ans13[1]);
//        
        int[] ans14 = BinarySearch2dArray.BinarySearch(arr, 11);
        assertEquals(2, ans14[0]);
        assertEquals(0, ans14[1]);
//        
        int[] ans15 = BinarySearch2dArray.BinarySearch(arr, 5);
        assertEquals(0, ans15[0]);
        assertEquals(4, ans15[1]);
        
        int[][] arr2 = {{1,2,3,4,5,6,7,8}};
        
        int[] ans16 = BinarySearch2dArray.BinarySearch(arr2, 5);
        assertEquals(0, ans16[0]);
        assertEquals(4, ans16[1]);
//        
        int[][] arr3 = {{}};
        
//        int[] ans19 = BinarySearch2dArray.BinarySearch(arr3, 5);
//        assertEquals(-1, ans19[0]);
//        assertEquals(-1, ans19[1]);
        
//        int[] ans17 = BinarySearch2dArray.BinarySearch(arr2, 100);
//        assertEquals(-1, ans17[0]);
//        assertEquals(-1, ans17[1]);
//        
//        int[] ans18 = BinarySearch2dArray.BinarySearch(arr2, 0);
//        assertEquals(-1, ans18[0]);
//        assertEquals(-1, ans18[1]);
    }
}
