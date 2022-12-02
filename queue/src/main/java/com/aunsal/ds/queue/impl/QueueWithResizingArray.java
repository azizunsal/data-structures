package com.aunsal.ds.queue.impl;

import com.aunsal.ds.queue.Queue;

import java.lang.reflect.Array;

public class QueueWithResizingArray<T> implements Queue<T> {
    public T[] arr;
    public int first;
    public int last;

    public int size;

    private Class clazz;

    @SuppressWarnings("unchecked")
    public QueueWithResizingArray(Class clazz) {
        this.clazz = clazz;
        this.arr = (T[]) Array.newInstance(clazz, 1);
    }

    @Override
    public void enqueue(T data) {
        if (last == arr.length) resizeArray(arr.length * 2);
        arr[last++] = data;
        size++;
    }

    @Override
    public T dequeue() {
        T val = arr[first++];
        arr[first - 1] = null;
        size--;
        if (size == arr.length / 4) resizeArray(arr.length / 2);
        return val;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @SuppressWarnings("unchecked")
    private void resizeArray(int newCapacity) {
        T[] newArr = (T[]) Array.newInstance(clazz, newCapacity);
        int index = 0;
        for (int i = first; i < last; i++) {
            newArr[index] = arr[i];
            index++;
        }
        arr = newArr;
        first = 0;
        last = index;
    }
}
