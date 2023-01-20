package com.insignia.trees.genericTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class PredecessorAndSuccessor {
    public static void display(TreeNode node) {
        System.out.print(node.data + " -> ");

        for (TreeNode child : node.children) {
            System.out.print(child.data + ", ");
        }

        System.out.println(".");

        for (TreeNode child : node.children) {
            display(child);
        }
    }

    static TreeNode predecessor;
    static TreeNode successor;
    static int state = 0;

    public static void predecessorAndSuccessor(TreeNode node, int data) {
        if (state == 0) {
            if (node.data == data) {
                state = 1;
            } else {
                predecessor = node;
            }
        } else if (state == 1) {
            successor = node;
            state = 2;
            return;
        }
        for (TreeNode child : node.children) {
            predecessorAndSuccessor(child, data);

        }

    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int[] input = new int[] { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40,
                    100, -1, -1, -1 };

            Stack<TreeNode> stack = new Stack<>();
            TreeNode root = new TreeNode();

            for (int index = 0; index < input.length; index++) {
                if (input[index] == -1) {
                    stack.pop();
                } else if (stack.size() == 0) {
                    root.data = input[index];
                    stack.push(root);
                } else {
                    TreeNode node = new TreeNode();
                    node.data = input[index];
                    stack.peek().children.add(node);
                    stack.push(node);
                }
            }
            int data = Integer.parseInt(reader.readLine());

            predecessor = null;
            successor = null;
            predecessorAndSuccessor(root, data);
            if (predecessor == null) {
                System.out.println("Predecessor = Not found");
            } else {
                System.out.println("Predecessor = " + predecessor.data);
            }

            if (successor == null) {
                System.out.println("Successor = Not found");
            } else {
                System.out.println("Successor = " + successor.data);
            }
        }

    }

}
