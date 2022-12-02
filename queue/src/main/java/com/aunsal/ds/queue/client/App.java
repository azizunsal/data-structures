package com.aunsal.ds.queue.client;

import com.aunsal.ds.queue.client.factory.FixedSizeArrayBasedQueueClientFactory;
import com.aunsal.ds.queue.client.factory.QueueClient;
import com.aunsal.ds.queue.client.factory.QueueClientFactory;
import com.aunsal.ds.queue.client.factory.ResizingArrayBasedQueueClientFactory;

public class App {
    public static void main(String[] args) {
//        QueueClient client1 = QueueClientFactory.getClient(new FixedSizeArrayBasedQueueClientFactory());
//        client1.run();
//        QueueClient client2 = QueueClientFactory.getClient(new LinkedListBasedQueueClientFactory());
//        client2.run();
        QueueClient client3 = QueueClientFactory.getClient(new ResizingArrayBasedQueueClientFactory());
        client3.run();
    }
}
