package com.insignia.Tree.Generic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Constructor {

    public static GenericTreeNode constructGenericTree(int[] data) {
        GenericTreeNode root = null;

        Stack<GenericTreeNode> stack = new Stack<>();

        for (int index = 0; index < data.length; index++) {
            if (data[index] != -1) {
                if (stack.isEmpty()) {
                    root = new GenericTreeNode(data[index]);
                    stack.push(root);
                } else {
                    GenericTreeNode node = stack.pop();
                    GenericTreeNode child = new GenericTreeNode(data[index]);
                    node.children.add(child);
                    stack.push(node);
                    stack.push(child);
                }

            }

            if (data[index] == -1) {
                if (stack.isEmpty()) {
                    return root;
                }

                stack.pop();

            }
        }

        return root;
    }

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            int[] arr = new int[n];
            String[] values = reader.readLine().split(" ");
            for (int index = 0; index < n; index++) {
                arr[index] = Integer.parseInt(values[index]);
            }

            constructGenericTree(arr);

        }

    }
}
