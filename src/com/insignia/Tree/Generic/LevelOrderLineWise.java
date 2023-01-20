package com.insignia.Tree.Generic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class LevelOrderLineWise {

    public static void levelOrderLineWiseTraverse(GenericTreeNode node) {

        if (node == null) {
            return;
        }

        GenericTreeNode dummy = new GenericTreeNode(Integer.MIN_VALUE);

        Queue<GenericTreeNode> nodeQueue = new ArrayDeque<>();

        nodeQueue.add(node);
        nodeQueue.add(dummy);

        while (!(nodeQueue.size() == 1 && nodeQueue.peek().data == dummy.data)) {
            GenericTreeNode headNode = nodeQueue.remove();

            if (headNode.data == dummy.data) {
                System.out.println();
                nodeQueue.add(dummy);
            } else {
                System.out.print(headNode.data + " ");

                for (GenericTreeNode child : headNode.children) {
                    nodeQueue.add(child);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            int[] arr = new int[n];
            String[] values = reader.readLine().split(" ");
            for (int index = 0; index < n; index++) {
                arr[index] = Integer.parseInt(values[index]);
            }

            GenericTreeNode root = Constructor.constructGenericTree(arr);

            levelOrderLineWiseTraverse(root);

        }

    }
}
