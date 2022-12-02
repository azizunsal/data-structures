package com.aunsal.ds.queue.client.factory;

import com.aunsal.ds.queue.Queue;
import com.aunsal.ds.queue.impl.QueueWithResizingArray;

import java.util.Arrays;
import java.util.Scanner;

public class ResizingArrayBasedQueueClient extends QueueClient {

    private Queue<String> queue;
    private Scanner scanner;

    public ResizingArrayBasedQueueClient(Queue queue) {
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

        String[] arr = (String[]) ((QueueWithResizingArray) queue).arr;
        int first = ((QueueWithResizingArray) queue).first;
        int last = ((QueueWithResizingArray) queue).last;
        int sz = ((QueueWithResizingArray) queue).size;
        System.out.println("arr=" + Arrays.toString(arr) + "\nfirst=" + first + ", last=" + last + ", size=" + sz);
    }
}
