package com.insignia.Tree.BinarySearchTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Utility {

    public static int size(BSTNode node) {
        int size = 0;

        if (node == null) {
            return size;
        }

        int lsize = size(node.left);
        int rsize = size(node.right);

        return lsize + rsize + 1;
    }

    public static int sum(BSTNode node) {
        int sum = 0;

        if (node == null) {
            return sum;
        }

        int lSum = sum(node.left);
        int rSum = sum(node.right);

        return lSum + rSum + node.data;
    }

    public static int max(BSTNode node) {
        int max = Integer.MIN_VALUE;

        if (node == null) {
            return max;
        }

        if (node.right != null) {
            return max(node.right);
        }

        return node.data;
    }

    public static int min(BSTNode node) {

        if (node == null) {
            return Integer.MAX_VALUE;
        }

        if (node.left != null) {
            return min(node.left);
        }

        return node.data;

    }

    public static boolean find(BSTNode node, int data) {

        if (node == null) {
            return false;
        }

        if (node.data == data) {
            return true;
        }

        if (data < node.data) {
            if (find(node.left, data)) {
                return true;
            }
        } else {
            if (find(node.right, data)) {
                return true;
            }
        }

        return false;
    }

    public static void display(BSTNode node) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            System.out.print(node.left.data + " <- ");
        } else {
            System.out.print("." + " <- ");
        }

        System.out.print(node.data + " -> ");

        if (node.right != null) {
            System.out.print(node.right.data);
        } else {
            System.out.print(".");
        }

        System.out.println();

        display(node.left);
        display(node.right);

    }

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int n = Integer.parseInt(reader.readLine());
            Integer[] arr = new Integer[n];
            String[] values = reader.readLine().split(" ");
            for (int index = 0; index < n; index++) {
                if (!(values[index].equals("n"))) {
                    arr[index] = Integer.parseInt(values[index]);
                } else {
                    arr[index] = null;
                }
            }

            int data = Integer.parseInt(reader.readLine());

            BSTNode root = Constructor.constructor(arr);

            int size = size(root);
            int sum = sum(root);
            int max = max(root);
            int min = min(root);
            boolean found = find(root, data);

            System.out.println(size);
            System.out.println(sum);
            System.out.println(max);
            System.out.println(min);
            System.out.println(found);
        }
    }
}
