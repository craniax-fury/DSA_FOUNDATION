package com.insignia.Tree.binaryTree.viewsAndTraversals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.insignia.Tree.binaryTree.BinaryTreeNode;
import com.insignia.Tree.binaryTree.Constructor;

public class MorrisTraversal {

    public static void morrisTraversalPreOrder(BinaryTreeNode node) {
        if (node == null) {
            return;
        }

        BinaryTreeNode curr = node;

        while (curr != null) {
            System.out.print(curr.getData() + " ");

            if (curr.getLeft() != null) {
                BinaryTreeNode leftRightMost = getRightMostOfLeft(curr.getLeft());

                leftRightMost.setRight(curr.getRight());
                curr.setRight(null);
                curr = curr.getLeft();

            } else {
                curr = curr.getRight();
            }

        }

    }

    public static void morrisTraversalInOrder(BinaryTreeNode node) {
        if (node == null) {
            return;
        }

        BinaryTreeNode curr = node;

        while (curr != null) {

            if (curr.getLeft() != null) {
                BinaryTreeNode leftRightMost = getRightMostOfLeft(curr.getLeft());

                leftRightMost.setRight(curr);
                BinaryTreeNode temp = new BinaryTreeNode(curr.getLeft().getData(), curr.getLeft().getLeft(), curr.getLeft().getRight());

                curr.setLeft(null);
                curr = temp;

            } else {
                System.out.print(curr.getData() + " ");
                curr = curr.getRight();
            }

        }

    }

    private static BinaryTreeNode getRightMostOfLeft(BinaryTreeNode curr) {
        if (curr.getRight() == null) {
            return curr;
        }

        return getRightMostOfLeft(curr.getRight());
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
            //System.out.print("PreOrder:-> ");
            //MorrisTraversal.morrisTraversalPreOrder(root);

            //System.out.println();

            //System.out.print("InOrder:-> ");
            //MorrisTraversal.morrisTraversalInOrder(root);

        }
    }
}
