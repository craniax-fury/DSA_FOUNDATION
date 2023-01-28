package com.insignia.Tree.binaryTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintSingleChildNode {

    public static void printSingleChildNodes(BinaryTreeNode node) {

        if (node == null) {
            return ;
        }

        printSingleChildNodes(node.left);
        printSingleChildNodes(node.right);

        if(node.left==null && node.right!=null){
            System.out.println(node.right.data);
        }else if(node.right==null && node.left!=null){
            System.out.println(node.left.data);
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
            PrintSingleChildNode.printSingleChildNodes(root);
        }
    }
}
