package com.insignia.Tree.Generic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GenericTreeMultiSolver {

    static int size = 0;
    static int height = -1;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void multiSolver(GenericTreeNode node, int depth) {

        if (node == null) {
            return;
        }

        for (GenericTreeNode child : node.children) {
            multiSolver(child, depth + 1);
        }

        if (node.data > max) {
            max = node.data;
        }

        if (node.data < min) {
            min = node.data;
        }

        size += 1;

        if (height < depth) {
            height = depth;
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
            multiSolver(root,0);
            System.out.println("size " + size);
            System.out.println("height " + height);
            System.out.println("max " + max);
            System.out.println("min " + min);
        }

    }
}
