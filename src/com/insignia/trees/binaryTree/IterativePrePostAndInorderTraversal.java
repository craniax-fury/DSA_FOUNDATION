package com.insignia.trees.binaryTree;

import java.util.Stack;

public class IterativePrePostAndInorderTraversal {

    public static class Pair {
        int state;
        BinaryNode node;

        Pair(BinaryNode node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static void display(BinaryNode root) {
        String left_data = root.left != null ? String.valueOf(root.left.data) : ".";
        String right_data = root.right != null ? String.valueOf(root.right.data) : ".";

        System.out.print(left_data + " -> " + root.data + " <- " + right_data);

        System.out.println();

        if (root.left != null) {
            display(root.left);
        }

        if (root.right != null) {
            display(root.right);
        }
    }

    static StringBuilder preOrder = new StringBuilder();
    static StringBuilder inorder = new StringBuilder();
    static StringBuilder postOrder = new StringBuilder();

    public static void iterativePrePostInTraversal(BinaryNode node) {
        Stack<Pair> stack = new Stack<>();

        stack.push(new Pair(node, 1));

        while (!stack.isEmpty()) {
            if (stack.peek().state == 1) {
                preOrder.append(stack.peek().node.data).append(" ");
                stack.peek().state += 1;

                if (stack.peek().node.left != null) {
                    stack.push(new Pair(stack.peek().node.left, 1));
                }
            } else if (stack.peek().state == 2) {
                inorder.append(stack.peek().node.data).append(" ");
                stack.peek().state += 1;

                if (stack.peek().node.right != null) {
                    stack.push(new Pair(stack.peek().node.right, 1));
                }
            } else {
                postOrder.append(stack.peek().node.data).append(" ");
                stack.pop();
            }
        }
    }

    public static void main(String[] args) {
        int[] input = new int[] { 50, 25, 12, -1, -1, 37, 30, -1, -1, -1, 75, 62, -1, 70, -1, -1, 87, -1, -1 };
        Stack<Pair> stack = new Stack<>();
        BinaryNode root = new BinaryNode();

        for (int index = 0; index < input.length; index++) {
            if (stack.isEmpty()) {
                root.data = input[index];
                Pair pair = new Pair(root, 0);
                stack.push(pair);
            } else if (input[index] == -1) {
                if (stack.peek().state == 1) {
                    stack.pop();
                } else if (stack.peek().state == 0) {
                    stack.peek().state += 1;
                }

            } else {
                if (stack.peek().state == 0) {
                    BinaryNode left = new BinaryNode(input[index], null, null);
                    stack.peek().node.left = left;
                    stack.peek().state += 1;
                    stack.push(new Pair(left, 0));
                } else {

                    while (!stack.isEmpty() && stack.peek().state == 2) {
                        stack.pop();
                    }

                    BinaryNode right = new BinaryNode(input[index], null, null);
                    stack.peek().node.right = right;
                    stack.peek().state += 1;
                    stack.push(new Pair(right, 0));
                }
            }

        }

        iterativePrePostInTraversal(root);
        System.out.println(preOrder);
        System.out.println(inorder);
        System.out.println(postOrder);

    }

}
