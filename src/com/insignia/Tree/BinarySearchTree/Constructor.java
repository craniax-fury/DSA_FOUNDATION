package com.insignia.Tree.BinarySearchTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Pair {
    int state;
    BSTNode node;
}

public class Constructor {

    public static BSTNode constructor(Integer[] data) {
        Stack<Pair> stack = new Stack<>();

        int index = 0;

        BSTNode root = makeNode(data, index);
        Pair rootPair = makePair(root);

        stack.push(rootPair);

        index = 1;

        while (!stack.isEmpty()) {

            if (stack.peek().state == -1) {

                if (data[index] != null) {
                    stack.peek().state = 0;
                    BSTNode child = makeNode(data, index);
                    Pair pair = makePair(child);

                    stack.peek().node.left = child;
                    stack.push(pair);
                } else {
                    stack.peek().state = 0;
                }

                index++;

            } else if (stack.peek().state == 0) {
                if (data[index] != null) {
                    stack.peek().state = 1;
                    BSTNode child = makeNode(data, index);
                    Pair pair = makePair(child);

                    stack.peek().node.right = child;
                    stack.push(pair);
                } else {
                    stack.pop();
                }

                index++;

            } else {
                stack.pop();
            }

        }

        return root;
    }

    private static Pair makePair(BSTNode node) {
        Pair rootPair = new Pair();
        rootPair.state = -1;
        rootPair.node = node;
        return rootPair;
    }

    private static BSTNode makeNode(Integer[] data, int index) {
        BSTNode node = new BSTNode();
        node.data = data[index];
        return node;
    }

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int n = Integer.parseInt(reader.readLine());
            Integer[] arr = new Integer[n];
            String[] values = reader.readLine().split(" ");
            for (int index = 0; index < n; index++) {
                if (!(values[index].equals("n"))) {
                    arr[index] = Integer.parseInt(values[index]);
                } else {
                    arr[index] = null;
                }
            }

            BSTNode node = Constructor.constructor(arr);
            Utility.display(node);
        }
    }
}
