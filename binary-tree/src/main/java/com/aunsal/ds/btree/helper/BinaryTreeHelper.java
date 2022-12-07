package com.aunsal.ds.btree.helper;

import com.aunsal.ds.btree.TreeNode;

import java.util.Arrays;

public final class BinaryTreeHelper {
    private BinaryTreeHelper() {
    }

    public static TreeNode createBinaryTreeFromArray(Integer[] arr) {
        if (arr == null || arr.length == 0) throw new IllegalArgumentException("No input to construct a BT!");
        System.out.println(Arrays.toString(arr));
        return createBinaryTreeFromArray(new TreeNode(arr[0]), 0, arr);
    }

    /**
     * Creates a binary tree from given integer array.
     * The array cannot contain null values
     *
     * @param parent current node.
     * @param idx    current index.
     * @param arr    integer array.
     * @return the root node of the tree.
     */
    public static TreeNode createBinaryTreeFromArray(TreeNode parent, int idx, final Integer[] arr) {
        int nextLeftIndex = 2 * idx + 1;
        if (nextLeftIndex > arr.length - 1) {
            //System.out.println("parent=" + parent.data + ", left is null.");
            return null;
        } else {
            parent.left = new TreeNode(arr[nextLeftIndex]);
            //System.out.println("parent=" + parent.data + ", left=" + parent.left.data);
            createBinaryTreeFromArray(parent.left, nextLeftIndex, arr);
        }

        int nextRightIndex = 2 * idx + 2;
        if (nextRightIndex > arr.length - 1) {
            //System.out.println("parent=" + parent.data + ", right is null.");
            return null;
        } else {
            parent.right = new TreeNode(arr[nextRightIndex]);
            //System.out.println("parent=" + parent.data + ", right=" + parent.right.data);
            createBinaryTreeFromArray(parent.right, nextRightIndex, arr);
        }
        return parent;
    }

    public static void printNodesByLevel(Integer[] arr) {
        System.out.println(Arrays.toString(arr));
        int startingIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            int nodeCount = (int) Math.pow(2d, i);
            System.out.println("level=" + i + ", node count=" + nodeCount + ", startingIndex=" + startingIndex);
            for (int j = startingIndex; j < startingIndex + nodeCount; j++) {
                if (j > arr.length - 1) {
                    //System.out.println("There is not enough item in the input array!");
                    break;
                }
                System.out.print("\tarr[" + j + "]=" + arr[j] + ",");
            }
            startingIndex = startingIndex + nodeCount;
            System.out.println();
        }
    }

    public static void printInLevelOrder(TreeNode root, int height, int level) {
        if (level == height) return;
        if (root == null) return;
        if (level == 0) {
            System.out.println(root.data);
        } else {
            printInLevelOrder(root.left, height, level);
            printInLevelOrder(root.right, height, level);
        }
        level++;
        printInLevelOrder(root, height, level);
    }

    public static void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.data + ",");
        printInorder(root.right);
    }

    public static int getMaxLevel(TreeNode root) {
        if (root == null) return 0;
        int leftLevel = getMaxLevel(root.left);
        int rightLevel = getMaxLevel(root.right);
        int maxLevel = leftLevel > rightLevel ? leftLevel : rightLevel;
        return maxLevel + 1; // Add root node to the calculation.
    }

    public static int getHeight(TreeNode root) {
        return getMaxLevel(root);
    }

}
