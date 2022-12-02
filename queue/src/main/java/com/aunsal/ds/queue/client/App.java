package com.aunsal.ds.queue.client;

import com.aunsal.ds.queue.client.factory.ArrayBasedQueueClientFactory;
import com.aunsal.ds.queue.client.factory.LinkedListBasedQueueClientFactory;
import com.aunsal.ds.queue.client.factory.QueueClient;
import com.aunsal.ds.queue.client.factory.QueueClientFactory;

public class App {
    public static void main(String[] args) {
        QueueClient client1 = QueueClientFactory.getClient(new ArrayBasedQueueClientFactory());
//        QueueClient client2 = QueueClientFactory.getClient(new LinkedListBasedQueueClientFactory());
        client1.run();
    }
}
