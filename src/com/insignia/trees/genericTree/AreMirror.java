package com.insignia.trees.genericTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class AreMirror {

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

    public static boolean areMirror(TreeNode n1, TreeNode n2) {
        if (n1.children.size() != n2.children.size()) {
            return false;
        }

        int till = 0;
        if (n1.children.size() % 2 == 0) {
            till = n1.children.size() / 2;
        } else {
            till = n1.children.size() / 2 + 1;
        }

        for (int n1Index = 0; n1Index < till; n1Index++) {
            int n2Index = n2.children.size() - 1 - n1Index;
            if (!areMirror(n1.children.get(n1Index), n2.children.get(n2Index))) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int[] input = new int[] { 10, 20, -1, 30, 50, -1, 60, -1, -1, 40, -1, -1 };

            int[] input2 = new int[] { 100, 200, -1, 300, 500, -1, 600, -1, -1, 400, -1, -1 };

            Stack<TreeNode> stack = new Stack<>();
            TreeNode root1 = new TreeNode();
            TreeNode root2 = new TreeNode();

            for (int index = 0; index < input.length; index++) {
                if (input[index] == -1) {
                    stack.pop();
                } else if (stack.size() == 0) {
                    root1.data = input[index];
                    stack.push(root1);
                } else {
                    TreeNode node = new TreeNode();
                    node.data = input[index];
                    stack.peek().children.add(node);
                    stack.push(node);
                }
            }

            for (int index = 0; index < input2.length; index++) {
                if (input2[index] == -1) {
                    stack.pop();
                } else if (stack.size() == 0) {
                    root2.data = input2[index];
                    stack.push(root2);
                } else {
                    TreeNode node = new TreeNode();
                    node.data = input2[index];
                    stack.peek().children.add(node);
                    stack.push(node);
                }
            }

            display(root1);
            display(root2);

            System.out.println("___________________________");

            boolean similar = areMirror(root1, root2);
            System.out.println(similar);

        }

    }
}
