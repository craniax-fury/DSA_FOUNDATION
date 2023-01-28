package com.insignia.Tree.binaryTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumTree {

    static class Pair {
        boolean isSumTree;
        int sum;

        Pair(boolean isSumTree, int sum) {
            this.isSumTree = isSumTree;
            this.sum = sum;
        }
    }

    public static Pair sumTree(BinaryTreeNode node) {
        if (node == null || (node.left == null && node.right == null)) {
            return new Pair(true, node.data);
        }

        Pair left = sumTree(node.left);

        if (!left.isSumTree) {
            return new Pair(false, -1);
        }

        Pair right = sumTree(node.right);

        if (!right.isSumTree) {
            return new Pair(false, -1);
        }

        int sum = left.sum + right.sum;

        if (sum != node.data) {
            return new Pair(false, -1);
        }

        return new Pair(true, left.sum + right.sum);
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
            System.out.println(SumTree.sumTree(root).isSumTree);
        }
    }
}
