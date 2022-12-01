package com.aunsal.ds.queue.impl;

import com.aunsal.ds.queue.Queue;

public class LinkedListQueue<T> implements Queue<T> {
    public Node<T> first;
    Node<T> last;

    public LinkedListQueue() {
    }

    @Override
    public void enqueue(T data) {
        if (isEmpty()) {
            first = new Node<>(data);
            last = first;
            return;
        }
        last.next = new Node<>(data);
        last = last.next;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) throw new IllegalStateException("queue is empty!");
        Node<T> oldFirst = first;
        first = first.next;
        if (isEmpty()) last = first;
        return oldFirst.data;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }
}
