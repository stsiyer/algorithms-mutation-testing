package com.example.BasicDS;

public class SegmentTree {
    public int[] tree;
    public int n;

    public SegmentTree(int[] arr) {
        this.n = arr.length;
        this.tree = new int[4 * n]; // Segment tree array
        build(arr, 0, 0, n - 1);
    }

    // Build the segment tree
    private void build(int[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start]; // Leaf node
        } else {
            int mid = (start + end) / 2;
            build(arr, 2 * node + 1, start, mid); // Left child
            build(arr, 2 * node + 2, mid + 1, end); // Right child
            tree[node] = tree[2 * node + 1] + tree[2 * node + 2]; // Parent node is the sum of both children
        }
    }

    // Query the sum in the range [L, R]
    public int query(int L, int R) {
        return query(0, 0, n - 1, L, R);
    }

    private int query(int node, int start, int end, int L, int R) {
        if (R < start || end < L) {
            return 0; // No overlap
        }
        if (L <= start && end <= R) {
            return tree[node]; // Total overlap
        }
        // Partial overlap
        int mid = (start + end) / 2;
        int left = query(2 * node + 1, start, mid, L, R);
        int right = query(2 * node + 2, mid + 1, end, L, R);
        return left + right;
    }

    // Update the value at index idx to value
    public void update(int idx, int value) {
        update(0, 0, n - 1, idx, value);
    }

    private void update(int node, int start, int end, int idx, int value) {
        if (start == end) {
            tree[node] = value; // Leaf node update
        } else {
            int mid = (start + end) / 2;
            if (start <= idx && idx <= mid) {
                update(2 * node + 1, start, mid, idx, value); // Left child
            } else {
                update(2 * node + 2, mid + 1, end, idx, value); // Right child
            }
            tree[node] = tree[2 * node + 1] + tree[2 * node + 2]; // Update parent node
        }
    }
}
