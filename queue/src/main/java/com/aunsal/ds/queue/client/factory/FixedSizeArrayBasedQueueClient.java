package com.aunsal.ds.queue.client.factory;

import com.aunsal.ds.queue.Queue;
import com.aunsal.ds.queue.impl.QueueWithFixedSizeArray;

import java.util.Arrays;
import java.util.Scanner;

public class FixedSizeArrayBasedQueueClient extends QueueClient {
    private Queue<String> queue;
    private Scanner scanner;

    public FixedSizeArrayBasedQueueClient(Queue<String> queue) {
        this.queue = queue;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public Queue<String> getQueue() {
        return queue;
    }

    @Override
    public Scanner getScanner() {
        return scanner;
    }

    @Override
    public void printQueue(Queue queue) {
        if (queue.isEmpty()) System.out.printf("array is empty!");

        String[] arr = (String[]) ((QueueWithFixedSizeArray) queue).arr;
        int f = ((QueueWithFixedSizeArray) queue).first;
        int l = ((QueueWithFixedSizeArray) queue).last;
        System.out.println("arr=" + Arrays.toString(arr) + "\nfirst=" + f + ", last=" + l);
    }

}
