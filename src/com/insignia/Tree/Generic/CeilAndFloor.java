package com.insignia.Tree.Generic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CeilAndFloor {

    private static int ceil = Integer.MAX_VALUE;
    private static int floor = Integer.MIN_VALUE;

    public static void ceilAndFloor(GenericTreeNode node, int data) {
        if (node == null) {
            return;
        }

        if (node.data < data && node.data > floor) {
            floor = node.data;
        }

        if (node.data > data && node.data < ceil) {
            ceil = node.data;
        }

        for (GenericTreeNode child : node.children) {
            ceilAndFloor(child, data);

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
            int data = Integer.parseInt(reader.readLine());

            GenericTreeNode root = Constructor.constructGenericTree(arr);
            ceilAndFloor(root, data);

            System.out.println("Ceil = " + ceil);
            System.out.println("Floor = " + floor);

        }

    }
}
