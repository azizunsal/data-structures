package com.aunsal.ds.queue.client.factory;

import com.aunsal.ds.queue.Queue;

import java.util.Scanner;

public abstract class QueueClient {
    private static final String EXIT_IDENTIFIER = "exit";
    private static final String DEQUEUE_IDENTIFIER = "-";
    private static final String PRINT_IDENTIFIER = "print";
    private static final String EMPTY_CHECK_IDENTIFIER = "empty";

    public abstract Queue<String> getQueue();

    public abstract Scanner getScanner();

    public abstract void printQueue(Queue queue);

    public void run() {
        while (getScanner().hasNext()) {
            String input = getScanner().next();
            switch (input) {
                case DEQUEUE_IDENTIFIER:
                    String removedVal = getQueue().dequeue();
                    System.out.println("'" + removedVal + "' removed.");
                    break;
                case EXIT_IDENTIFIER:
                    System.out.println("\nbye...");
                    return;
                case PRINT_IDENTIFIER:
                    printQueue(getQueue());
                    break;
                case EMPTY_CHECK_IDENTIFIER:
                    System.out.println("Empty=" + getQueue().isEmpty());
                    break;
                default:
                    getQueue().enqueue(input);
            }
        }
    }
}
