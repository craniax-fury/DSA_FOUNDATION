package com.insignia.Tree.Generic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class NodePair {
    int state = -1;
    GenericTreeNode node = null;
}

public class IterativePreAndPostOrder {

    public static void iterativeAndPreAndPost(GenericTreeNode node) {
        Stack<NodePair> stack = new Stack<>();

        List<Integer> preOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();

        NodePair root = new NodePair();
        root.state = -1;
        root.node = node;

        stack.push(root);

        while (!stack.isEmpty()) {
            if (stack.peek().state == -1) {
                NodePair nodePairEle = stack.pop();
                preOrder.add(nodePairEle.node.data);
                nodePairEle.state = 0;
                stack.push(nodePairEle);

                for (int index = nodePairEle.node.children.size() - 1; index >= 0; index--) {
                    NodePair childPair = new NodePair();
                    childPair.state = -1;
                    childPair.node = nodePairEle.node.children.get(index);

                    stack.push(childPair);
                }

            } else {
                NodePair nodePairEle = stack.pop();
                postOrder.add(nodePairEle.node.data);
            }
        }

        for (Integer ele : preOrder) {
            System.out.print(ele + " ");
        }

        System.out.println();

        for (Integer ele : postOrder) {
            System.out.print(ele + " ");
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

            iterativeAndPreAndPost(root);
        }

    }
}
