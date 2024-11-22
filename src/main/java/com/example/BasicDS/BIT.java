package com.example.BasicDS;

public class BIT {
    public int[] bit;
    public int n;

    public BIT(int size) {
        this.n = size;
        this.bit = new int[size + 1]; // BIT array (1-indexed)
    }

    // Update the BIT for index idx with delta
    public void update(int idx, int delta) {
        while (idx <= n) {
            bit[idx] += delta;
            idx += idx & -idx; // Move to the next index to update
        }
    }

    // Query the sum from 1 to idx
    public int query(int idx) {
        int sum = 0;
        while (idx > 0) {
            sum += bit[idx];
            idx -= idx & -idx; // Move to the parent index
        }
        return sum;
    }

    // Query the sum in the range [L, R]
    public int query(int L, int R) {
        return query(R) - query(L - 1);
    }
}
