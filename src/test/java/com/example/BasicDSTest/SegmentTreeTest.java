package com.example.BasicDSTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.example.BasicDS.SegmentTree;

public class SegmentTreeTest {

    @Test
    public void testQuery() {
        int[] arr = {1, 3, 5, 7, 9, 11};
        SegmentTree st = new SegmentTree(arr);

        assertEquals(15, st.query(1, 3)); // Sum of range [1, 3] = 3 + 5 + 7 = 15
        assertEquals(32, st.query(2, 5)); // Sum of range [2, 5] = 5 + 7 + 9 + 11 = 32
    }

    @Test
    public void testUpdate() {
        int[] arr = {1, 3, 5, 7, 9, 11};
        SegmentTree st = new SegmentTree(arr);
        
        st.update(1, 10); // Update arr[1] to 10
        
        assertEquals(23, st.query(0, 3)); // After update, the sum of range [0, 3] = 1 + 10 + 5 + 7 = 23
        assertEquals(32, st.query(2, 5)); // Sum of range [2, 5] after update
    }

    @Test
    public void testEdgeCases() {
        int[] arr = {5};
        SegmentTree st = new SegmentTree(arr);
        
        assertEquals(5, st.query(0, 0)); // Query a single element
        st.update(0, 10); // Update the only element
        assertEquals(10, st.query(0, 0)); // Query after update
    }
}
