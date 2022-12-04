package com.aunsal.ds.tree;


/**
 * A basic binary search tree implementation.
 */
public class BinarySearchTree {
    public TreeNode root;

    public Integer get(Integer data) {
        TreeNode node = root;
        while (node != null) {
            if (data == node.data) return node.data;
            if (data < node.data) node = node.left;
            if (data > node.data) node = node.right;
        }
        return null;
    }

    public Integer getMin() {
        return getMin(root);
    }

    private Integer getMin(TreeNode node) {
        int min = node.data;
        node = node.left;
        while (node != null) {
            if (node.data < min) {
                min = node.data;
            }
            node = node.left;
        }
        return min;
    }

    public Integer getMax() {
        return getMax(root);
    }

    private Integer getMax(TreeNode node) {
        int max = node.data;
        node = node.right;
        while (node != null) {
            if (node.data > max) {
                max = node.data;
            }
            node = node.right;
        }
        return max;
    }

    public void insert(Integer data) {
        if (root == null) {
            root = new TreeNode(data);
            return;
        }
        insert(root, data);
    }

    private void insert(TreeNode node, Integer data) {
        if (data < node.data) {
            if (node.left == null) {
                node.left = new TreeNode(data);
            } else {
                insert(node.left, data);
            }
        } else if (data > node.data) {
            if (node.right == null) {
                node.right = new TreeNode(data);
            } else {
                insert(node.right, data);
            }
        } else {
            node.data = data;
        }
    }
}
