package com.aunsal.ds.btree.helper;

import com.aunsal.ds.btree.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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
     * <p>
     * Doesn't work for arrays which contain null values.
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

    /**
     * Creates a binary tree from given integer array. Array can contain null values.
     * Method behaves null values as path terminators.
     *
     * @param arr
     * @return
     */
    public static TreeNode createBinaryTreeFromArrayWithQueue(final Integer[] arr) {
        System.out.println("Creating a binary tree from the input array: \n" + Arrays.toString(arr));
        Queue<Integer> q1 = new LinkedList<>();
        q1.addAll(Arrays.asList(arr));

        Queue<TreeNode> q2 = new LinkedList<>();
        TreeNode root = new TreeNode(q1.remove());
        q2.add(root);

        while (!q1.isEmpty()) {
            TreeNode node = q2.remove();
            System.out.println("node=" + node);
            if (node.left == null) {
                try {
                    Integer val = q1.remove();
                    if (val != null) {
                        node.left = new TreeNode(val);
                        q2.add(node.left);
                    }
                } catch (Exception e) {
                    System.out.println("\tErr on left node creation: " + e);
                    System.out.println("\tq1=" + q1);
                }
            }
            if (node.right == null) {
                try {
                    Integer val = q1.remove();
                    if (val != null) {
                        node.right = new TreeNode(val);
                        q2.add(node.right);
                    }
                } catch (Exception e) {
                    System.out.println("\tErr on right node creation: " + e);
                    System.out.println("\tq1=" + q1);
                }
            }
        }
        return root;
    }

    /**
     * Prints the binary tree in BSF (level-order).
     *
     * @param root
     */
    public static void printInLevelOrder(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            System.out.print(node.data);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }

        System.out.println("\ndone.");
    }

    /**
     * Prints the tree in DFS.
     *
     * @param root
     */
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
