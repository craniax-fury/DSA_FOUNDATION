package com.insignia.genericTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativePreandPostOrder {
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

    public static class Pair {
        int state;
        TreeNode val;

        Pair(int state, TreeNode val) {
            this.state = state;
            this.val = val;
        }
    }

    public static void iterativePreandPostOrder(TreeNode node) {
        Stack<Pair> stack = new Stack<>();

        List<Integer> preOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();

        stack.push(new Pair(-1, node));

        while (!stack.isEmpty()) {
            if (stack.peek().state == -1) {
                preOrder.add(stack.peek().val.data);
                stack.peek().state++;
            } else if (stack.peek().state == stack.peek().val.children.size()) {
                postOrder.add(stack.pop().val.data);
            } else {
                int top = stack.peek().state;
                stack.peek().state++;
                stack.push(new Pair(-1, stack.peek().val.children.get(top)));

            }
        }
        for (Integer val : preOrder) {
            System.out.print(val + " ");
        }

        System.out.println();

        for (Integer val : postOrder) {
            System.out.print(val + " ");
        }

    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int[] input = new int[] { 10, 20, -50, -1, 60, -1, -1, 30, 70, -1, -80, 110, -1, -120, -1, -1, 90, -1, -1,
                    40, -100, -1, -1, -1 };

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

            iterativePreandPostOrder(root);

        }

    }

}
