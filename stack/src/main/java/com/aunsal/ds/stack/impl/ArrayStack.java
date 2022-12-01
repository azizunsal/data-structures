package com.aunsal.ds.stack.impl;

import com.aunsal.ds.stack.Stack;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack<T> implements Stack<T> {
    private static final int INITIAL_CAPACITY = 1;
    private T[] values;
    private int size;
    private Class clazz;

    public ArrayStack(Class clazz) {
        this.values = (T[]) Array.newInstance(clazz, INITIAL_CAPACITY);
        this.clazz = clazz;
    }

    private void checkCapacityOnPush() {
        if (size < values.length) return;
        resize(values.length * 2);
    }

    private void checkCapacityOnPop() {
        if (size == 0) return;
        if (size != values.length / 4) return;
        resize(values.length / 2);
    }

    private void resize(int capacity) {
        T[] newArr = (T[]) Array.newInstance(clazz, capacity);
        for (int i = 0; i < size; i++) {
            newArr[i] = values[i];
        }
        values = newArr;
        System.out.println("resized=" + Arrays.toString(values));
    }


    @Override
    public void push(T data) {
        checkCapacityOnPush();
        values[size++] = data;
    }

    @Override
    public T pop() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException();
        T current = values[--size];
        // Avoid loitering!
        values[size] = null;
        checkCapacityOnPop();
        return current;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
