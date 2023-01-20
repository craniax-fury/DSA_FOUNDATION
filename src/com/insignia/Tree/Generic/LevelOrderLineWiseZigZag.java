package com.insignia.Tree.Generic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class LevelOrderLineWiseZigZag {

    public static void levelOrderLineWiseTraverse(GenericTreeNode node) {

        if (node == null) {
            return;
        }

        Stack<GenericTreeNode> mainStack = new Stack<>();
        Stack<GenericTreeNode> childStack = new Stack<>();

        mainStack.push(node);

        while (!(mainStack.isEmpty() && childStack.isEmpty())) {

            while (!mainStack.isEmpty()) {
                GenericTreeNode headNode = mainStack.pop();
                System.out.print(headNode.data + " ");

                for (GenericTreeNode child : headNode.children) {
                    childStack.push(child);
                }

            }

            System.out.println();

            while (!childStack.isEmpty()) {
                GenericTreeNode headNode = childStack.pop();
                System.out.print(headNode.data + " ");

                for (int index = headNode.children.size() - 1; index >= 0; index--) {
                    mainStack.push(headNode.children.get(index));
                }
            }

            System.out.println();

        }

    }

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            int[] arr = new int[n];
            String[] values = reader.readLine().split(" ");
            for (int index = 0; index < n; index++) {
                arr[index] = Integer.parseInt(values[index]);
            }

            GenericTreeNode root = Constructor.constructGenericTree(arr);

            levelOrderLineWiseTraverse(root);

        }

    }
}
