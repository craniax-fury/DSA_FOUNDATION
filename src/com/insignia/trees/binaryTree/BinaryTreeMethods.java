package com.insignia.trees.binaryTree;

import java.util.Stack;

public class BinaryTreeMethods {

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

    public static int size(BinaryNode node) {
        int size = 0;
        if (node.left != null) {
            size += size(node.left);
        }

        if (node.right != null) {
            size += size(node.right);
        }

        return size + 1;
    }

    public static int sum(BinaryNode node) {
        int sum = 0;
        if (node.left != null) {
            sum += sum(node.left);
        }

        if (node.right != null) {
            sum += sum(node.right);
        }

        return sum + node.data;
    }

    public static int max(BinaryNode node) {
        int max = Integer.MIN_VALUE;
        if (node.left != null) {
            int temp_left_max = max(node.left);
            if (temp_left_max > max) {
                max = temp_left_max;
            }
        }

        if (node.right != null) {
            int temp_right_max = max(node.right);
            if (temp_right_max > max) {
                max = temp_right_max;
            }
        }

        return node.data > max ? node.data : max;
    }

    public static int height(BinaryNode node) {
        int height = -1;

        if (node.left != null) {
            int temp_left_height = height(node.left);
            if (temp_left_height > height) {
                height = temp_left_height;
            }
        }

        if (node.right != null) {
            int temp_right_height = height(node.right);
            if (temp_right_height > height) {
                height = temp_right_height;
            }
        }

        return height + 1;
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

        int size = size(root);
        int sum = sum(root);
        int max = max(root);
        int height = height(root);

        System.out.println(size);
        System.out.println(sum);
        System.out.println(max);
        System.out.println(height);
    }

}
