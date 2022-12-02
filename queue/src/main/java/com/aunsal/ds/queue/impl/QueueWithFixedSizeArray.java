package com.aunsal.ds.queue.impl;

import com.aunsal.ds.queue.Queue;

import java.lang.reflect.Array;

public class QueueWithFixedSizeArray<T> implements Queue<T> {
    private static final int INITIAL_CAPACITY = 10;
    public T[] arr;
    public int last;
    public int first;

    @SuppressWarnings("unchecked")
    public QueueWithFixedSizeArray(Class clazz) {
        this.arr = (T[]) Array.newInstance(clazz, INITIAL_CAPACITY);
    }

    @Override
    public void enqueue(T data) {
        if (last == arr.length - 1) throw new IllegalStateException("Queue is full!");
        arr[last++] = data;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty!");
        T itemToBeRemoved = arr[first++];
        arr[first - 1] = null;
        return itemToBeRemoved;
    }

    @Override
    public boolean isEmpty() {
        return last == first;
    }
}
