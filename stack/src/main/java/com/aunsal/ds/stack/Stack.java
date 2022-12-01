package com.aunsal.ds.stack;

import java.util.EmptyStackException;

public interface Stack<T> {
    void push(T data);

    T pop() throws EmptyStackException;

    boolean isEmpty();
}
