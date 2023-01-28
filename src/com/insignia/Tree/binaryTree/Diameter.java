package com.insignia.Tree.binaryTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Diameter {

    public static int diameter(BinaryTreeNode node) {


        if(node==null){
            return 0;
        }

        int leftMaxEdges = height(node.left)+1;
        int rightMaxEdges = height(node.right)+1;
        
       
        return leftMaxEdges+rightMaxEdges;
    }

    private static int height(BinaryTreeNode node) {
        if(node==null){
            return -1;
        }

        int left = height(node.left);
        int right = height(node.right);

        return Math.max(left, right)+1;

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
            System.out.println(Diameter.diameter(root));
        }
    }
}
