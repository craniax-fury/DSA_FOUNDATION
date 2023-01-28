package com.insignia.Tree.binaryTree.viewsAndTraversals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

import com.insignia.Tree.binaryTree.BinaryTreeNode;
import com.insignia.Tree.binaryTree.Constructor;

class Pair {
    int vlevel;
    BinaryTreeNode node;

    Pair(int vLevel, BinaryTreeNode node) {
        this.vlevel = vLevel;
        this.node = node;
    }
}

public class TopViewAnotherApproach {

    private static void topView(BinaryTreeNode node) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        if (node == null) {
            return;
        }

        Stack<Pair> stack = new Stack<>();

        stack.push(new Pair(0, node));

        while (!stack.isEmpty()) {
            Pair ele = stack.pop();

            if(!map.containsKey(ele.vlevel)){
                map.put(ele.vlevel, ele.node.getData());

            }

            if (ele.node.getRight() != null) {
                stack.push(new Pair(ele.vlevel + 1, ele.node.getRight()));
            }

            if (ele.node.getLeft() != null) {
                stack.push(new Pair(ele.vlevel - 1, ele.node.getLeft()));
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.add(entry.getKey());
        }

        while (!queue.isEmpty()) {
            System.out.print(map.get(queue.poll()) + " ");
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
            TopViewAnotherApproach.topView(root);
        }
    }
}
