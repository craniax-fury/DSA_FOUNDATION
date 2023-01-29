package com.insignia.Tree.binaryTree.viewsAndTraversals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

import com.insignia.Tree.binaryTree.BinaryTreeNode;
import com.insignia.Tree.binaryTree.Constructor;

class Pair {
    int vlevel;
    BinaryTreeNode node;

    Pair(int vlevel, BinaryTreeNode node) {
        this.vlevel = vlevel;
        this.node = node;
    }
}

public class VerticalView {

    private static void verticalTraversal(BinaryTreeNode node) {

        PriorityQueue<Integer> orderQueue = new PriorityQueue<>();

        Map<Integer, List<Integer>> map = new HashMap<>();
        Stack<Pair> stack = new Stack<>();

        if (node == null) {
            return;
        }

        stack.push(new Pair(0, node));

        while (!stack.isEmpty()) {

            Pair ele = stack.pop();

            updateMapWithData(ele, map);

            if (ele.node.getRight() != null) {
                stack.push(new Pair(ele.vlevel + 1, ele.node.getRight()));
            }

            if (ele.node.getLeft() != null) {
                stack.push(new Pair(ele.vlevel - 1, ele.node.getLeft()));
            }

        }

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            orderQueue.add(entry.getKey());
        }

        while (!orderQueue.isEmpty()) {
            for (Integer data : map.get(orderQueue.poll())) {
                System.out.print(data + " ");
            }
        }

    }

    private static void updateMapWithData(Pair pair, Map<Integer, List<Integer>> map) {
        if (map.containsKey(pair.vlevel)) {
            List<Integer> value = map.get(pair.vlevel);
            value.add(pair.node.getData());
            Collections.sort(value);

            map.put(pair.vlevel, value);
        } else {
            List<Integer> value = new ArrayList<>();
            value.add(pair.node.getData());

            map.put(pair.vlevel, value);
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
            VerticalView.verticalTraversal(root);

        }
    }
}
