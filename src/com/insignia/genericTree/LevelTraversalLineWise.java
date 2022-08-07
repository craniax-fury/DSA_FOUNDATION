package com.insignia.genericTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class LevelTraversalLineWise {

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

    /**
     * using delimiter to know the level
     */
    public static void levelOrderLinewiseApproach1(TreeNode node) {
        Queue<TreeNode> queue = new ArrayDeque<>();

        if (queue.isEmpty()) {
            queue.add(node);
            TreeNode pointer = new TreeNode();
            pointer.data = -1;
            queue.add(pointer);
        }

        while (!queue.isEmpty()) {

            TreeNode ele = queue.remove();
            if (ele.data != -1) {
                System.out.print(ele.data + " ");

            }
            for (TreeNode child : ele.children) {
                queue.add(child);
            }

            if (!(queue.isEmpty()) && queue.peek().data == -1) {
                System.out.println();
                queue.add(queue.remove());
            }
        }
    }

    /**
     * using mainQ and childQ
     */
    public static void levelOrderLinewiseApproach2(TreeNode node) {
        Queue<TreeNode> mainQ = new ArrayDeque<>();
        Queue<TreeNode> childQ = new ArrayDeque<>();

        if (mainQ.isEmpty()) {
            mainQ.add(node);
        }

        while (!mainQ.isEmpty()) {
            TreeNode mainNode = mainQ.remove();
            System.out.print(mainNode.data + " ");

            for (TreeNode child : mainNode.children) {
                childQ.add(child);
            }

            if (mainQ.isEmpty()) {

                System.out.println();

                mainQ = childQ;
                childQ = new ArrayDeque<>();
            }
        }
    }

    /**
     * using Pair class to add node with level
     */
    public static void levelOrderLinewiseApproach3(TreeNode node) {
        Queue<Pair> mainQ = new ArrayDeque<>();
        int level = 1;

        mainQ.add(new Pair(node, level));

        while (!mainQ.isEmpty()) {
            Pair pair = mainQ.remove();
            if (pair.level > level) {
                level = pair.level;
                System.out.println();
            }
            System.out.print(pair.getNode().data + " ");

            for (TreeNode child : pair.getNode().children) {
                mainQ.add(new Pair(child, level + 1));
            }
        }
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
            levelOrderLinewiseApproach3(root);

        }

    }
}
