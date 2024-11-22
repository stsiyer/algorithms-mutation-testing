package com.example.BasicDSTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.example.BasicDS.BIT;

public class BITTest {

    @Test
    public void testQuery() {
        BIT bit = new BIT(5);
        
        bit.update(1, 5);  // BIT[1] = 5
        bit.update(2, 3);  // BIT[2] = 3
        bit.update(3, 7);  // BIT[3] = 7
        bit.update(4, 2);  // BIT[4] = 2
        bit.update(5, 1);  // BIT[5] = 1
        
        assertEquals(5, bit.query(1)); // Sum from 1 to 1
        assertEquals(8, bit.query(2)); // Sum from 1 to 2
        assertEquals(18, bit.query(5)); // Sum from 1 to 5
        assertEquals(12, bit.query(2, 4)); // Sum from 2 to 4
    }

    @Test
    public void testUpdate() {
        BIT bit = new BIT(5);
        
        bit.update(1, 5);  // BIT[1] = 5
        bit.update(3, 7);  // BIT[3] = 7
        
        assertEquals(5, bit.query(1)); // Sum from 1 to 1
        assertEquals(12, bit.query(3)); // Sum from 1 to 3
        assertEquals(7, bit.query(2, 3)); // Sum from 2 to 3
    }

    @Test
    public void testEdgeCases() {
        BIT bit = new BIT(1);
        
        bit.update(1, 10); // BIT[1] = 10
        assertEquals(10, bit.query(1)); // Query on single element
        bit.update(1, 5); // Update BIT[1] to 15
        assertEquals(15, bit.query(1)); // Query after update
    }
}
