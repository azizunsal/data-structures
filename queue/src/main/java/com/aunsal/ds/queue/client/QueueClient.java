package com.aunsal.ds.queue.client;

import com.aunsal.ds.queue.Queue;
import com.aunsal.ds.queue.helper.QueueHelper;
import com.aunsal.ds.queue.impl.LinkedListQueue;

import java.util.Scanner;

public class QueueClient {
    public static String EXIT_IDENTIFIER = "exit";

    public static void main(String[] args) {
        QueueHelper queueHelper = new QueueHelper();
        Queue<String> queue = new LinkedListQueue<>();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.next();
            checkExit(input);
            if (input.equals("-")) {
                System.out.println(queue.dequeue());
            } else if (input.equalsIgnoreCase("print")) {
                queueHelper.printQueue(queue);
            } else {
                queue.enqueue(input);
            }
        }
    }

    public static void checkExit(String userInput) {
        if (userInput.equalsIgnoreCase(EXIT_IDENTIFIER)) {
            System.out.println("\nbye...");
            System.exit(0);
        }
    }

}
