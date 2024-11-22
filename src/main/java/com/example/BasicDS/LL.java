package com.example.BasicDS;

public class LL {
    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    private Node head;

    public void add(int value) {
        if (head == null) {
            head = new Node(value);
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(value);
    }

    public void remove(int value) {
        if (head == null) return;

        if (head.value == value) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.value != value) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public boolean isPalindrome() {
        if (head == null || head.next == null) return true;

        Node slow = head, fast = head;
        Node prev = null, temp;

        // Reverse the first half while finding the middle
        while (fast != null && fast.next != null) {
            fast = fast.next.next;

            temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }

        // If odd number of elements, skip the middle node
        if (fast != null) {
            slow = slow.next;
        }

        // Compare the reversed first half with the second half
        while (prev != null && slow != null) {
            if (prev.value != slow.value) return false;
            prev = prev.next;
            slow = slow.next;
        }

        return true;
    }

    public void reverse() {
        Node prev = null, current = head, next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.value).append(" -> ");
            current = current.next;
        }
        sb.append("null");
        return sb.toString();
    }
}
