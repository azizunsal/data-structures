package com.aunsal.ds.queue.client.factory;

import com.aunsal.ds.queue.Queue;
import com.aunsal.ds.queue.impl.QueueWithFixedSizeArray;

public class FixedSizeArrayBasedQueueClientFactory implements AbstractQueueClientFactory {
    private Queue<String> queue;

    public FixedSizeArrayBasedQueueClientFactory() {
        queue = new QueueWithFixedSizeArray<>(String.class);
    }

    @Override
    public QueueClient createClient() {
        return new FixedSizeArrayBasedQueueClient(queue);
    }
}
