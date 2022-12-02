package com.aunsal.ds.queue.client.factory;

public class QueueClientFactory {
    public static QueueClient getClient(AbstractQueueClientFactory abstractQueueClientFactory) {
        return abstractQueueClientFactory.createClient();
    }
}
