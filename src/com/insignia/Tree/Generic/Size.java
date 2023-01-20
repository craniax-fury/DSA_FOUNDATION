package com.insignia.Tree.Generic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Size {

    public static int size(GenericTreeNode node) {

        int size=0;

        if (node == null) {
            return size;
        }

        for (GenericTreeNode child : node.children) {
           size+= size(child);
        }

        return size+1;
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
            int size = size(root);
            System.out.println(size);

        }

    }
}
