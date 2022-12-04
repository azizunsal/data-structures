package com.aunsal.ds.tree.client;

import com.aunsal.ds.tree.BinarySearchTree;
import com.aunsal.ds.tree.helper.BTreePrinter;

public class Client {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(20);
        bst.insert(5);
        bst.insert(6);
        bst.insert(4);
        bst.insert(19);
        bst.insert(56);
        bst.insert(22);
        bst.insert(5);
        BTreePrinter.printNode(bst.root);
        System.out.println("min val=" + bst.getMin());
        System.out.println("max val=" + bst.getMax());
    }
}
