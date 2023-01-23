package com.insignia.Tree.binaryTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintKLevelDown {

    public static void printKLevelDown(BinaryTreeNode node, int level) {

        if (node == null) {
            return;
        }

        if (level == 0) {
            System.out.println(node.data);
            return;
        }

        if (node.left != null) {
            printKLevelDown(node.left, level - 1);
        }

        if (node.right != null) {
            printKLevelDown(node.right, level - 1);
        }
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

            int level = Integer.parseInt(reader.readLine());

            BinaryTreeNode root = Constructor.constructor(arr);
            PrintKLevelDown.printKLevelDown(root, level);
        }
    }
}
