package com.insignia.trees.genericTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class LevelTraversals {

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

    public static void levelOrder(TreeNode node) {
        Queue<TreeNode> queue = new ArrayDeque<>();

        if (queue.isEmpty()) {
            queue.add(node);
        }

        while (!queue.isEmpty()) {
            TreeNode queueEle = queue.remove();
            System.out.print(queueEle.data + " ");
            for (TreeNode child : queueEle.children) {
                queue.add(child);
            }

        }

        System.out.print(".");

    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int[] input = new int[] { 10, 20, -1, 30, 50, -1, 60, -1, -1, 40, -1, -1 };

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

            display(root);
            System.out.println("___________________________");
            levelOrder(root);

        }

    }
}
