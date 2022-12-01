package com.aunsal.ds.stack.impl;

import com.aunsal.ds.stack.Stack;

import java.util.EmptyStackException;

/**
 * A simple stack implementation using linked list.
 */
public class LinkedStack<T> implements Stack<T> {

    private Node<T> first;

    @Override
    public void push(T data) {
        if (isEmpty()) {
            first = new Node(data);
            return;
        }
        Node temp = first;
        first = new Node(data);
        first.next = temp;
    }

    @Override
    public T pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Node<T> temp = first;
        first = first.next;
        return temp.data;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }
}
