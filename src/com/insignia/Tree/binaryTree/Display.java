package com.insignia.Tree.binaryTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Display {

    public static void display(BinaryTreeNode node) {
        
        if(node==null){
            return;
        }

        if(node.left!=null){
            System.out.print(node.left.data+" <- ");
        }else{
            System.out.print(". <- ");
        }

        System.out.print(node.data+" -> ");

        if(node.right!=null){
            System.out.print(node.right.data);
        }else{
            System.out.print(".");
        }

        System.out.println();

        if(node.left!=null){
            display(node.left);
        }

        if(node.right!=null){
            display(node.right);
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
            Display.display(root);
        }
    }
}
