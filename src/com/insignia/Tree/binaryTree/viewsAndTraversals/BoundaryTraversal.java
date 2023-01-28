package com.insignia.Tree.binaryTree.viewsAndTraversals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

import com.insignia.Tree.binaryTree.BinaryTreeNode;
import com.insignia.Tree.binaryTree.Constructor;

public class BoundaryTraversal {

    public static void printBoundary(BinaryTreeNode node) {

        if (node == null) {
            return;
        }

        printLeftBoundary(node);

        printLeaves(node);

        printRightBoundary(node,new ArrayList<>());
    }

    private static void printRightBoundary(BinaryTreeNode node,ArrayList<Integer> data) {
        
        if(node==null){
            return;
        } 
        
        if(node.getRight()==null || node.getRight().getRight()==null){
            Collections.reverse(data);
            
            for(Integer dat: data){
                System.out.print(dat+" ");
            }

            return;
        }

        data.add(node.getRight().getData());
        
        printRightBoundary(node.getRight(), data);

    }

    private static void printLeaves(BinaryTreeNode node) {

        if (node == null) {
            return;
        }

        if (node.getLeft() == null && node.getRight() == null) {
            System.out.print(node.getData()+" ");
            return;
        }

        printLeaves(node.getLeft());
        printLeaves(node.getRight());
    }

    private static void printLeftBoundary(BinaryTreeNode node) {

        if (node == null || node.getLeft() == null) {
            return;
        }

        System.out.print(node.getData()+" ");

        printLeftBoundary(node.getLeft());
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
            BoundaryTraversal.printBoundary(root);
        }
    }
}
