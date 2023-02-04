package com.insignia.Tree.Generic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.insignia.Tree.BinarySearchTree.BSTNode;

public class Display {

    public static void display(GenericTreeNode node) {

        if (node == null) {
            return;
        }

        System.out.print(node.data + " -> ");
        for (GenericTreeNode child : node.children) {
            System.out.print(child.data + ", ");
        }
        System.out.println(".");

        for (GenericTreeNode child : node.children) {
            display(child);
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
            display(root);

        }

    }

    public static void display(BSTNode node) {
    }
}
