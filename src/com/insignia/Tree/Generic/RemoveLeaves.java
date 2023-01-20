package com.insignia.Tree.Generic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class RemoveLeaves {

    public static void removeLeaves(GenericTreeNode node) {

        if (node == null) {
            return;
        }

        Queue<GenericTreeNode> removeLeavesFilter = new ArrayDeque<>();

        for (GenericTreeNode child : node.children) {
            if (!child.children.isEmpty()) {
                removeLeavesFilter.add(child);
            }
        }

        node.children = new ArrayList<>();

        while (!removeLeavesFilter.isEmpty()) {
            node.children.add(removeLeavesFilter.remove());
        }
        
        for (GenericTreeNode child : node.children) {
            removeLeaves(child);
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
            removeLeaves(root);
            Display.display(root);

        }

    }
}
