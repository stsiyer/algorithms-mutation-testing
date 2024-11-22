package com.example.BasicDS;


import java.util.EmptyStackException;

public class Stack {
    public int[] stackArray;
    public int top;
    public int capacity;

    public Stack(int capacity) {
        this.capacity = capacity;
        this.stackArray = new int[capacity];
        this.top = -1; // Indicates an empty stack
    }

    public void push(int value) {
        if (top == capacity - 1) {
            throw new StackOverflowError("Stack is full");
        }
        stackArray[++top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stackArray[top--];
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stackArray[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    public String toString() {
        if (isEmpty()) {
            return "Stack is empty";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= top; i++) {
            sb.append(stackArray[i]).append(" ");
        }
        return sb.toString().trim();
    }
}

