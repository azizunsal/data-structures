package com.aunsal.ds.queue.client.factory;

import com.aunsal.ds.queue.Queue;
import com.aunsal.ds.queue.impl.QueueWithFixedSizeArray;

public class ArrayBasedQueueClientFactory implements AbstractQueueClientFactory {
    private Queue<String> queue;

    public ArrayBasedQueueClientFactory() {
        queue = new QueueWithFixedSizeArray<>(String.class);
    }

    @Override
    public QueueClient createClient() {
        return new ArrayBasedQueueClient(queue);
    }
}
