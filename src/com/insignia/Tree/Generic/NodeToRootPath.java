package com.insignia.Tree.Generic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class NodeToRootPath {

    public static ArrayList<Integer> nodeToRootPath(GenericTreeNode node, int data) {
        ArrayList<Integer> result = new ArrayList<>();

        if (node == null) {
            return new ArrayList<>();
        }

        if (node.data == data) {
            result.add(node.data);
            return result;
        }

        for (GenericTreeNode child : node.children) {

            ArrayList<Integer> path = nodeToRootPath(child, data);
            
            if (!path.isEmpty()) {
                path.add(node.data);
                result.addAll(path);
                return result;

            }
        }

        return result;

    }

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            int[] arr = new int[n];
            String[] values = reader.readLine().split(" ");
            for (int index = 0; index < n; index++) {
                arr[index] = Integer.parseInt(values[index]);
            }

            int data = Integer.parseInt(reader.readLine());

            GenericTreeNode root = Constructor.constructGenericTree(arr);
            System.out.println(nodeToRootPath(root, data));
        }

    }
}
