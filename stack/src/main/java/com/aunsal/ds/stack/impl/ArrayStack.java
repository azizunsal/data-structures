package com.aunsal.ds.stack.impl;

import com.aunsal.ds.stack.Stack;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack<T> implements Stack<T> {
    private static final int INITIAL_CAPACITY = 10;
    private T[] values;
    private int size;

    public ArrayStack(Class clazz) {
        this.values = (T[]) Array.newInstance(clazz, INITIAL_CAPACITY);
    }

    @Override
    public void push(T data) {
        values[size] = data;
        size++;
    }

    @Override
    public T pop() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException();
        T current = values[size - 1];
        // Avoid loitering!
        values[size - 1] = null;
        size--;
        return current;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
