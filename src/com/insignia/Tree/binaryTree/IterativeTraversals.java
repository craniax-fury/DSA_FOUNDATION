package com.insignia.Tree.binaryTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Pair {
    int state;
    BinaryTreeNode node;
}

public class IterativeTraversals {

    public static void iterativeTraversal(BinaryTreeNode node) {

        Stack<Pair> stack = new Stack<>();

        List<Integer> preorder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();

        Pair rootPair = new Pair();
        rootPair.state = -1;
        rootPair.node = node;

        stack.push(rootPair);

        while (!stack.isEmpty()) {

            Pair nodeEle = stack.peek();

            if (nodeEle.state == -1) {
                preorder.add(nodeEle.node.data);

                nodeEle.state = 0;

                if (nodeEle.node.left != null) {
                    Pair leftPair = new Pair();
                    leftPair.state = -1;
                    leftPair.node = nodeEle.node.left;
                    stack.push(leftPair);
                }

            } else if (nodeEle.state == 0) {
                nodeEle.state = 1;
                inOrder.add(nodeEle.node.data);

                if (nodeEle.node.right != null) {
                    Pair rightPair = new Pair();
                    rightPair.state = -1;
                    rightPair.node = nodeEle.node.right;
                    stack.push(rightPair);
                }

            } else {
                postOrder.add(stack.pop().node.data);
            }
        }

        for (Integer data : preorder) {
            System.out.print(data+" ");
        }

        System.out.println();

        for (Integer data : inOrder) {
            System.out.print(data+" ");
        }

        System.out.println();

        for (Integer data : postOrder) {
            System.out.print(data+" ");
        }

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

            BinaryTreeNode root = Constructor.constructor(arr);
            IterativeTraversals.iterativeTraversal(root);
        }
    }
}
