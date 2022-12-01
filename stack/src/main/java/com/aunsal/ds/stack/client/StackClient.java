package com.aunsal.ds.stack.client;

import com.aunsal.ds.stack.Stack;
import com.aunsal.ds.stack.impl.ArrayStack;
import com.aunsal.ds.stack.impl.LinkedStack;

import java.util.Scanner;

public class StackClient {
    public static String EXIT_IDENTIFIER = "exit";

    public static void main(String[] args) {
//        Stack<String> stack = new LinkedStack<String>();
        Stack<String> stack = new ArrayStack<>(String.class);
        boolean isStackEmpty = stack.isEmpty();
        System.out.println("Is the stack empty=" + isStackEmpty);

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.next();
            checkExit(input);
            if (input.equals("-")) {
                System.out.println(stack.pop());
            } else {
                stack.push(input);
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