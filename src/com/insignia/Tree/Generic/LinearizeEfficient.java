package com.insignia.Tree.Generic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LinearizeEfficient {

    public static GenericTreeNode linearizeEfficient(GenericTreeNode node) {

        if (node == null) {
            return null;
        }

        if (node.children.size() == 0) {
            return node;
        }

        GenericTreeNode lct = linearizeEfficient(node.children.get(node.children.size() - 1));

        while (node.children.size() > 1) {
            GenericTreeNode lc = node.children.remove(node.children.size() - 1);
            GenericTreeNode slct = linearizeEfficient(node.children.get(node.children.size() - 1));
            slct.children.add(lc);
        }

        return lct;
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
            linearizeEfficient(root);
            Display.display(root);
        }

    }
}
