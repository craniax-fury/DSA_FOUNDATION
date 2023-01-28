package com.insignia.Tree.binaryTree.viewsAndTraversals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

import com.insignia.Tree.binaryTree.BinaryTreeNode;
import com.insignia.Tree.binaryTree.Constructor;

public class RightView {

    private static void rightView(BinaryTreeNode node) {

        Map<Integer, Integer> map = new HashMap<>();
        Queue<Pair> queue = new ArrayDeque<>();

        if (node == null) {
            return;
        }

        queue.add(new Pair(0, node));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            map.put(pair.vlevel, pair.node.getData());

            if (pair.node.getLeft() != null) {
                queue.add(new Pair(pair.vlevel + 1, pair.node.getLeft()));
            }

            if (pair.node.getRight() != null) {
                queue.add(new Pair(pair.vlevel + 1, pair.node.getRight()));
            }
        }

        for (Integer value : map.values()) {
            System.out.print(value + " ");
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
            RightView.rightView(root);
        }
    }
}
