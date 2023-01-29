package com.insignia.Tree.binaryTree;

public class BinaryTreeNode {
    int data;
    BinaryTreeNode left;
    BinaryTreeNode right;

    BinaryTreeNode(){
    }

    public BinaryTreeNode(int data,BinaryTreeNode left,BinaryTreeNode right){
        this.data=data;
        this.left=left;
        this.right=right;
    }

    public int getData() {
        return data;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }
}
