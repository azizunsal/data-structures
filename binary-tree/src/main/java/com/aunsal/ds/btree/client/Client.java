package com.aunsal.ds.btree.client;

import com.aunsal.ds.btree.TreeNode;
import com.aunsal.ds.btree.helper.BinaryTreeHelper;
import com.aunsal.ds.btree.helper.BinaryTreePrinter;

import java.util.Arrays;

public class Client {
    public static void main(String[] args) {
        // Inputs with null values
        Integer[] input1 = new Integer[]{2, null, 3, null, 4, null, 5, null, 6};
        Integer[] input2 = new Integer[]{3, 9, 20, null, null, 15, 7};
        Integer[] input3 = new Integer[]{1, null, 2, 3};
        Integer[] input4 = new Integer[]{5, 1, 4, null, null, 3, 6};
        Integer[] input5 = new Integer[]{1, 2, 3, null, 5, null, 7};
        Integer[] input6 = new Integer[]{5, 4, 8, 11, null, 17, 4, 7, null, null, null, 5};
        Integer[] input7 = new Integer[]{5, 4, 8, 11, null, 17, 4, 7, null, null, null, null, null, 5, null};

        TreeNode root = BinaryTreeHelper.createBinaryTreeFromArray(input6);
        System.out.println("root=" + root);
        BinaryTreePrinter.printNode(root);

        // Inputs without null values
        Integer[] woNullInput1 = new Integer[]{3, 9, 20, 4, 16, 15, 7};
        Integer[] woNullInput2 = new Integer[]{10, 20, 30, 40, 50, 60};
        Integer[] woNullInput3 = new Integer[]{3, 9, 20, 4, 16, 15, 7, 12, 56, 17, 90};

        System.out.println(Arrays.toString(woNullInput1));
        TreeNode root1 = BinaryTreeHelper.createBinaryTreeFromArray(woNullInput1);
        BinaryTreePrinter.printNode(root1);
    }
}