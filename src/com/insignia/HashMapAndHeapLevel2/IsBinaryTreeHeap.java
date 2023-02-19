package com.insignia.HashMapAndHeapLevel2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.insignia.Tree.binaryTree.BinaryTreeNode;
import com.insignia.Tree.binaryTree.Constructor;

/*
* is implemented using heap , heap is a binary tree here with below mentioned properties
* HeapOrderProperty, completeBinaryTree
* HeapOrderProperty : parent has high property than child, allows peek to work in O(1)
* completeBinaryTree : h-1 level is complete and at h level, elements are filled from left to right
* , helps to achieve remove and add in O(log n) as with arraylist we can then apply formulae to determine
* the position of children and parent   
*/
public class IsBinaryTreeHeap {

    public static boolean isBinaryTreeHeap(BinaryTreeNode node) {
        if (node == null) {
            return true;
        }

        if (isCBT(node, 0, getNumberOfEle(node)) && isHop(node)) {
            return true;
        }

        return false;
    }

    private static boolean isHop(BinaryTreeNode node) {
        if (node == null) {
            return true;
        }

        if (node.getLeft() == null && node.getRight() == null) {
            return true;
        } else if (node.getRight() == null) {
            return node.getData() > node.getLeft().getData();
        } else {
            return isHop(node.getLeft()) && isHop(node.getRight()) && node.getData() >= node.getLeft().getData()
                    && node.getData() >= node.getRight().getData();
        }
    }

    private static int getNumberOfEle(BinaryTreeNode node) {
        int totalEle = 0;

        if (node == null) {
            return totalEle;
        }

        if (node.getLeft() != null) {
            totalEle += getNumberOfEle(node.getLeft());
        }

        if (node.getRight() != null) {
            totalEle += getNumberOfEle(node.getRight());
        }

        return totalEle + 1;
    }

    private static boolean isCBT(BinaryTreeNode node, int index, int totalEle) {
        if (node == null) {
            return true;
        }

        if (index >= totalEle) {
            return false;
        }

        if (node.getLeft() == null && node.getRight() == null) {
            return true;

        } else if (node.getRight() == null) {
            return isCBT(node.getLeft(), 2 * index + 1, totalEle);

        } else {
            return (isCBT(node.getLeft(), 2 * index + 1, totalEle) && isCBT(node.getRight(), 2 * index + 2, totalEle));
        }
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int n = Integer.parseInt(br.readLine());

            Integer[] data = new Integer[n];

            for (int index = 0; index < n; index++) {
                data[index] = Integer.parseInt(br.readLine());
            }

            BinaryTreeNode root = Constructor.constructor(data);
            System.out.println(isBinaryTreeHeap(root));
        }
    }
}
