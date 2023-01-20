package com.insignia.trees.genericTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Diameter {
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

    static int diameter = 0;

    public static int calcDiameterReturnHeight(TreeNode node) {
        int deepest = -1;
        int second_deepest = -1;

        for (TreeNode child : node.children) {
            int depth = calcDiameterReturnHeight(child);
            if (depth > deepest) {
                second_deepest = deepest;
                deepest = depth;
            } else if (depth > second_deepest) {
                second_deepest = depth;
            }
        }

        if (deepest + second_deepest + 2 > diameter) {
            diameter=deepest + second_deepest + 2;
        }
        return deepest+1;
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

            calcDiameterReturnHeight(root);
            System.out.println(diameter);

        }

    }

}
