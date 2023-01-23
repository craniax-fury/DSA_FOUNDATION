package com.insignia.Tree.binaryTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MultiSolver {

    public static int size(BinaryTreeNode node) {
        int size = 0;

        if (node == null) {
            return 0;
        }

        if (node.left != null) {
            size += size(node.left);
        }

        if (node.right != null) {
            size += size(node.right);
        }

        return size + 1;
    }

    public static int sum(BinaryTreeNode node) {
        int sum = 0;

        if (node == null) {
            return 0;
        }

        if (node.left != null) {
            sum += sum(node.left);
        }

        if (node.right != null) {
            sum += sum(node.right);
        }

        return sum + node.data;
    }

    public static int max(BinaryTreeNode node) {
        int max = Integer.MIN_VALUE;

        if (node == null) {
            return max;
        }

        if (node.left != null) {
            int tempMax = max(node.left);
            if (tempMax > max) {
                max = tempMax;
            }
        }

        if (node.right != null) {
            int tempMax = max(node.right);
            if (tempMax > max) {
                max = tempMax;
            }
        }

        if (node.data > max) {
            max = node.data;
        }

        return max;

    }

    public static int height(BinaryTreeNode node) {
        int height = -1;

        if (node == null) {
            return height;
        }

        if (node.left != null) {
            int tempHeight = height(node.left);
            if (tempHeight > height) {
                height = tempHeight;
            }
        }

        if (node.right != null) {
            int tempHeight = height(node.right);
            if (tempHeight > height) {
                height = tempHeight;
            }
        }

        return height + 1;

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

            BinaryTreeNode root = Constructor.constructor(arr);
            System.out.println(MultiSolver.size(root));
            System.out.println(MultiSolver.sum(root));
            System.out.println(MultiSolver.max(root));
            System.out.println(MultiSolver.height(root));
        }
    }
}
