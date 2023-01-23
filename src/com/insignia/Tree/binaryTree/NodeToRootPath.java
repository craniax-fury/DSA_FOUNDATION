package com.insignia.Tree.binaryTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class NodeToRootPath {

    public static boolean find(BinaryTreeNode node, int data) {
        if (node == null) {
            return false;
        }

        if (node.data == data) {
            return true;
        }

        if (find(node.left, data)) {
            return true;
        }

        if (find(node.right, data)) {
            return true;
        }

        return false;

    }

    public static ArrayList<Integer> nodeToRootPath(BinaryTreeNode node, int data) {

        ArrayList<Integer> nodeToRootPath = new ArrayList<>();

        if (node == null) {
            return nodeToRootPath;
        }

        if (node.data == data) {
            nodeToRootPath.add(node.data);
            return nodeToRootPath;
        }

        ArrayList<Integer> leftPath = nodeToRootPath(node.left, data);

        if (!leftPath.isEmpty()) {
            nodeToRootPath.addAll(leftPath);
            nodeToRootPath.add(node.data);
            return nodeToRootPath;
        }

        ArrayList<Integer> rightPath = nodeToRootPath(node.right, data);

        if (!rightPath.isEmpty()) {
            nodeToRootPath.addAll(rightPath);
            nodeToRootPath.add(node.data);
            return nodeToRootPath;
        }

        return nodeToRootPath;
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

            int data = Integer.parseInt(reader.readLine());

            BinaryTreeNode root = Constructor.constructor(arr);
            System.out.println(NodeToRootPath.nodeToRootPath(root, data));
        }
    }
}
