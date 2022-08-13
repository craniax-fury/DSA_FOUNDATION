package com.insignia.genericTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class MaxSumSubTree {
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

    static class SumHolder {
        int node;
        int sum;
    }

    static SumHolder maxSumTree = new SumHolder();

    public static int maxSumSubTree(TreeNode node) {

        SumHolder childSumHolder = new SumHolder();

        for (TreeNode child : node.children) {
            childSumHolder.sum+= maxSumSubTree(child);
        }

        childSumHolder.sum += node.data;

        if (childSumHolder.sum > maxSumTree.sum) {
            maxSumTree.node = node.data;
            maxSumTree.sum = childSumHolder.sum;
        }

        return childSumHolder.sum;
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

            maxSumSubTree(root);
            System.out.println(maxSumTree.node + "@" + maxSumTree.sum);

        }

    }

}
