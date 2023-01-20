package com.insignia.trees.binaryTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class TiltOfBinaryTree {

    public static class Pair {
        int state;
        BinaryNode node;

        Pair(BinaryNode node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static class LevelPair {
        int level;
        BinaryNode node;

        LevelPair(BinaryNode node, int level) {
            this.node = node;
            this.level = level;
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

    static int tilt = 0;

    public static int tilt(BinaryNode node){
        int leftSum=0;
        int rightSum=0;

        if(node.left==null && node.right==null){
            return node.data;
        }

        if(node.left!=null){
          leftSum+=tilt(node.left);
        }

        if(node.right!=null){
            rightSum+=tilt(node.right);
        }

        tilt+=Math.abs(leftSum-rightSum);

        return Math.abs(node.data+leftSum+rightSum);
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

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

            tilt(root);
            System.out.println(tilt);
        }
    }
}
