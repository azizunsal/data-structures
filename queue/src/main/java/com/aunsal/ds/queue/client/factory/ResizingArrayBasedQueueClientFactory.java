package com.aunsal.ds.queue.client.factory;

import com.aunsal.ds.queue.Queue;
import com.aunsal.ds.queue.impl.QueueWithResizingArray;

public class ResizingArrayBasedQueueClientFactory implements AbstractQueueClientFactory {

    private Queue<String> queue;

    public ResizingArrayBasedQueueClientFactory() {
        this.queue = new QueueWithResizingArray<>(String.class);
    }

    @Override
    public QueueClient createClient() {
        return new ResizingArrayBasedQueueClient(queue);
    }
}
