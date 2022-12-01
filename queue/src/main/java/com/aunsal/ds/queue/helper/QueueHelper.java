package com.aunsal.ds.queue.helper;


import com.aunsal.ds.queue.Queue;
import com.aunsal.ds.queue.impl.LinkedListQueue;
import com.aunsal.ds.queue.impl.Node;

public class QueueHelper<T> {
    public void printQueue(Queue<T> q) {
        Node<T> first = ((LinkedListQueue) q).first;
        if (first == null) {
            System.out.println("[]");
            return;
        }
        Node current = first;
        while (current != null) {
            System.out.print(current.data);
            current = current.next;
            if (current != null) {
                System.out.print("-->");
            } else {
            }
        }
        System.out.println();
    }
}
