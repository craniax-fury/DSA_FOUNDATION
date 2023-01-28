package com.insignia.Tree.binaryTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HeightBalanced {

    static class Pair {
        boolean isBalanced;
        int height;
    
        Pair(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    public static Pair checkHeightBalanced(BinaryTreeNode node) {
        if (node == null) {
            return new Pair(true, 0);
        }

        Pair left = checkHeightBalanced(node.left);

        if (!left.isBalanced) {
            return new Pair(false, -1);
        }

        Pair right = checkHeightBalanced(node.right);

        if (!right.isBalanced) {
            return new Pair(false, -1);
        }

        int difference = left.height - right.height;

        if (Math.abs(difference) > 1) {
            return new Pair(false, -1);
        }

        return new Pair(true, Math.max(left.height, right.height) + 1);
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
            System.out.println(HeightBalanced.checkHeightBalanced(root).isBalanced);
        }
    }
}
