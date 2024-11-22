package com.example.TreeTest;

import java.util.LinkedList;
import java.util.Queue;

import com.example.Tree.Node;

public class TreeTestUtils {
	public static Node createTree(final Integer[] values) {
		if (values == null || values.length == 0 || values[0] == null) {
			throw new IllegalArgumentException("Values array should not be empty or null.");
		}
		final Node root = new Node(values[0]);
		final Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		int end = 1;
		while (end < values.length) {
			final Node node = queue.remove();
			if (values[end] == null) {
				node.left = null;
			} else {
				node.left = new Node(values[end]);
				queue.add(node.left);
			}
			end++;
			if (end < values.length) {
				if (values[end] == null) {
					node.right = null;
				} else {
					node.right = new Node(values[end]);
					queue.add(node.right);
				}
			}
			end++;
		}
		return root;
	}
}
