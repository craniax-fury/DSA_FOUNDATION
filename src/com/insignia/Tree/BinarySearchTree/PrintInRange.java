package com.insignia.Tree.BinarySearchTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintInRange {

    public static void pir(BSTNode node, int d1, int d2) {

        if(node==null){
            return;
        }

        if(d1<node.data){
            pir(node.left, d1, d2);
        }

        if(node.data>=d1 && node.data<=d2){
            System.out.println(node.data);
        }

        if(d2>node.data){
            pir(node.right, d1, d2);
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

            int d1 = Integer.parseInt(reader.readLine());
            int d2 = Integer.parseInt(reader.readLine());

            BSTNode root = Constructor.constructor(arr);

            pir(root, d1, d2);

        }
    }
}
