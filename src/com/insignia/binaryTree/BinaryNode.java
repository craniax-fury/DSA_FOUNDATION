package com.insignia.binaryTree;

public class BinaryNode {

    int data;
    BinaryNode left;
    BinaryNode right;

    BinaryNode() {

    }

    BinaryNode(int data, BinaryNode left, BinaryNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}