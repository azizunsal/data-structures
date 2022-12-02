package com.aunsal.ds.queue.client.factory;

import com.aunsal.ds.queue.Queue;
import com.aunsal.ds.queue.impl.LinkedListQueue;
import com.aunsal.ds.queue.impl.Node;

import java.util.Scanner;

public class LinkedListBasedQueueClient extends QueueClient {
    private Queue<String> queue;
    private Scanner scanner;

    public LinkedListBasedQueueClient(Queue<String> queue) {
        this.queue = queue;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public Queue getQueue() {
        return queue;
    }

    @Override
    public Scanner getScanner() {
        return scanner;
    }

    @Override
    public void printQueue(Queue queue) {
        Node<String> first = ((LinkedListQueue) queue).first;
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
