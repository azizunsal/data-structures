package com.aunsal.ds.queue.client.factory;

import com.aunsal.ds.queue.Queue;
import com.aunsal.ds.queue.impl.LinkedListQueue;

public class LinkedListBasedQueueClientFactory implements AbstractQueueClientFactory {
    private Queue<String> queue;

    public LinkedListBasedQueueClientFactory() {
        this.queue = new LinkedListQueue<>();
    }

    @Override
    public QueueClient createClient() {
        return new LinkedListBasedQueueClient(queue);
    }
}
